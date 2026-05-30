/*
[윈도우 함수]

NVL(값1, 값2): 값1이 NULL이면 값2로 대체
NVL2(값1, 값2, 값3): 값1이 NULL이 아니면 값2, NULL이면 값3을 반환

SUBSTR(문자, 시작위치, 길이)
INSTR(문자, 찾을문자)

ROUND(COL,1)
ROUND(COL,-1) > 일의 자리 0
TRUC(COL,2) > 소수점 둘째자리 밑은 절삭

ROW_NUMBER() > 1,2,3
RANK() > 1,1,3
DENSE_RANK() > 1,1,2

ADD_MONTHS(날짜, 더할_개월_수)

LAG(컬럼, 칸수, 가져올행이 없을때 넣을 값): 현재 행보다 위(이전)에 있는 행의 값을 가져옵니다. (이전 데이터)
LEAD(컬럼, 칸수): 현재 행보다 아래(다음)에 있는 행의 값을 가져옵니다. (다음 데이터)

NTILE(4): 전체 데이터를 4개의 그룹(1등급~4등급)으로 나눕니다.
*/

WITH CNT AS (
    SELECT COUNT(*) AS CNT
    FROM USER_INFO
    WHERE EXTRACT (YEAR FROM JOINED) = '2021'
)

SELECT
    EXTRACT (YEAR FROM OS.SALES_DATE) AS YEAR
    , EXTRACT (MONTH FROM OS.SALES_DATE) AS MONTH
    , COUNT(DISTINCT OS.USER_ID) AS PURCASED_USERS
    , ROUND(COUNT(DISTINCT OS.USER_ID) / (SELECT CNT FROM CNT),1) AS PUCHASED_RATIO
FROM
    USER_INFO UI
    JOIN ONLINE_SALE OS
    ON UI.USER_ID = OS.USER_ID
    AND EXTRACT (YEAR FROM UI.JOINED) = '2021'
GROUP BY
    EXTRACT (YEAR FROM OS.SALES_DATE)
    , EXTRACT (MONTH FROM OS.SALES_DATE)
ORDER BY 1,2