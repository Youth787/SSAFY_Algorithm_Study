select region as Region,
count(distinct(case when category='Furniture' then order_id end)) as 'Furniture',
count(distinct(case when category='Office Supplies' then order_id end)) as 'Office Supplies',
count(distinct(case when category='Technology' then order_id end)) as 'Technology'
from records
group by region
order by region;