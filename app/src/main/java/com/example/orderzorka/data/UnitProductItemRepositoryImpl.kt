package com.example.orderzorka.data

import androidx.lifecycle.LiveData
import com.example.orderzorka.domain.unitProduct.UnitProductItem
import com.example.orderzorka.domain.unitProduct.UnitProductListRepository

object UnitProductItemRepositoryImpl:UnitProductListRepository {
    override fun addUnitProductItem(unitProductItem: UnitProductItem) {
        addUnitProductItem(unitProductItem)
    }

    override fun deleteUnitProductItem(unitProductItem: UnitProductItem) {
        deleteUnitProductItem(unitProductItem)
    }

    override fun getUnitProductItem(unitProductItemId: Int): UnitProductItem {
        return getUnitProductItem(unitProductItemId)
    }

    override fun getListUnitProductItem(): LiveData<List<UnitProductItem>> {
        return getListUnitProductItem()
    }

    override fun editUnitProductItem(unitProductItem: UnitProductItem) {
        val oldUnitProductItem = getUnitProductItem(unitProductItem.unitProductId)
        deleteUnitProductItem(oldUnitProductItem)
        addUnitProductItem(unitProductItem)
    }
}