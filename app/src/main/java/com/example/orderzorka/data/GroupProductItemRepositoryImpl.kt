package com.example.orderzorka.data

import androidx.lifecycle.LiveData
import com.example.orderzorka.domain.groupProductItem.GroupProductItem
import com.example.orderzorka.domain.groupProductItem.GroupProductItemListRepository

object GroupProductItemRepositoryImpl:GroupProductItemListRepository {
    override fun addGroupProductItem(groupProductItem: GroupProductItem) {
        addGroupProductItem(groupProductItem)
    }

    override fun deleteGroupProductItem(groupProductItem: GroupProductItem) {
        deleteGroupProductItem(groupProductItem)
    }

    override fun getGroupProductItem(groupProductItemId: Int): GroupProductItem {
        return getGroupProductItem(groupProductItemId)
    }

    override fun getGroupProductItemList(): LiveData<List<GroupProductItem>> {
        return getGroupProductItemList()
    }

    override fun editGroupProductItem(groupProductItem: GroupProductItem) {
        val oldGroupProductItem = getGroupProductItem(groupProductItem.groupProductId)
        deleteGroupProductItem(oldGroupProductItem)
        addGroupProductItem(groupProductItem)
    }
}