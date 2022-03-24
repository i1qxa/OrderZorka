package com.example.orderzorka.domain.groupProductItem

class GetGroupProductItem(private val groupProductItemListRepository: GroupProductItemListRepository) {
    fun getGroupProductItem(groupProductItemId: Int):GroupProductItem{
        return groupProductItemListRepository.getGroupProductItem(groupProductItemId)
    }
}