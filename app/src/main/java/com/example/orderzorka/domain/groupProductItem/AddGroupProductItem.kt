package com.example.orderzorka.domain.groupProductItem

class AddGroupProductItem(private val groupProductItemListRepository: GroupProductItemListRepository) {
    fun addGroupProduct(groupProductItem: GroupProductItem){
        groupProductItemListRepository.addGroupProductItem(groupProductItem)
    }
}