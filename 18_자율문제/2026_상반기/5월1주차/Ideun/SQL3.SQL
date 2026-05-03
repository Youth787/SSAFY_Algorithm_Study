WITH FirstCorrect AS (
    -- 1. 유저별로 각 문제를 처음 맞힌 시각과 점수를 조회
    SELECT
        S.USER_ID
        , S.PROBLEM_ID
        , MIN(S.TIMESTAMP) AS FIRST_TIME
        , P.SCORE
    FROM SUBMISSIONS S
        JOIN PROBLEMS P 
        ON S.PROBLEM_ID = P.PROBLEM_ID 
    WHERE S.SUBMITTED = P.CORRECT_ANSWER
    GROUP BY S.USER_ID, S.PROBLEM_ID, P.SCORE
)
,
Penalties AS (
    -- 2. 정답을 맞힌 문제에 대해서만, 최초 정답 이전의 오답 횟수(300초씩) 계산
    SELECT 
        F.USER_ID
        , F.PROBLEM_ID
        , F.FIRST_TIME
        , F.SCORE
        , COUNT(S.USER_ID) * 300 AS PENALTY
    FROM FirstCorrect F
    LEFT JOIN SUBMISSIONS S ON F.USER_ID = S.USER_ID
    AND F.PROBLEM_ID = S.PROBLEM_ID
    AND F.FIRST_TIME > S.TIMESTAMP 
    GROUP BY F.USER_ID, F.PROBLEM_ID, F.SCORE, F.FIRST_TIME
)
,
FinalStats AS (
    -- 3. 유저별 최종 점수 합계 및 시간 계산
    -- 한 번 이상 답을 제출한 모든 유저를 대상으로 함
    SELECT 
        S.USER_ID
        , NVL(SUM(P.SCORE),0) AS TOTAL_SCORE
        , NVL(MAX(P.FIRST_TIME),0)+ NVL(SUM(P.PENALTY),0) AS TIME_TAKEN
    FROM (SELECT DISTINCT USER_ID AS USER_ID FROM SUBMISSIONS) S
        LEFT JOIN Penalties P
        ON S.USER_ID = P.USER_ID
    GROUP BY S.USER_ID 
)

-- 4. 결과 출력 및 정렬
SELECT 
    USER_ID
    , TOTAL_SCORE
    , TIME_TAKEN
FROM FinalStats
ORDER BY TOTAL_SCORE DESC, TIME_TAKEN , USER_ID 
