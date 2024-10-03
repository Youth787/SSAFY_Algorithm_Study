WITH A AS ( SELECT ID, SIZE_OF_COLONY,
                     # 내림차순으로 정렬해서 각 행에 대해 순위를 부여.
                     # ROW_NUMBER() 는 각 행에 대해 고유 순위를 부여하고, 중복 순위를 허용하지 않음. 
                    ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY DESC) AS RANKING,
                     # COUNT(*) OVER () : 전체 데이터의 개수를 구하는 윈도우 함수.
                     # 전체 행에 전체 데이터 개수의 값이 동일하게 반환됨.
                    COUNT(*) OVER () AS TOTAL_COUNT
            FROM ECOLI_DATA)

SELECT ID, CASE WHEN RANKING <= TOTAL_COUNT * 0.25 THEN 'CRITICAL'
                WHEN RANKING <= TOTAL_COUNT * 0.50 THEN 'HIGH'
                WHEN RANKING <= TOTAL_COUNT * 0.75 THEN 'MEDIUM'
                ELSE 'LOW' END AS COLONY_NAME
FROM A
ORDER BY ID;
