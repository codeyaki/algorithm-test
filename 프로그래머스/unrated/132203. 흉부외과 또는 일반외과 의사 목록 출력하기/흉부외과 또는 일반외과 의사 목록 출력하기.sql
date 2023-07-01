-- 코드를 입력하세요
select A.DR_NAME
     , A.DR_ID
     , A.MCDP_CD
     , DATE_FORMAT(A.HIRE_YMD, '%Y-%m-%d') "HIRE_YMD"
  from DOCTOR A
 where A.MCDP_CD in ('CS', 'GS')
 order by A.HIRE_YMD desc, A.DR_NAME asc