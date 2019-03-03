package com.example.androidsolidprinciplessample.sample01.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductEntity::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getProductDao(): ProductDao

    companion object {
        const val DATA_BASE_NAME: String = "AppDatabase"
    }
}