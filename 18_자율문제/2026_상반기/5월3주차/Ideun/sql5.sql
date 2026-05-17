select
  category,
  sub_category,
  count(distinct (r.order_id)) as cnt_orders
from
  records r
  join customer_stats cs on r.customer_id = cs.customer_id
where
  (r.customer_id, r.order_date) in (
    select
      customer_id,
      first_order_date
    from
      customer_stats
  )
group by
  category,
  sub_category
order by
  3 desc