package com.example.orderzorka.domain.unitProduct

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.orderzorka.domain.productItem.ProductItem

@Entity
data class UnitProductItem(
    @PrimaryKey val unitProductId:Int,
    @ColumnInfo val unitProductName:String,
)