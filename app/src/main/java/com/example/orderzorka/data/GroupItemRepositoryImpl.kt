package com.example.orderzorka.data

import androidx.annotation.WorkerThread
import com.example.orderzorka.domain.productItem.GroupItem
import com.example.orderzorka.domain.productItem.GroupRepository
import kotlinx.coroutines.flow.Flow

class GroupItemRepositoryImpl(private val groupDao:GroupRepository) {
    val allGroups: Flow<List<GroupItem>> = groupDao.getGroupItemList()
    @WorkerThread
    suspend fun addGroupItem(groupItem: GroupItem){
        groupDao.addGroupItem(groupItem)
    }
    @WorkerThread
    suspend fun editGroupItem(groupItem:GroupItem){
        groupDao.updateGroupItem(groupItem)
    }
}