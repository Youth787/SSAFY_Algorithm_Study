SELECT D.DEPT_ID, D.DEPT_NAME_EN, ROUND(AVG(E.SAL), 0) AS AVG_SAL
FROM HR_DEPARTMENT AS D
RIGHT JOIN HR_EMPLOYEES AS E
ON D.DEPT_ID = E.DEPT_ID
GROUP BY E.DEPT_ID
ORDER BY AVG_SAL DESC
