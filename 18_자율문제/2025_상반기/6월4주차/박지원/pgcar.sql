WITH T AS (
    SELECT C.DAILY_FEE, C.CAR_TYPE, H.HISTORY_ID, DATEDIFF(H.END_DATE, H.START_DATE) + 1 AS PERIOD,
    CASE
        WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 90 THEN '90일 이상'
        WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 30 THEN '30일 이상'
        WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 7 THEN '7일 이상'
        ELSE 'NONE' END AS DURATION_TYPE
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H
    INNER JOIN CAR_RENTAL_COMPANY_CAR AS C
    ON C.CAR_ID = H.CAR_ID
    WHERE C.CAR_TYPE = '트럭'
)

SELECT T.HISTORY_ID, ROUND(T.DAILY_FEE * T.PERIOD * (100 - IFNULL(P.DISCOUNT_RATE, 0)) / 100) AS FEE
FROM T
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS P
ON P.DURATION_TYPE = T.DURATION_TYPE
AND P.CAR_TYPE = T.CAR_TYPE
ORDER BY 2 DESC, 1 DESC
