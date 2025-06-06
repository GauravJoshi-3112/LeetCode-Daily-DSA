-- Write your PostgreSQL query statement below

select
    stock_name,
    SUM(case when operation = 'Buy' then -price else price end) as capital_gain_loss 
from Stocks s
group by stock_name

