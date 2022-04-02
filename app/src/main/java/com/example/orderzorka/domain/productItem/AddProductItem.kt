package com.example.orderzorka.domain.productItem

class AddProductItem(private val productListRepository: ProductItemRepository) {
    fun addProductItem(productItem: ProductItem){
        productListRepository.addProductItem(productItem)
    }
}