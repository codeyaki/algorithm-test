-- 코드를 작성해주세요
select upgrade_ii.ITEM_ID
     , upgrade_ii.ITEM_NAME
     , upgrade_ii.RARITY
  from ITEM_INFO upgrade_ii
  join ITEM_TREE it on (upgrade_ii.ITEM_ID = it.ITEM_ID)
  join ITEM_INFO parent_ii on (it.PARENT_ITEM_ID = parent_ii.ITEM_ID)
 where parent_ii.RARITY = 'RARE'
 order by upgrade_ii.ITEM_ID DESC