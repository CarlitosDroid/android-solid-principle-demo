package com.example.androidsolidprinciplessample.sample01_srp

import android.content.Context
import com.example.androidsolidprinciplessample.model.database.Product
import com.example.androidsolidprinciplessample.model.database.ProductEntity

class Service(context: Context) {

    private var productRepository: ProductRepository? = null

    init {
        productRepository = ProductRepository(context)
    }

    fun calculateProductTax(product: Product?): Double {
        //Business logic - validate product
        if (product == null) return 0.0

        val tax = 0.19
        return product.price * tax
    }

    fun saveProduct(product: Product?): Boolean {
        //Business logic - validate product
        if (product == null || product.id < 0 || product.name.isNullOrEmpty()) {
            return false
        }

        productRepository!!.save(product)

        return true
    }

    fun getListProducts(): List<ProductEntity> {
        return productRepository!!.list()
    }
}