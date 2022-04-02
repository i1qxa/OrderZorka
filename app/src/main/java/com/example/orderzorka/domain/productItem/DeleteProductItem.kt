package com.example.orderzorka.domain.productItem

class DeleteProductItem(private val productListRepository: ProductItemRepository) {
    fun deleteProductItem(productItem: ProductItem){
        productListRepository.deleteProductItem(productItem)
    }
}