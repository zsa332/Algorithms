select count(f.id) as FISH_COUNT, max(f.length) as MAX_LENGTH, f.fish_type as FISH_TYPE
from fish_info f
join ( 
    select
        fish_type,
        avg(coalesce(length, 10)) as AVG_LENGTH
    from fish_info
    group by fish_type
    having AVG_LENGTH >= 33
) as t 
on f.fish_type = t.fish_type
group by fish_type
order by fish_type asc;