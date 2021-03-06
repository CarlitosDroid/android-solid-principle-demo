package com.example.androidsolidprinciplessample.sample01

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.androidsolidprinciplessample.model.database.AppDatabase
import com.example.androidsolidprinciplessample.model.database.ProductEntity

class Service(var context: Context) {

    private var roomConnection: AppDatabase? = null

    init {
        initDatabase()
    }

    fun calculateProductTax(product: ProductEntity?): Double {
        if (product == null) return 0.0
        val tax = 0.19
        return product.price * tax
    }

    fun saveProduct(product: ProductEntity?): Boolean {

        //Business logic - validate product
        if (product == null || product.id < 0 || product.name.isEmpty()) {
            return false
        }

        //Insert in Database
        roomConnection!!.getProductDao().insertProduct(
            ProductEntity(
                name = product.name,
                price = product.price
            )
        )

        return true
    }

    fun getListProducts(): List<ProductEntity> {
        return roomConnection!!.getProductDao().findProducts()
    }

    private fun initDatabase() {
        Log.e("Initializing Database", "Initializing Database")
        roomConnection = Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.DATA_BASE_NAME)
            .allowMainThreadQueries()
            .build()
    }
}