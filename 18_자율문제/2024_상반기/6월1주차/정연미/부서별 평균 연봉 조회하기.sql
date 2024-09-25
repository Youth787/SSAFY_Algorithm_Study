select b.DEPT_ID, a.DEPT_NAME_EN, round(avg(b.SAL),0) as AVG_SAL
from HR_DEPARTMENT a 
join HR_EMPLOYEES b on a.DEPT_ID = b.DEPT_ID
group by b.DEPT_ID
order by AVG_SAL desc;
