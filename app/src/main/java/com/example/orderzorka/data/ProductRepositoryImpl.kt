package com.example.orderzorka.data

import androidx.annotation.WorkerThread
import com.example.orderzorka.domain.productItem.ProductItem
import com.example.orderzorka.domain.productItem.ProductItemRepository
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(private val productDao:ProductItemRepository) {
    val allProducts: Flow<List<ProductItem>> = productDao.getProductItemList()
    @WorkerThread
    suspend fun addProduct(productItem:ProductItem){
        productDao.addProductItem(productItem)
    }
    @WorkerThread
    suspend fun editProductItem(productItem: ProductItem){
        productDao.updateProductItem(productItem)
    }
    @WorkerThread
    suspend fun getProductItem(productItemId:Int):ProductItem{
        return productDao.getProductItem(productItemId)
    }
}