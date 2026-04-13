-- 코드를 작성해주세요
select concat(quarter(differentiation_date), 'Q') as QUARTER, count(*) as ECOLI_COUNT
from ecoli_data
group by concat(quarter(differentiation_date), 'Q')
order by concat(quarter(differentiation_date), 'Q') asc;