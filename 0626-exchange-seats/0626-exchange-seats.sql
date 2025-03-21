# Write your MySQL query statement below
SELECT (CASE WHEN MOD(ID, 2) = 1 AND ID = (SELECT MAX(ID) FROM SEAT) THEN ID
        WHEN MOD(ID, 2) = 0 THEN ID - 1
        ELSE ID + 1
        END) ID, STUDENT
FROM SEAT
ORDER BY ID;