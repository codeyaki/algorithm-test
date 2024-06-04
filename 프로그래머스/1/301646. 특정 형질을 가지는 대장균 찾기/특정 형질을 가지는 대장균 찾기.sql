-- 코드를 
select count(*) as "COUNT"
  from ECOLI_DATA
 where GENOTYPE & 2 = 0
   and GENOTYPE & 5 > 0