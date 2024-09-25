SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(USER_ID)>=2
ORDER BY USER_ID, PRODUCT_ID DESC;

-- 유저 아이디, 상품 아이디가 같은 애들을 group으로 묶고(두 개가 모두 같을 때만 그룹이 된다)
-- 그 중에서 유저 아이디 카운트가 2 이상인 경우를 고르는 조건을 having으로 준다
