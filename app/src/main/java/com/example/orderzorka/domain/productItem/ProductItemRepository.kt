package com.example.orderzorka.domain.productItem

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductItemRepository {
    @Insert(entity = ProductItem::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProductItem(productItem: ProductItem)
    @Delete(entity = ProductItem::class)
    suspend fun deleteProductItem(productItem: ProductItem)
    @Query("DELETE FROM product_item")
    suspend fun deleteAllProduct()
    @Query("SELECT * FROM product_item WHERE productId == (:productItemId)")
    fun getProductItem(productItemId:Int): ProductItem
    @Query("SELECT * FROM product_item")
    fun getProductItemList(): Flow<List<ProductItem>>
    @Update
    suspend fun updateProductItem(productItem: ProductItem)
}