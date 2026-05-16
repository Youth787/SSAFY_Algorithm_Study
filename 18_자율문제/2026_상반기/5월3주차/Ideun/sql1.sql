with sub_category_sales as (
  select
    category
    , sub_category
    , sum(sales) as sales_sub_category
  from records
  group by
    category
    , sub_category
)

select
  category
  , sub_category
  , round(sales_sub_category,2) as sales_sub_category
  , round(sum(sales_sub_category) over(partition by category),2) as sales_category
  , round(sum(sales_sub_category) over(),2) as sales_total
  , round(sales_sub_category/sum(sales_sub_category) over(partition by category)*100,2)as pct_in_category
  , round(sales_sub_category/sum(sales_sub_category)over()*100,2) as pct_in_total
from sub_category_sales