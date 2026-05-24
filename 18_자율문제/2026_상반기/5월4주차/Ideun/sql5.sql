select
  city_id
  , customer_id
  , max(sales) as total_spent
from (select
  city_id
  , customer_id
  , sum(total_price-discount_amount) as sales
from transactions
where is_returned = false
group by city_id, customer_id)
group by city_id
