-- 코드를 입력하세요
SELECT '/home/grep/src/' || A.BOARD_ID || '/' || A.FILE_ID || A.FILE_NAME || A.FILE_EXT as "FILE_PATH"
  FROM USED_GOODS_FILE A
  JOIN (SELECT BOARD_ID
          FROM USED_GOODS_BOARD INNER
         WHERE INNER.VIEWS = (SELECT MAX(VIEWS)
                                FROM USED_GOODS_BOARD
                             )
       ) B ON(A.BOARD_ID = B.BOARD_ID)
 ORDER BY A.FILE_ID DESC