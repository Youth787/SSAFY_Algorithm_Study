SELECT
    MP.MEMBER_NAME
    , RR.REVIEW_TEXT
    , TO_CHAR(RR.REVIEW_DATE, 'YYYY-MM-DD') AS REVIEW_DATE
FROM
    MEMBER_PROFILE MP
    , REST_REVIEW RR
WHERE 1=1
    AND MP.MEMBER_ID = RR.MEMBER_ID
    AND MEMBER_NAME IN
    (
        SELECT MEMBER_NAME
        FROM (
                SELECT
                    MP.MEMBER_NAME
                    , RANK() OVER (ORDER BY COUNT(*) DESC) AS RANK
                FROM
                    MEMBER_PROFILE MP
                    , REST_REVIEW RR
                WHERE MP.MEMBER_ID = RR.MEMBER_ID
                GROUP BY MEMBER_NAME
            )
        WHERE RANK = 1
    )
ORDER BY
    RR.REVIEW_DATE
    , RR.REVIEW_TEXT
