SELECT COUNT(*) AS FISH_COUNT, b.FISH_NAME
FROM FISH_INFO a 
JOIN FISH_NAME_INFO b ON a.FISH_TYPE = b.FISH_TYPE
GROUP BY a.FISH_TYPE, b.FISH_NAME
ORDER BY 1 DESC;

# Group by b.fish_name group by에 한번 더 쓰거나 집계함수 사용해서 select절에 사용하거나 - 안그러면 오류난다. 
