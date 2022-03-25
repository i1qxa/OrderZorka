package com.example.orderzorka.domain.unitProduct

class AddUnitProductItem(private val unitProductListRepository: UnitProductListRepository) {
    fun addUnitProductItem(unitProductItem:UnitProductItem){
        unitProductListRepository.addUnitProductItem(unitProductItem)
    }
}