package com.example.orderzorka.domain.unitProduct

class GetUnitProductItem(private val unitProductListRepository: UnitProductListRepository) {
    fun getUnitProductItem(unitProductItemId:Int):UnitProductItem{
        return unitProductListRepository.getUnitProductItem(unitProductItemId)
    }
}