WITH RECURSIVE GENERATIONTREE AS (
        SELECT ID, PARENT_ID, 1 AS GENERATION
        FROM ECOLI_DATA
        WHERE PARENT_ID IS NULL

        UNION ALL
        
        SELECT E.ID, E.PARENT_ID, G.GENERATION+1
        FROM ECOLI_DATA E
        JOIN GENERATIONTREE G ON G.ID = E.PARENT_ID
        )
        
SELECT COUNT(G.ID) AS COUNT, G.GENERATION
FROM GENERATIONTREE G
LEFT JOIN ECOLI_DATA E ON E.PARENT_ID=G.ID -- G.ID가 PARENT로 쓰였는지 아닌지 판단하기 위해
WHERE E.ID IS NULL -- 자식이 없는 개체 필터링(NULL 이란건 자식의 부모로 쓰이지 않았단 의미)
GROUP BY G.GENERATION
ORDER BY G.GENERATION;
