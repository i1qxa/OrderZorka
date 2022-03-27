package com.example.orderzorka.data

import androidx.lifecycle.LiveData
import com.example.orderzorka.domain.productItem.ProductItem
import com.example.orderzorka.domain.productItem.ProductListRepository


object ProductItemRepositoryImpl:ProductListRepository {
    override fun getProductItem(productItemId: Int): ProductItem{
        return getProductItem(productItemId)
    }

    override fun addProductItem(productItem: ProductItem) {
        addProductItem(productItem)
    }


    override fun deleteProductItem(productItem: ProductItem) {
        deleteProductItem(productItem)
    }

    override fun editProductItem(productItem: ProductItem) {
        val oldProductItem = getProductItem(productItem.productId)
        deleteProductItem(oldProductItem)
        addProductItem(productItem)
    }

    override fun getProductItemList(): LiveData<List<ProductItem>> {
        return getProductItemList()
    }
}