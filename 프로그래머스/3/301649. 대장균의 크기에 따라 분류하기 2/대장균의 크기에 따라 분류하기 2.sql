-- 코드를 작성해주세요
WITH CTE AS (
    SELECT ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY DESC) AS NUM, ID
    FROM ECOLI_DATA
), CTE2 AS (
    SELECT COUNT(ID) AS TOTAL
    FROM ECOLI_DATA
)

SELECT ID, CASE
    WHEN NUM <= TOTAL * 0.25 THEN 'CRITICAL'
    WHEN NUM <= TOTAL * 0.5 THEN 'HIGH'
    WHEN NUM <= TOTAL * 0.75 THEN 'MEDIUM'
    ELSE 'LOW'
END AS COLONY_NAME 
FROM CTE C1
JOIN CTE2 C2
ON 1 = 1
ORDER BY ID