package com.example.retrofitproject

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        GlobalScope.launch(Dispatchers.IO) {
            val call = UserRetrofitService.retrofit.create(UserInterfacee::class.java).getSingleUser()

            val firstname = call.execute().body()?.data?.firstNamee

            withContext(Dispatchers.Main) {

                val titlee = findViewById<TextView>(R.id.titlee)

                titlee.text = firstname

            }

        }


    }
}