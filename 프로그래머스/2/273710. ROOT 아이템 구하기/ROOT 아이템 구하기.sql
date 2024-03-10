-- 코드를 작성해주세요
SELECT ii.item_id
     , ii.item_name
  FROM item_info ii, item_tree it
 WHERE ii.item_id = it.item_id
   AND it.parent_item_id IS NULL
 ORDER BY ii.item_id