package com.example.orderzorka.domain.productItem

class GetProductItem(private val productListRepository: ProductListRepository) {
    fun getProductItem(productItemId:Int):ProductItem{
        return productListRepository.getProductItem(productItemId)
    }
}