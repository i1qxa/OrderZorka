package com.example.orderzorka.domain.productItem

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "unit_item")
data class UnitItem (
    @PrimaryKey(autoGenerate = true) val unitId:Int,
    @ColumnInfo val name:String
)