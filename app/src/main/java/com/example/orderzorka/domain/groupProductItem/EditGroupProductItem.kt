package com.example.orderzorka.domain.groupProductItem

class EditGroupProductItem(private val groupProductListRepository: GroupProductItemListRepository) {
    fun editGroupProductItem(groupProductItem: GroupProductItem){
        return groupProductListRepository.editGroupProductItem(groupProductItem)
    }
}