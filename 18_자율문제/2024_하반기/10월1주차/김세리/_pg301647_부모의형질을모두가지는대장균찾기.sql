WITH A AS (SELECT ID, GENOTYPE
          FROM ECOLI_DATA
          )

SELECT E.ID, E.GENOTYPE, A.GENOTYPE AS PARENT_GENOTYPE
FROM ECOLI_DATA E
JOIN A ON E.PARENT_ID = A.ID
# 부모의 유전자형을 포함하는 조건: =부모유전자형
# 연산의 결과가 완전히 일치해야 하는 조건: =1
WHERE E.GENOTYPE & A.GENOTYPE = A.GENOTYPE
ORDER BY E.ID;
