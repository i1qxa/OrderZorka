package com.example.orderzorka.domain.productItem

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductItemRepository {
    @Insert(entity = ProductItem::class, onConflict = OnConflictStrategy.REPLACE)
    fun addProductItem(productItem: ProductItem)
    @Delete(entity = ProductItem::class)
    fun deleteProductItem(productItem: ProductItem)
    @Query("SELECT * FROM product_item WHERE productId == (:productItemId)")
    fun getProductItem(productItemId:Int): ProductItem
    @Query("SELECT * FROM product_item")
    fun getProductItemList():LiveData<List<ProductItem>>

    //fun editProductItem(productItem: ProductItem)
}