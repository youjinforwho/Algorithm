-- 코드를 입력하세요
WITH CTE AS (
    SELECT TRUNC( PRICE / 10000, 0 ) * 10000 AS PRICE, PRODUCT_ID, PRODUCT_CODE
    FROM PRODUCT
)

SELECT PRICE AS PRICE_GROUP, COUNT(PRODUCT_ID) AS PRODUCTS
FROM CTE
GROUP BY PRICE
ORDER BY PRICE_GROUP

