package com.example.orderzorka.domain.productItem

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface GroupItemRepository {
    @Insert(entity = GroupItem::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addGroupItem(groupItem:GroupItem)
    @Update
    suspend fun editGroupItem(groupItem: GroupItem)
    @Query("SELECT * FROM group_items")
    fun getGroupItemList():Flow<List<GroupItem>>

}