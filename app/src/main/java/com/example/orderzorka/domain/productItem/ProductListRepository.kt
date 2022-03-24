package com.example.orderzorka.domain.productItem

import androidx.lifecycle.LiveData

interface ProductListRepository {
    fun addProductItem(productItem: ProductItem)
    fun deleteProductItem(productItem: ProductItem)
    fun editProductItem(productItem: ProductItem)
    fun getProductItem(productItemId:Int): ProductItem
    fun getProductItemList():LiveData<List<ProductItem>>
}