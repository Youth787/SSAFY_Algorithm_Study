with lag_time as (
select
  user_pseudo_id
  , event_timestamp_kst
  , ga_session_id
  , event_name
  , lag(event_timestamp_kst)
  over(partition by user_pseudo_id
        order by event_timestamp_kst) as prev_time
from ga
where user_pseudo_id = 'a8Xu9GO6TB'
)
, diff_time as (
  select
  user_pseudo_id
  , event_timestamp_kst
  , ga_session_id
  , event_name
  , prev_time
  , case when (julianday(event_timestamp_kst) - julianday(prev_time)) *24*60 >= 10 then 1
  when prev_time is null then 1
  else 0 end as diff_time
  from lag_time
),
numbering as (
  select
    user_pseudo_id
  , event_timestamp_kst
  , event_name
  , ga_session_id
  , sum(diff_time)
  over(partition by user_pseudo_id
  order by event_timestamp_kst) as new_session_id
  from diff_time
)
select * from numbering