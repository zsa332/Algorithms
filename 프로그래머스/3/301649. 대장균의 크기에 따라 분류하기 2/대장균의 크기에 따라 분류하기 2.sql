-- 코드를 작성해주세요
select id, 
    (case 
        when ntile(4) over (order by size_of_colony asc) = 1 then 'LOW'
        when ntile(4) over (order by size_of_colony asc) = 2 then 'MEDIUM'
        when ntile(4) over (order by size_of_colony asc) = 3 then 'HIGH'
        when ntile(4) over (order by size_of_colony asc) = 4 then 'CRITICAL'
     end
    ) as COLONY_NAME
from ecoli_data
order by id asc;