SELECT B.AUTHOR_ID, AUTHOR_NAME, CATEGORY, SUM(SALES * PRICE) AS TOTAL_SALES
FROM BOOK B
JOIN AUTHOR A
ON B.AUTHOR_ID = A.AUTHOR_ID
JOIN BOOK_SALES S
ON S.BOOK_ID = B.BOOK_ID
WHERE TO_CHAR(SALES_DATE, 'YYYY-MM') = '2022-01'
GROUP BY B.AUTHOR_ID, CATEGORY, AUTHOR_NAME
ORDER BY AUTHOR_ID, CATEGORY DESC