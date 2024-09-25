select id
from ECOLI_DATA
where PARENT_ID in
(select id 
from ECOLI_DATA
where PARENT_ID in
(select id 
from ECOLI_DATA
where PARENT_ID is NUll))
order by id asc;
