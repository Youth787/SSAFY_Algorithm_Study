SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE (CATEGORY, PRICE) IN (
        SELECT CATEGORY, MAX(PRICE)
        FROM FOOD_PRODUCT
        WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
        GROUP BY CATEGORY)
ORDER BY PRICE DESC;

-- GROUP BY 절은 집계 함수가 아닌 다른 컬럼들에 대해서는 해당 그룹의 대표값을 선택하는 방법을 SQL이 자동으로 결정할 수 없기 때문에,
-- PRODUCT_NAME을 직접적으로 선택할 수 없다.
-- 집계 함수를 사용하지 않는 한 GROUP BY 절에 나열된 모든 필드를 SELECT 절에 포함시켜야 한다.
-- 따라서 처음에 작성한 아래 식은 잘못되었다.

-- SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE, PRODUCT_NAME
-- FROM FOOD_PRODUCT
-- WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
-- GROUP BY CATEGORY
-- ORDER BY MAX_PRICE DESC;
