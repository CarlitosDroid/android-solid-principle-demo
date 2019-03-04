package com.example.androidsolidprinciplessample.sample01_srp

import android.content.Context
import androidx.room.Room
import com.example.androidsolidprinciplessample.model.database.AppDatabase
import com.example.androidsolidprinciplessample.model.database.ProductEntity

class ProductRepository(private val context: Context) {

    private var roomConnection: AppDatabase? = null

    init {
        initDatabase()
    }

    fun save(product: ProductEntity) {
        //Insert in Database
        roomConnection!!.getProductDao().insertProduct(
            ProductEntity(
                name = product.name,
                price = product.price
            )
        )
    }

    fun list(): List<ProductEntity> {
        return roomConnection!!.getProductDao().findProducts()
    }

    private fun initDatabase() {
        roomConnection = Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.DATA_BASE_NAME)
            .allowMainThreadQueries()
            .build()
    }
}