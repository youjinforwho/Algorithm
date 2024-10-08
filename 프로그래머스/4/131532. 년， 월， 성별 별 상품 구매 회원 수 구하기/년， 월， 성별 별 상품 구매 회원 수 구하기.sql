SELECT EXTRACT(YEAR FROM SALES_DATE) AS YEAR, EXTRACT(MONTH FROM SALES_DATE) AS MONTH, GENDER, COUNT(DISTINCT USER_ID) AS USERS
FROM (
    SELECT O.*, GENDER
    FROM ONLINE_SALE O
    JOIN USER_INFO I
    ON O.USER_ID = I.USER_ID
    WHERE GENDER IS NOT NULL
)
GROUP BY EXTRACT(YEAR FROM SALES_DATE), EXTRACT(MONTH FROM SALES_DATE), GENDER
ORDER BY YEAR, MONTH