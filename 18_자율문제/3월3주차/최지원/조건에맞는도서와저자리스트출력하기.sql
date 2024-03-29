SELECT B.BOOK_ID, A.AUTHOR_NAME,
    DATE_FORMAT(B.PUBLISHED_DATE,'%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK B, AUTHOR A
WHERE CATEGORY = '경제'
    AND A.AUTHOR_ID = B.AUTHOR_ID
ORDER BY PUBLISHED_DATE;
