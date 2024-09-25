-- USED_GOODS_BOARD와 USED_GOODS_REPLY 테이블에서 (두 테이블을 BOARD_ID를 기준으로 INNER JOIN = 두 테이블 모두에서 BOARD_ID가 같은 행들만 결합, 반환)
-- 2022년 10월에 작성된 
-- 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 조회하는 SQL문을 작성해주세요. 
-- 결과는 댓글 작성일을 기준으로 오름차순 정렬해주시고, 댓글 작성일이 같다면 게시글 제목을 기준으로 오름차순 정렬해주세요.
-- CREATED_DATE의 포맷이 예시의 포맷과 일치. (DATE_FORMAT 사용하고, AS CREATED_DATE 또는 "CREATED_DATE" 로 이름


SELECT B.TITLE, R.BOARD_ID, R.REPLY_ID, R.WRITER_ID, R.CONTENTS, DATE_FORMAT(R.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE FROM USED_GOODS_REPLY R INNER JOIN USED_GOODS_BOARD B ON R.BOARD_ID = B.BOARD_ID WHERE B.CREATED_DATE LIKE '2022-10%' ORDER BY R.CREATED_DATE, B.TITLE
