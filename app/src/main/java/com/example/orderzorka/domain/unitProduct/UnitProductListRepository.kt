package com.example.orderzorka.domain.unitProduct

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UnitProductListRepository {
    @Insert(entity = UnitProductItem::class, onConflict = OnConflictStrategy.REPLACE)
    fun addUnitProductItem(unitProductItem: UnitProductItem)
    @Delete(entity = UnitProductItem::class)
    fun deleteUnitProductItem(unitProductItem: UnitProductItem)
    @Query("SELECT * FROM unit_product_item WHERE unitProductId == (:unitProductItemId)")
    fun getUnitProductItem(unitProductItemId:Int): UnitProductItem
    @Query("SELECT * FROM unit_product_item")
    fun getListUnitProductItem(): LiveData<List<UnitProductItem>>

    fun editUnitProductItem(unitProductItem: UnitProductItem)
}