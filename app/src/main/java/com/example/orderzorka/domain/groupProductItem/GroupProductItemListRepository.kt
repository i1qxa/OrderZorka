package com.example.orderzorka.domain.groupProductItem

import androidx.lifecycle.LiveData

interface GroupProductItemListRepository {
    fun addGroupProductItem(groupProductItem: GroupProductItem)
    fun deleteGroupProductItem(groupProductItem: GroupProductItem)
    fun editGroupProductItem(groupProductItem: GroupProductItem)
    fun getGroupProductItem(groupProductItemId: Int): GroupProductItem
    fun getGroupProductItemList(): LiveData<List<GroupProductItem>>
}