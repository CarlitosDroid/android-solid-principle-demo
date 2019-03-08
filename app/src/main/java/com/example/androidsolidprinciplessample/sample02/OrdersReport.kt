package com.example.androidsolidprinciplessample.sample02

import com.example.androidsolidprinciplessample.model.database.AppDatabase
import com.example.androidsolidprinciplessample.model.database.OrderEntity

class OrdersReport(var appDatabase: AppDatabase?) {

    private var orders: List<OrderEntity> = mutableListOf()

    fun getOrdersInfo(startDate: String, endDate: String): String {
        orders = queryDBForOrders(startDate, endDate)
        return format(orders)
    }

    private fun queryDBForOrders(startDate: String, endDate: String): List<OrderEntity> {
        // If we would update our persistence layer in the future,
        // we would have to do changes here too. <=> reason to change!
        return appDatabase!!.getOrderDao().findOrders(startDate, endDate)
    }

    private fun format(orders: List<OrderEntity>): String {
        // If we changed the way we want to format the output,
        // we would have to make changes here. <=> reason to change!
        return "Orders: $orders "
    }

}