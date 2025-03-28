# Write your MySQL query statement below
SELECT S.USER_ID, ROUND(AVG(IF(C.ACTION = 'CONFIRMED', 1, 0)), 2) CONFIRMATION_RATE
FROM SIGNUPS S LEFT JOIN CONFIRMATIONS C
ON S.USER_ID = C.USER_ID
GROUP BY S.USER_ID;