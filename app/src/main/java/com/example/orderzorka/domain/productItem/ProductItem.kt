package com.example.orderzorka.domain.productItem

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductItem(
    @PrimaryKey val productId:Int,
    @ColumnInfo val productName:String,
    @ColumnInfo val unitProductId:Int,
    @ColumnInfo val groupProductId:Int = 0
)
