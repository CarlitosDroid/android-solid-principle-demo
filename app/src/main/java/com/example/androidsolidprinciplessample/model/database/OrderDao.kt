package com.example.androidsolidprinciplessample.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrder(orderEntity: OrderEntity)

    @Query("SELECT * FROM `order` WHERE startDate >= :startDate AND endDate <= :endDate")
    fun findOrders(startDate: String, endDate: String): List<OrderEntity>
}