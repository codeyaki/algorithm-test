-- 코드를 작성해주세요
select round(avg(fil.fish_length), 2) "AVERAGE_LENGTH"
  from (select ifnull(LENGTH, 10) "fish_length"
          from FISH_INFO
       ) fil
  