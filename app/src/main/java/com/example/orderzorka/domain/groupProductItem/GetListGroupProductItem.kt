package com.example.orderzorka.domain.groupProductItem

import androidx.lifecycle.LiveData

class GetListGroupProductItem(private val groupProductItemListRepository: GroupProductItemListRepository) {
    fun getGroupProductItemList():LiveData<List<GroupProductItem>>{
        return groupProductItemListRepository.getGroupProductItemList()
    }
}