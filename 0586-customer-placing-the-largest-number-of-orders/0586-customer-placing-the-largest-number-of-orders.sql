# Write your MySQL query statement below
-- for count specific column rows we use the count after the group by clause 
SELECT 
    customer_number
FROM
    Orders
GROUP BY 
    customer_number
ORDER BY 
    COUNT(*) DESC
LIMIT 1;