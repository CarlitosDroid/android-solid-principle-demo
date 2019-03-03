package com.example.androidsolidprinciplessample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSample01.setOnClickListener {
            startActivity(Intent(this, Sample01Activity::class.java))
        }

        btnSample01SRP.setOnClickListener {

        }

        btnSample02.setOnClickListener {

        }

        btnSample02SRP.setOnClickListener {

        }

    }
}
