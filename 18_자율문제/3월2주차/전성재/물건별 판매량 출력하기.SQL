SELECT product_id, SUM(amount)
FROM sale
GROUP BY product_id
HAVING COUNT(product_id) > 1;
