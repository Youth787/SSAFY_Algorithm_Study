-- BOOK 테이블에서 
-- 2021년에 출판된 '인문' 카테고리에 속하는 도서 리스트를 찾아서 
-- 도서 ID(BOOK_ID), 출판일 (PUBLISHED_DATE)을 출력.
-- 결과는 출판일을 기준으로 오름차순 정렬.
-- PUBLISHED_DATE의 데이트 포맷이 예시와 동일해야 정답처리 = DATE_FORMAT 을 0000-00-00로 변경
SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS  PUBLISHED_DATE FROM BOOK WHERE CATEGORY LIKE '인문' AND PUBLISHED_DATE LIKE '2021%' ORDER BY PUBLISHED_DATE ASC

