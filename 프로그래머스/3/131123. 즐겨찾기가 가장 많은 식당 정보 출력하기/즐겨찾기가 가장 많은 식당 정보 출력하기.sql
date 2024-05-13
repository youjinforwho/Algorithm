-- 코드를 입력하세요
WITH CTE AS
(
    SELECT MAX(FAVORITES) AS FAVORITES, REST_ID, REST_NAME, FOOD_TYPE
    FROM REST_INFO
    GROUP BY FOOD_TYPE
)
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM REST_INFO
WHERE (FOOD_TYPE, FAVORITES) IN (
    SELECT FOOD_TYPE, FAVORITES
    FROM CTE
)
ORDER BY FOOD_TYPE DESC