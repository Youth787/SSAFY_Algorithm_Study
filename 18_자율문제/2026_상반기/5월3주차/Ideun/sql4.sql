select
  day
  , time
  , sex
  , total_bill
from(
SELECT
  *
  , row_number() over (partition by day order by total_bill desc) as ranking
from tips
)
where ranking <= 3
