select id as ID, 
    (
        select count(c.id) 
        from ecoli_data as c 
        where parent_id = p.id
    ) as CHILD_COUNT
from ecoli_data as p
order by p.id asc;