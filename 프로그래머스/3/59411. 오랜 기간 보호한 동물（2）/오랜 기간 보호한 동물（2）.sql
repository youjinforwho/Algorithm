-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
FROM (
    SELECT RANK() OVER (ORDER BY (O.DATETIME - I.DATETIME) DESC) AS RANK, O.ANIMAL_ID, O.NAME
    FROM ANIMAL_INS I
    JOIN ANIMAL_OUTS O
    ON I.ANIMAL_ID = O.ANIMAL_ID
)
WHERE RANK <= 2;
