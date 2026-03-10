SELECT DISTINCT(UGU.USER_ID),
               UGU.NICKNAME,
               UGU.CITY || ' ' || UGU.STREET_ADDRESS1 || ' ' || STREET_ADDRESS2 AS 전체주소,
               SUBSTR(UGU.TLNO ,1,3) || '-' || SUBSTR(UGU.TLNO,4,4) || '-' || SUBSTR(UGU.TLNO,8) AS 전화번호
FROM
    (
        SELECT WRITER_ID,
               COUNT(*) OVER(PARTITION BY WRITER_ID) as CNT
        FROM USED_GOODS_BOARD
    ) UGB
   , USED_GOODS_USER UGU
WHERE UGB.WRITER_ID = UGU.USER_ID
  AND UGB.CNT >=3
ORDER BY UGU.USER_ID DESC

/*
|| : 문자열 붙이기
SUBSTR(컬럼, 시작위치, 가져올 길이)
*/