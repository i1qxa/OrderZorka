package com.example.orderzorka.domain.groupProductItem

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GroupProductItemListRepository {
    @Insert(entity = GroupProductItem::class, onConflict = OnConflictStrategy.REPLACE)
    fun addGroupProductItem(groupProductItem: GroupProductItem)
    @Delete(entity = GroupProductItem::class)
    fun deleteGroupProductItem(groupProductItem: GroupProductItem)
    @Query("SELECT * FROM group_product_item WHERE groupProductId == (:groupProductItemId) ")
    fun getGroupProductItem(groupProductItemId: Int): GroupProductItem
    @Query("SELECT * FROM group_product_item")
    fun getGroupProductItemList(): LiveData<List<GroupProductItem>>

    fun editGroupProductItem(groupProductItem: GroupProductItem)
}