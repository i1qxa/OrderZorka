package com.example.orderzorka.domain.productItem

import androidx.lifecycle.LiveData

class GetListProductItem(private val productListRepository: ProductListRepository) {
    fun getProductItemList():LiveData<List<ProductItem>>{
        return productListRepository.getProductItemList()
    }
}