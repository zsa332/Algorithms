select i.id as ID, n.fish_name as FISH_NAME, i.length as LENGTH
from fish_info i
join fish_name_info n on i.fish_type = n.fish_type
where (i.fish_type, i.length) in (
    select fish_type, 
    max(length) 
    from fish_info 
    group by fish_type
)
order by id asc;