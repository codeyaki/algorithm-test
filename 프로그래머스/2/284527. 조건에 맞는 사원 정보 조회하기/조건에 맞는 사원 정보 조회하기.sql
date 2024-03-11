with HGF as (
    select sum(HG.SCORE) as SCORE
         , HG.EMP_NO
      from HR_GRADE HG
     group by HG.EMP_NO, HG.YEAR
     order by SCORE DESC
     limit 1
)


-- 코드를 작성해주세요
select HGF.SCORE, HE.EMP_NO, HE.EMP_NAME, HE.POSITION, HE.EMAIL
  from HR_DEPARTMENT HD
  join HR_EMPLOYEES HE on (HD.DEPT_ID = HE.DEPT_ID)
  join HGF on (HE.EMP_NO = HGF.EMP_NO)