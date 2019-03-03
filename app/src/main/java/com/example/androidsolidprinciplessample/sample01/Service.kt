package com.example.androidsolidprinciplessample.sample01

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.androidsolidprinciplessample.sample01.model.AppDatabase
import com.example.androidsolidprinciplessample.sample01.model.ProductEntity

class Service(var context: Context) {

    private var roomConnection: AppDatabase? = null

    init {
        initDatabase()
    }

    fun calculateProductTax(product: Product): Double {
        if (product == null) return 0.0
        val Tax = 0.19
        val productTax = product.price * Tax
        return productTax
    }

    fun saveProduct(product: Product): Boolean {

        //Validate product
        if (product == null || product.id < 0 || product.name.isNullOrEmpty()) {
            return false
        }

        //Insert int Database
        Log.e("Inserting product in", "Inserting product in")
        roomConnection!!.getProductDao().insertProduct(
            ProductEntity(name = product.name, price = product.price)
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