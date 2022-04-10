package com.example.orderzorka.data

import androidx.annotation.WorkerThread
import com.example.orderzorka.domain.productItem.UnitItem
import com.example.orderzorka.domain.productItem.UnitRepository
import kotlinx.coroutines.flow.Flow

class UnitItemRepositoryImpl(private val unitDao:UnitRepository) {
    val allUnit:Flow<List<UnitItem>> = unitDao.getUnitItemList()
    @WorkerThread
    suspend fun addUnitItem(unitItem:UnitItem){
        unitDao.addUnitItem(unitItem)
    }
    @WorkerThread
    suspend fun editUnitItem(unitItem: UnitItem){
        unitDao.updateUnitItem(unitItem)
    }
}