package com.example.androidsolidprinciplessample.sample01.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(productEntity: ProductEntity)

    @Query("SELECT * FROM product")
    fun findProducts(): List<ProductEntity>
}