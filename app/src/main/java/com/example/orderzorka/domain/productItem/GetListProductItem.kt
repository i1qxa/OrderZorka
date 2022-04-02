package com.example.orderzorka.domain.productItem

import androidx.lifecycle.LiveData

class GetListProductItem(private val productListRepository: ProductItemRepository) {
    fun getProductItemList():LiveData<List<ProductItem>>{
        return productListRepository.getProductItemList()
    }
}