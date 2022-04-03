package com.example.orderzorka.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.orderzorka.domain.productItem.ProductItem
import com.example.orderzorka.domain.productItem.ProductItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = [ProductItem::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase(){
    abstract fun productItemDao(): ProductItemRepository
    companion object{
        @Volatile
        private var INSTANCE:AppDatabase? = null
        fun getDatabase(context:Context, scope:CoroutineScope):AppDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "product_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.productItemDao())
                }
            }
        }

        suspend fun populateDatabase(productItemRep: ProductItemRepository) {
            // Delete all content here.
            productItemRep.deleteAllProduct()

            // Add sample Product.
            var product = ProductItem(1,"Smetana",1,1)
            productItemRep.addProductItem(product)
            product = ProductItem(2,"World!",1,1)
            productItemRep.addProductItem(product)

        }
    }

}