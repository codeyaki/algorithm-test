-- 코드를 작성해주세요
with skillCode as (
    select SUM(CODE) "sum_code"
      from SKILLCODES
     where NAME IN ('C#', 'Python')
)

select ID
     , EMAIL
     , FIRST_NAME
     , LAST_NAME
  from DEVELOPERS  
 where SKILL_CODE & (select sum_code from skillCode) > 0
 order by ID asc
