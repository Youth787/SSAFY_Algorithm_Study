Select a.ID, b.FISH_NAME, a.LENGTH
from FISH_INFO a join 
FISH_NAME_INFO b 
on a.FISH_TYPE = b.FISH_TYPE
where a.LENGTH in (select max(LENGTH)
                  from FISH_INFO
                   where FISH_TYPE = b.FISH_TYPE
                  group by FISH_TYPE)
order by a.ID asc
;
