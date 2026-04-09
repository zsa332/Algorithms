-- 코드를 작성해주세요
select year(differentiation_date) as year, max(size_of_colony) over (PARTITION BY year(differentiation_date)) - size_of_colony as YEAR_DEV, id
from ecoli_data
order by year, year_dev;