package com.example.orderzorka.domain.productItem

class EditProductItem(private val productListRepository: ProductListRepository) {
    fun editProductItem(productItem: ProductItem){
        productListRepository.editProductItem(productItem)
    }
}