package com.example.orderzorka.domain.unitProduct

import androidx.lifecycle.LiveData

class GetListUnitProductItem(private val unitProductListRepository: UnitProductListRepository) {
    fun getListUnitProductItem():LiveData<List<UnitProductItem>>{
        return unitProductListRepository.getListUnitProductItem()
    }
}