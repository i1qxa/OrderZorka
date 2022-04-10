package com.example.orderzorka.data

import android.app.Application
import com.example.orderzorka.domain.productItem.GroupItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ProductApplication:Application() {
    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { AppDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { ProductRepositoryImpl(database.productItemDao()) }
    val repositoryGroup by lazy {  }
}