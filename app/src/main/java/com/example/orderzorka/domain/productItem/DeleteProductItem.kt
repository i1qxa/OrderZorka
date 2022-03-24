package com.example.orderzorka.domain.productItem

class DeleteProductItem(private val productListRepository: ProductListRepository) {
    fun deleteProductItem(productItem: ProductItem){
        productListRepository.deleteProductItem(productItem)
    }
}