package com.example.orderzorka.domain.unitProduct

import com.example.orderzorka.domain.productItem.ProductItem

data class UnitProduct(
    val name:String,
    val unitId:Int = ProductItem.UNDEFINED_ID
) {
}