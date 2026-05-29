/*
UPPER
*/
--------------------------------------------------
select
    substr(product_code,0,2) as product_code
    , count(*) as products
from product
group by substr(product_code,0,2)
order by 1
--------------------------------------------------
select
    name
    ,count(*)
from animal_ins
where name is not null
group by name
having count(*) >=2
order by 1
--------------------------------------------------
select
    animal_id
    , name
from animal_ins
where 1=1
and UPPER(name) like '%EL%'
and animal_type  = 'Dog'
order by 2
--------------------------------------------------
select
    animal_type
    , case when name is null then 'No name'
        else name end as name
    , sex_upon_intake
from animal_ins
order by animal_id