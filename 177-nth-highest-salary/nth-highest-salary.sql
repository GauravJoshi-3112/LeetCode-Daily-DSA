CREATE OR REPLACE FUNCTION NthHighestSalary(N INT) RETURNS TABLE (Salary INT) AS $$
BEGIN
  RETURN QUERY (
    -- Write your PostgreSQL query statement below.
    SELECT CASE WHEN N <= 0 THEN NULL ELSE 
    (SELECT COALESCE (
        (SELECT DISTINCT
            Employee.salary 
        FROM Employee 
        ORDER BY Employee.salary DESC
        OFFSET N-1
        LIMIT 1), NULL  
    )) END AS salary 
);
END;
$$ LANGUAGE plpgsql;