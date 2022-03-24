package com.example.orderzorka.domain.unitProduct

import androidx.lifecycle.LiveData

interface UnitProductListRepository {
    fun addGroupProductItem(unitProduct: UnitProduct)
    fun deleteUnitProductItem(unitProduct: UnitProduct)
    fun editUnitProductItem(unitProduct: UnitProduct)
    fun getUnitProductItem(): UnitProduct
    fun getUnitProductItemList(): LiveData<List<UnitProduct>>
}