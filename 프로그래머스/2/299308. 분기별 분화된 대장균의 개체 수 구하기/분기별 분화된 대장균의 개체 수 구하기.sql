
WITH EDQ as(
    select CASE
            WHEN month(DIFFERENTIATION_DATE) in (1, 2, 3) then '1Q' 
            WHEN month(DIFFERENTIATION_DATE) in (4, 5, 6) then '2Q' 
            WHEN month(DIFFERENTIATION_DATE) in (7, 8, 9) then '3Q' 
            WHEN month(DIFFERENTIATION_DATE) in (10, 11, 12) then '4Q' 
           END "QUARTER"
      from ECOLI_DATA
)

SELECT QUARTER
     , COUNT(QUARTER) "ECOLI_COUNT"
  FROM EDQ
 GROUP BY QUARTER
 ORDER BY QUARTER
