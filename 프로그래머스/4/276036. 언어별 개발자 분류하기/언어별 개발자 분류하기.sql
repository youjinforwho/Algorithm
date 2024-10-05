WITH CTE AS (
    SELECT ID, GROUP_CONCAT(NAME, ', ') AS NAME, GROUP_CONCAT(CATEGORY) AS CATEGORY
    FROM DEVELOPERS D
    JOIN SKILLCODES S
    ON D.SKILL_CODE & S.CODE = S.CODE
    GROUP BY ID
), CTE2 AS (
    SELECT ID, CASE 
        WHEN CATEGORY LIKE '%Front End%' AND NAME LIKE '%Python%' THEN 'A'
        WHEN NAME LIKE '%C#%' THEN 'B'
        WHEN CATEGORY LIKE '%Front End%' THEN 'C'
    ELSE 'None'
    END AS GRADE
    FROM CTE
)
SELECT GRADE, D.ID, EMAIL
FROM DEVELOPERS D
JOIN CTE2 C
ON D.ID = C.ID
WHERE GRADE != 'None'
ORDER BY GRADE, ID