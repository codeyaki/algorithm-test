-- 코드를 입력하세요
SELECT A.PT_NAME
     , A.PT_NO
     , A.GEND_CD
     , A.AGE
     , IFNULL(A.TLNO, 'NONE') TLNO
  FROM patient A
 WHERE A.AGE <= 12
   AND A.GEND_CD = 'W'
 ORDER BY A.AGE DESC, A.PT_NAME ASC