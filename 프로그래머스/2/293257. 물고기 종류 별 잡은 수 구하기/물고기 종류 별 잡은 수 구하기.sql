-- 코드를 작성해주세요
select count(*) "FISH_COUNT"
     , fmi.FISH_NAME
  from FISH_INFO fi
  join FISH_NAME_INFO fmi on (fi.FISH_TYPE = fmi.FISH_TYPE)
 group by fmi.FISH_NAME
 order by FISH_COUNT desc