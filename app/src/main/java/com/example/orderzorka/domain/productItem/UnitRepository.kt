package com.example.orderzorka.domain.productItem

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UnitRepository {
    @Insert(entity = UnitItem::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUnitItem(unitItem: UnitItem)
    @Delete
    suspend fun deleteUnitItem(unitItem: UnitItem)
    @Query("SELECT * FROM UNIT_ITEM")
    fun getUnitItemList(): Flow<List<UnitItem>>
    @Update
    suspend fun updateUnitItem(unitItem: UnitItem)
}