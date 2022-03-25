package com.example.orderzorka.domain.unitProduct

import androidx.lifecycle.LiveData

interface UnitProductListRepository {
    fun addUnitProductItem(unitProductItem: UnitProductItem)
    fun deleteUnitProductItem(unitProductItem: UnitProductItem)
    fun editUnitProductItem(unitProductItem: UnitProductItem)
    fun getUnitProductItem(unitProductItemId:Int): UnitProductItem
    fun getListUnitProductItem(): LiveData<List<UnitProductItem>>
}