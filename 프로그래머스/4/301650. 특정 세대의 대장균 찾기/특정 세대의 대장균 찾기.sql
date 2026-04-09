-- 코드를 작성해주세요
select c.id
from ecoli_data c
join ecoli_data p on c.parent_id = p.id
join ecoli_data g on p.parent_id = g.id
where g.parent_id is null;