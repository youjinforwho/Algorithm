-- 코드를 입력하세요
WITH CTE AS (
    SELECT HISTORY_ID, (END_DATE - START_DATE + 1) AS DURATION, DAILY_FEE
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
    JOIN CAR_RENTAL_COMPANY_CAR C
    ON H.CAR_ID = C.CAR_ID
    WHERE CAR_TYPE = '트럭'
), CTE2 AS (
    SELECT HISTORY_ID, CASE 
        WHEN DURATION < 7 THEN '7일 이하'
        WHEN DURATION < 30 THEN '7일 이상'
        WHEN DURATION < 90 THEN '30일 이상'
        ELSE '90일 이상'
    END AS DURATION_TYPE, DAILY_FEE, DURATION
    FROM CTE
), CTE3 AS (
    SELECT HISTORY_ID, CASE 
        WHEN C2.DURATION_TYPE = '7일 이하' THEN 0
        ELSE DISCOUNT_RATE
    END AS DISCOUNT_RATE, DURATION * DAILY_FEE AS FEE
    FROM CTE2 C2
    LEFT OUTER JOIN (
        SELECT *
        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
        WHERE CAR_TYPE = '트럭'
    ) P
    ON P.DURATION_TYPE = C2.DURATION_TYPE
)

SELECT HISTORY_ID, FEE * (1 - 0.01 * DISCOUNT_RATE) AS FEE
FROM CTE3
ORDER BY FEE DESC, HISTORY_ID DESC