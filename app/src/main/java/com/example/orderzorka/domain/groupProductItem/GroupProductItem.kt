package com.example.orderzorka.domain.groupProductItem

import com.example.orderzorka.domain.productItem.ProductItem

data class GroupProductItem(
    val name:String,
    val groupId:Int = ProductItem.UNDEFINED_ID
)