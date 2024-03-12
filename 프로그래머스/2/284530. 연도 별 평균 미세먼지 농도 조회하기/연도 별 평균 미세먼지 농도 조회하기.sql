-- 코드를 작성해주세요
with APY as (
       select LOCATION1
            , LOCATION2
            , YEAR(YM) YEAR
            , PM_VAL1
            , PM_VAL2
       from AIR_POLLUTION
       where LOCATION1 = '경기도'
         and LOCATION2 = '수원'
)

select YEAR
     , ROUND(AVG(PM_VAL1), 2) "PM10"
     , ROUND(AVG(PM_VAL2), 2) "PM2.5"
  from APY
 group by YEAR
 order by YEAR asc