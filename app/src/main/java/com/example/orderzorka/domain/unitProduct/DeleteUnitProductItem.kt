package com.example.orderzorka.domain.unitProduct

class DeleteUnitProductItem(private val unitProductListRepository: UnitProductListRepository) {
    fun deleteUnitProductItem(unitProductItem: UnitProductItem){
        unitProductListRepository.deleteUnitProductItem(unitProductItem)
    }
}