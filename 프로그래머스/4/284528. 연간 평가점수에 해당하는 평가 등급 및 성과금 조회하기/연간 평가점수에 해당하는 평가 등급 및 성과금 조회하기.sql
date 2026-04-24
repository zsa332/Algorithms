with g as (
    select emp_no, avg(score) as avg_score
    from hr_grade
    group by emp_no
)

select e.emp_no as EMP_NO, 
    e.emp_name as EMP_NAME, 
    case 
        when 96 <= g.avg_score then 'S'
        when 90 <= g.avg_score then 'A'
        when 80 <= g.avg_score then 'B'
        else 'C'
    end as GRADE,
    case 
        when 96 <= g.avg_score then e.sal * 0.2
        when 90 <= g.avg_score then e.sal * 0.15
        when 80 <= g.avg_score then e.sal * 0.10
        else 0
    end as BONUS
from hr_employees e
join g on e.emp_no = g.emp_no
order by e.emp_no asc;