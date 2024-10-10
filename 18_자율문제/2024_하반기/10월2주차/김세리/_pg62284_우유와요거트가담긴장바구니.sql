# 다른 풀이
SELECT CART_ID
FROM CART_PRODUCTS
WHERE NAME IN ('Milk', 'Yogurt')
GROUP BY CART_ID
# 장바구니에 요거트, 우유 모두 있는 경우만 필터링.
#  DISTINCT 사용해서 혹시라도 중복되는 경우 방지(ex. 우유만 두 번 산 경우)
HAVING COUNT(DISTINCT NAME) =2;



# 내가 푼 풀이
# WITH A AS (SELECT CART_ID
#           FROM CART_PRODUCTS
#           WHERE NAME='Yogurt'),
# B AS (SELECT CART_ID
#      FROM CART_PRODUCTS
#      WHERE NAME='Milk')
     
# SELECT DISTINCT(A.CART_ID)
# FROM A, B
# WHERE A.CART_ID=B.CART_ID;
