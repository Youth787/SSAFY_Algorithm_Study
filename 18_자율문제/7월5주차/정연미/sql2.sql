SELECT b.ITEM_ID, a.ITEM_NAME
FROM ITEM_INFO a
JOIN ITEM_TREE b ON a.ITEM_ID = b.ITEM_ID
WHERE b.PARENT_ITEM_ID IS NULL
ORDER BY 1;
