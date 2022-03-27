package com.example.orderzorka.domain.groupProductItem

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "group_product_item")
data class GroupProductItem(
    @PrimaryKey val groupProductId:Int,
    @ColumnInfo val groupProductName:String
)