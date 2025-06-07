-- Write your PostgreSQL query statement below
select
    TO_CHAR(trans_date, 'YYYY-MM') as month,
    country as country,
    COUNT(*) as trans_count,
    COUNT(case when state = 'approved' then 1 else null end) as approved_count,
    SUM(amount) as trans_total_amount,
    SUM(case when state = 'approved' then amount else 0 end) as approved_total_amount
from Transactions 
group by TO_CHAR(trans_date, 'YYYY-MM'), country