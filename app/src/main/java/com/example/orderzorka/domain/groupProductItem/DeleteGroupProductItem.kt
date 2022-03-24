package com.example.orderzorka.domain.groupProductItem

class DeleteGroupProductItem(private val groupProductItemListRepository: GroupProductItemListRepository) {
    fun deleteGroupProductItem(groupProductItem: GroupProductItem){
        groupProductItemListRepository.deleteGroupProductItem(groupProductItem)
    }
}