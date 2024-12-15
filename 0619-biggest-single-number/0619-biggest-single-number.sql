# Write your MySQL query statement below
SELECT MAX(MN.NUM) NUM
FROM (
    SELECT NUM
    FROM MYNUMBERS
    GROUP BY NUM
    HAVING COUNT(*) = 1
) MN;