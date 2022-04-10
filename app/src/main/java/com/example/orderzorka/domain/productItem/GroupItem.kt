package com.example.orderzorka.domain.productItem

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "group_items")
data class GroupItem(
    @PrimaryKey(autoGenerate = true) val groupId:Int,
    @ColumnInfo val parentId:Int,
    @ColumnInfo val groupName:String
)