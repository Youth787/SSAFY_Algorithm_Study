select
  order_date
  ,CASE strftime('%w', order_date)
      WHEN '0' THEN 'Sunday'
      WHEN '1' THEN 'Monday'
      WHEN '2' THEN 'Tuesday'
      WHEN '3' THEN 'Wednesday'
      WHEN '4' THEN 'Thursday'
      WHEN '5' THEN 'Friday'
      WHEN '6' THEN 'Saturday'
    END AS weekday
  , num_orders_today
  , num_orders_today + lag(num_orders_today,1,0)
    over(order by order_date) as num_orders_from_yesterday
from (select
  date(purchased_at) as order_date
  ,count(transaction_id) as num_orders_today
from transactions
where purchased_at between '2023-11-01 00:00:00'
                    and '2024-01-01 00:00:00'
      and is_online_order = true
group by DATE(purchased_at))
