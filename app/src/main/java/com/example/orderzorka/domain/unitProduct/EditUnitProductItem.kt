package com.example.orderzorka.domain.unitProduct

class EditUnitProductItem(private val unitProductListRepository: UnitProductListRepository) {
    fun editUnitProductItem(unitProductItem: UnitProductItem){
        unitProductListRepository.editUnitProductItem(unitProductItem)
    }
}