package com.example.androidsolidprinciplessample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidsolidprinciplessample.model.database.ProductEntity
//import com.example.androidsolidprinciplessample.sample01.Service
import com.example.androidsolidprinciplessample.sample01_srp.Service

class Sample01Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample01)

        val service = Service(this)
        val product = ProductEntity(1, "Product One", 10.0)

        println(service.calculateProductTax(product))

        service.saveProduct(product)

        val products = service.getListProducts()
        for(currentProduct in products){
            Log.e("Current product", "$currentProduct")
        }
    }
}
