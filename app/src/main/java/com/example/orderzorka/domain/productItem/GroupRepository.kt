package com.example.orderzorka.domain.productItem

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface GroupRepository {
    @Insert(entity = GroupItem::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addGroupItem(groupItem:GroupItem)
    @Delete(entity = GroupItem::class)
    suspend fun deleteGroupItem(groupItem:GroupItem)
    @Query("SELECT * FROM GROUP_ITEM")
    fun getGroupItemList(): Flow<List<GroupItem>>
    @Update
    suspend fun updateGroupItem(groupItem: GroupItem)
}