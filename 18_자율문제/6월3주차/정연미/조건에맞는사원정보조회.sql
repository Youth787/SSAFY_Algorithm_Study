select sum(SCORE) as SCORE, 
a.EMP_NO, EMP_NAME, POSITION, EMAIL
from HR_EMPLOYEES a 
join HR_GRADE b on
a.EMP_NO = b.EMP_NO
group by EMP_NO
order by score desc
limit 1;
