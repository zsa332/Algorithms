-- 코드를 작성해주세요
select c.id, c.genotype, p.genotype as PARENT_GENOTYPE
from ecoli_data c
join ecoli_data p on c.parent_id = p.id
where (c.genotype & p.genotype) = p.genotype
order by id asc;