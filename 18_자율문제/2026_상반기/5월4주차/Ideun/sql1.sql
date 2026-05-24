with a as (select
  category
  , sub_category
  , sum(sales) as sub_category_sum
from records
group by category, sub_category)

select
  a.category
  , a.sub_category
  , round(a.sub_category_sum,2) as sales_sub_category
  , round(sum(a.sub_category_sum) over(PARTITION by a.category),2) as sales_category
  , round(sum(a.sub_category_sum) over(),2) as sales_total
  , round(a.sub_category_sum *100 / sum(a.sub_category_sum) over(partition by category),2) as pct_in_category
  , round(a.sub_category_sum  / sum(a.sub_category_sum) over() *100 ,2) as pct_in_total
from a