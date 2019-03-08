package com.example.androidsolidprinciplessample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.androidsolidprinciplessample.model.database.AppDatabase

class Sample02Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample02)

        val roomConnection = Room.databaseBuilder(this, AppDatabase::class.java, AppDatabase.DATA_BASE_NAME)
            .allowMainThreadQueries()
            .build()


    }
}
