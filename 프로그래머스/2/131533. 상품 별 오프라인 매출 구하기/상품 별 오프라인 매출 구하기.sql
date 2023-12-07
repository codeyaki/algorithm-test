-- 코드를 입력하세요
SELECT A.PRODUCT_CODE,
   SUM (A.PRICE * B.SALES_AMOUNT) "SALES"
  FROM PRODUCT A
  JOIN OFFLINE_SALE B ON (A.PRODUCT_ID = B.PRODUCT_ID)
 GROUP BY A.PRODUCT_ID, A.PRODUCT_CODE
 ORDER BY SALES DESC