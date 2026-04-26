WITH FirstCorrect AS (
    -- 1. 유저별로 각 문제를 처음 맞힌 시각과 점수를 조회
    SELECT 
        s.user_id, 
        s.problem_id, 
        p.score,
        MIN(s.timestamp) AS first_time
    FROM submissions s
    JOIN problems p ON s.problem_id = p.problem_id
    WHERE s.submitted = p.correct_answer
    GROUP BY s.user_id, s.problem_id, p.score
),
Penalties AS (
    -- 2. 정답을 맞힌 문제에 대해서만, 최초 정답 이전의 오답 횟수(300초씩) 계산
    SELECT 
        fc.user_id,
        fc.problem_id,
        fc.score,
        fc.first_time,
        COUNT(s.user_id) * 300 AS penalty_sum
    FROM FirstCorrect fc
    LEFT JOIN submissions s ON fc.user_id = s.user_id 
        AND fc.problem_id = s.problem_id
        AND s.timestamp < fc.first_time
    GROUP BY fc.user_id, fc.problem_id, fc.score, fc.first_time
)
,
FinalStats AS (
    -- 3. 유저별 최종 점수 합계 및 시간 계산
    -- 한 번 이상 답을 제출한 모든 유저를 대상으로 함
    SELECT 
        sub.user_id,
        NVL(SUM(p.score), 0) AS total_score,
        NVL(MAX(p.first_time), 0) + NVL(SUM(p.penalty_sum), 0) AS TIME_TAKEN
    FROM (SELECT DISTINCT user_id FROM submissions) sub
    LEFT JOIN Penalties p ON sub.user_id = p.user_id
    GROUP BY sub.user_id
)

-- 4. 결과 출력 및 정렬
SELECT 
    user_id, 
    total_score, 
    TIME_TAKEN
FROM FinalStats
ORDER BY 
    total_score DESC, 
    TIME_TAKEN ASC, 
    user_id ASC;
