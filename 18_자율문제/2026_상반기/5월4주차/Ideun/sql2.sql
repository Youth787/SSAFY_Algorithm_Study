with prev_time as (
  select
   user_pseudo_id
   , event_timestamp_kst
   , lag(event_timestamp_kst) over(
    partition by user_pseudo_id
    order by event_timestamp_kst
   ) as prev_tt
from ga
where user_pseudo_id = 'S3WDQCqLpK'
)
, diff_time as(
SELECT
  user_pseudo_id
  , event_timestamp_kst
  , prev_tt
  , case when (julianday(event_timestamp_kst) - julianday(prev_tt)) * 24 * 60 >= 60 then 1
        when prev_tt is null then 1
        else 0
    end AS diff_minute
FROM prev_time
)
, is_new_session as (
  select
    user_pseudo_id
    , event_timestamp_kst
    , prev_tt
    , sum(diff_minute) over(
      partition by user_pseudo_id
      order by event_timestamp_kst
    ) as num
  from diff_time
)
select
  user_pseudo_id
  , min(event_timestamp_kst) as session_start
  , max(event_timestamp_kst) as session_end
from is_new_session
group by num
