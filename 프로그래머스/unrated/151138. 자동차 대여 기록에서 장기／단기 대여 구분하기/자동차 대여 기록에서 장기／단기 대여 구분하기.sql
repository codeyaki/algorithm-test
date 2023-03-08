-- 코드를 입력하세요
SELECT HISTORY_ID
     , CAR_ID
     , TO_CHAR(START_DATE, 'YYYY-MM-DD') as "START_DATE"
     , TO_CHAR(END_DATE, 'YYYY-MM-DD') as "END_DATE"
     , CASE WHEN END_DATE - START_DATE + 1 >= 30 THEN '장기 대여'
            ELSE '단기 대여'
       END as "RENT_TYPE"
  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
 WHERE START_DATE >= TO_DATE('2022-09-01', 'YYYY-MM-DD')
   AND START_DATE <  TO_DATE('2022-10-01', 'YYYY-MM-DD')
 ORDER BY HISTORY_ID DESC