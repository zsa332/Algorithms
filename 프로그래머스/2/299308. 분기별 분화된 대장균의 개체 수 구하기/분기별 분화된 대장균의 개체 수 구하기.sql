select concat(quarter(differentiation_date), 'Q') as QUARTER, count(*) as ECOLI_COUNT
from ecoli_data
group by QUARTER
order by QUARTER asc;