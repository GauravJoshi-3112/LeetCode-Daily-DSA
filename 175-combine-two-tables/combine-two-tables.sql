-- Write your PostgreSQL query statement below
SELECT P.firstName,
    P.lastName,
    A.city,
    A.state
FROM Person P 
LEFT JOIN ADDRESS A ON P.personId = A.personId