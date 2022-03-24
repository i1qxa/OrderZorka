package com.example.orderzorka.domain.productItem

data class ProductItem(
    val name:String,//Имя
    val unitId:Int,//Id еденицы измерения
    val groupId:Int = 0,//Id группы
    val productId:Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID:Int = -1
    }
}