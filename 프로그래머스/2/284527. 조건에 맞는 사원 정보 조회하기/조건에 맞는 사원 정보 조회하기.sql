-- 코드를 작성해주세요
select sum(HG.SCORE) as SCORE, HG.EMP_NO, HE.EMP_NAME, HE.POSITION, HE.EMAIL
  from HR_DEPARTMENT HD
  join HR_EMPLOYEES HE on (HD.DEPT_ID = HE.DEPT_ID)
  join HR_GRADE HG on (HE.EMP_NO = HG.EMP_NO)
 group by HG.EMP_NO, HG.YEAR
 order by SCORE DESC
 limit 1