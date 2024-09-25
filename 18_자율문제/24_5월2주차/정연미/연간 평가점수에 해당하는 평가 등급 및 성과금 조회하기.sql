SELECT
    e.emp_no,
    e.emp_name,
    CASE 
        WHEN AVG(score) >= 96 THEN 'S'
        WHEN AVG(score) >= 90 THEN 'A'
        WHEN AVG(score) >= 80 THEN 'B'
        ELSE 'C'
    END AS grade,
    CASE 
        WHEN AVG(score) >= 96 THEN e.sal * 0.2
        WHEN AVG(score) >= 90 THEN e.sal * 0.15
        WHEN AVG(score) >= 80 THEN e.sal * 0.1
        ELSE e.sal * 0
    END AS bonus
FROM hr_employees e
JOIN hr_grade g
ON e.emp_no = g.emp_no
GROUP BY e.emp_no
ORDER BY e.emp_no

-- case when ~~ then 
--         when ~~ then 
--         else 
-- end as 'column명'


