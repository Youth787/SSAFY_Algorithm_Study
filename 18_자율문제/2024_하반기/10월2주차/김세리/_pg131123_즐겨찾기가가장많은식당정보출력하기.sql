WITH A AS (SELECT FOOD_TYPE, MAX(FAVORITES) AS MAXFAVOR
          FROM REST_INFO
          GROUP BY FOOD_TYPE)

SELECT I.FOOD_TYPE, I.REST_ID, I.REST_NAME, I.FAVORITES
FROM REST_INFO I
JOIN A ON I.FAVORITES=A.MAXFAVOR AND I.FOOD_TYPE=A.FOOD_TYPE
ORDER BY FOOD_TYPE DESC;

# GROUP BY와 MAX()의 동작 방식 때문에 오답이 발생할 수 있다.
# 같이 사용하면 그룹화된 결과에서 최대값을 구하지만, 그 최대값에 해당하는 나머지 필드를 정확하게 가져오지 못한다
# 최댓값인 FAVORITES는 제대로 실행되지만 그에 대응되는 레스토랑 식당의 이름을 제대로 찾지 못하는걸 발견할 수 있다
# (위 정답코드와 아래 오답코드 실행해서 비교해볼 것)

# SELECT FOOD_TYPE, REST_ID, REST_NAME, MAX(FAVORITES) AS FAVORITES
# FROM REST_INFO
# GROUP BY FOOD_TYPE
# ORDER BY FOOD_TYPE DESC;
