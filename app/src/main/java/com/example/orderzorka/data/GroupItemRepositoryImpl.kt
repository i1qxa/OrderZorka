package com.example.orderzorka.data

import androidx.annotation.WorkerThread
import com.example.orderzorka.domain.productItem.GroupItem
import com.example.orderzorka.domain.productItem.GroupItemRepository
import kotlinx.coroutines.flow.Flow

class GroupItemRepositoryImpl(private val groupDao:GroupItemRepository) {
    val allGroups: Flow<List<GroupItem>> = groupDao.getGroupItemList()
    @WorkerThread
    suspend fun
}