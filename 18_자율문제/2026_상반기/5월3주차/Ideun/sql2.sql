select 
  to_char(order_date , 'YYYY-MM') as order_month
  , sum(case when oi.order_id not like 'C%' then oi.price * oi.quantity else 0 END) as ordered_amount
  , sum(case when oi.order_id like 'C%' then -1*abs(oi.price*oi.quantity) else 0 END) as canceled_amount
  , sum(case when oi.order_id not like 'C%' then oi.price * oi.quantity else 0 END)
   + sum(case when oi.order_id like 'C%' then -1*abs(oi.price*oi.quantity) else 0 END) as total_amount
from orders o 
join order_items oi on o.order_id = oi.order_id
group by to_char(order_date , 'YYYY-MM')
