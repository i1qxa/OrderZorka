package com.example.orderzorka.domain.productItem

class AddProductItem(private val productListRepository: ProductListRepository) {
    fun addProductItem(productItem: ProductItem){
        productListRepository.addProductItem(productItem)
    }
}