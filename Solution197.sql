# Write your MySQL query statement below
SELECT X.id from Weather X, Weather Y WHERE

X.Temperature > Y.Temperature AND

DATEDIFF(X.recordDate, Y.recordDate) = 1