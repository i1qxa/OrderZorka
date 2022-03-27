package com.example.orderzorka.domain.unitProduct

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "unit_product_item")
data class UnitProductItem(
     @PrimaryKey val unitProductId:Int,
     @ColumnInfo val unitProductName:String,
)