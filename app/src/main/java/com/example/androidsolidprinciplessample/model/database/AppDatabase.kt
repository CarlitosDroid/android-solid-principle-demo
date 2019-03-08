package com.example.androidsolidprinciplessample.model.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        ProductEntity::class,
        OrderEntity::class],
    exportSchema = false, version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getProductDao(): ProductDao
    abstract fun getOrderDao(): OrderDao

    companion object {
        const val DATA_BASE_NAME: String = "AppDatabase"
    }
}