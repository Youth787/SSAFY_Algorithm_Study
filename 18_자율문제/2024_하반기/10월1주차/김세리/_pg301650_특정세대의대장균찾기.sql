# 내가 푼 풀이: 2세대, 3세대 구하고 그중에 4세대인거 제외
# WITH A AS (SELECT ID, PARENT_ID
#           FROM ECOLI_DATA
#           WHERE PARENT_ID IS NOT NULL),
# B AS (SELECT ID, PARENT_ID
#           FROM A
#           WHERE PARENT_ID IN (SELECT ID FROM A))
          
# SELECT THIRD.ID
# FROM B THIRD
# LEFT JOIN B FOURTH ON THIRD.PARENT_ID = FOURTH.ID
# WHERE FOURTH.ID IS NULL
# ORDER BY THIRD.ID;

# 재귀식을 이용해서 모든 케이스의 세대를 작성하는 테이블을 만들고,
# 그 테이블에서 3세대인 애들만 SELECT

-- WITH RECURSIVE 절: 재귀적 쿼리 작성을 위한 것.
-- 기초 데이터를 가져오고, 그걸 바탕으로 재귀적으로 새로운 데이터를 쌓아 올림.
WITH RECURSIVE GenerationTree AS (
    -- 여기는 한 번만 실행되는 쿼리
    -- 1세대: 부모가 없는 대장균, 처음엔 1세대로 시작.
    SELECT ID, PARENT_ID, 1 AS Generation
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL

    UNION ALL
    
    -- 2세대부터는 부모가 있는 대장균을 재귀적으로 탐색
    -- 여기 아래의 재귀 쿼리가 반복적으로 실행됨.
    -- 각 세대 정보를 기반으로 다음 세대의 데이터를 찾아서 추가.
    -- 1세대 정보를 바탕으로 2세대를 찾고, 테이블에 추가 -> 3세대 찾고, 추가 -> 4세대 찾고, 추가
    -- 더이상 추가할 자식 세대가 없으면 재귀 멈추고 GenerationTree 테이블 완성됨.
    
    SELECT E.ID, E.PARENT_ID, G.Generation + 1
    FROM ECOLI_DATA E
    JOIN GenerationTree G ON E.PARENT_ID = G.ID
)

-- 3세대 대장균을 필터링
SELECT ID
FROM GenerationTree
WHERE Generation = 3
ORDER BY ID;
