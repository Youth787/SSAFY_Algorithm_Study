https://school.programmers.co.kr/learn/courses/30/lessons/299308#
분기별 분화된 대장균의 개체 수 구하기

# SELECT 
# CASE WHEN MONTH(DIFFERENTIATION_DATE) BETWEEN '01' AND '03' THEN '1Q'
# WHEN MONTH(DIFFERENTIATION_DATE) BETWEEN '04' AND '06' THEN '2Q'
# WHEN MONTH(DIFFERENTIATION_DATE) BETWEEN '07' AND '09' THEN '3Q'
# WHEN MONTH(DIFFERENTIATION_DATE) BETWEEN '10' AND '12' THEN '4Q'END AS QUARTER,
# COUNT(*) AS ECOLI_COUNT
# FROM ECOLI_DATA
# GROUP BY 1
# ORDER BY 1;

SELECT 
CONCAT(
    CASE WHEN MONTH(DIFFERENTIATION_DATE) <=3 THEN 1
    WHEN MONTH(DIFFERENTIATION_DATE) <=6 THEN 2
    WHEN MONTH(DIFFERENTIATION_DATE) <=9 THEN 3
    ELSE 4 END,'Q'
)AS QUARTER, 
COUNT(ID) AS ECOLI_COUNT
FROM ECOLI_DATA
GROUP BY QUARTER
ORDER BY QUARTER;

/*
case when , then, else, end 
concat
*/
---------------------------------------

https://school.programmers.co.kr/learn/courses/30/lessons/59410
# NULL 처리하기

SELECT ANIMAL_TYPE,
CASE WHEN NAME IS NULL THEN 'No name' 
ELSE NAME END AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

/* IS NULL */

---------------------------------------

https://school.programmers.co.kr/learn/courses/30/lessons/59411
오랜 기간 보호한 동물(2)

SELECT a.ANIMAL_ID, a.NAME
FROM ANIMAL_INS a 
join ANIMAL_OUTS b on a.ANIMAL_ID = b.ANIMAL_ID	
order by DATEDIFF(b.DATETIME, a.DATETIME) desc limit 2;

/* DATEDIFF */

---------------------------------------
https://school.programmers.co.kr/learn/courses/30/lessons/301649
대장균의 크기에 따라 분류하기 2

SELECT ID,
CASE WHEN RANK_SIZE <= ((SELECT COUNT(*) FROM ECOLI_DATA)*0.25) THEN 'CRITICAL'
     WHEN RANK_SIZE <= ((SELECT COUNT(*) FROM ECOLI_DATA)*0.50) THEN 'HIGH'
     WHEN RANK_SIZE <= ((SELECT COUNT(*) FROM ECOLI_DATA)*0.75) THEN 'MEDIUM' 
     ELSE 'LOW' END AS COLONY_NAME
FROM (
    SELECT ID, RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) AS RANK_SIZE
    FROM ECOLI_DATA
) AS AA
ORDER BY 1;

/* RANK() OVER -> 1등이 2명이면 그 다음은 3등으로 표기된다. 1, 1 ,3,4 이런식. 
    DENSE_RANK() OVER 이면 1,1,2,3 이런식으로 표기된다. 
*/

---------------------------------------
https://school.programmers.co.kr/learn/courses/30/lessons/59047


SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE NAME like '%el%' and ANIMAL_TYPE = 'Dog'
ORDER BY NAME;

/* 포함하는 
like '%포함하는단어%' */
