-- 코드를 입력하세요
SELECT '/home/grep/src/' || B.BOARD_ID || '/' || B.FILE_ID || B.FILE_NAME || B.FILE_EXT as "FILE_PATH"
  FROM USED_GOODS_FILE B
  JOIN (SELECT A.BOARD_ID
          FROM (SELECT *
                  FROM USED_GOODS_BOARD C
                 ORDER BY C.VIEWS DESC
               ) A
         WHERE ROWNUM = 1
       ) D ON (B.BOARD_ID = D.BOARD_ID)
 ORDER BY B.FILE_ID DESC
   
  

