package com.example.orderzorka.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.orderzorka.domain.groupProductItem.GroupProductItem
import com.example.orderzorka.domain.productItem.ProductItem
import com.example.orderzorka.domain.unitProduct.UnitProductItem

@Database(
    entities = [ProductItem::class,GroupProductItem::class,UnitProductItem::class],
    version = 1
)
abstract class AppDatabase:RoomDatabase(){
    abstract fun productItem(): Dao
    abstract fun groupProductItem(): Dao
    abstract fun unitProductItem(): Dao
}