package com.example.retrofitproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.newActivity).setOnClickListener {
            val intent = Intent(this, Lesson2::class.java)
            startActivity(intent)
        }

        GlobalScope.launch(Dispatchers.IO) {
            val call =
                UserRetrofitService.retrofit.create(UserInterfacee::class.java).getSingleUser()

            val idRetrofit = call.execute().body()?.data?.id
            val emailRetrofit = call.clone().execute().body()?.data?.email
            val firstNameRetrofit = call.clone().execute().body()?.data?.firstNamee
            val lastNameRetrofit = call.clone().execute().body()?.data?.last_name
            val avatarRetrofit = call.clone().execute().body()?.data?.avatar

            withContext(Dispatchers.Main) {

                val id = findViewById<TextView>(R.id.id)
                val email = findViewById<TextView>(R.id.email)
                val firstName = findViewById<TextView>(R.id.first_name)
                val lastNam = findViewById<TextView>(R.id.last_name)
                val avatar = findViewById<ImageView>(R.id.avatar)

                Picasso.with(applicationContext)
                    .load(avatarRetrofit)
                    .into(avatar)

                id.text = idRetrofit.toString()
                email.text = emailRetrofit
                firstName.text = firstNameRetrofit
                lastNam.text = lastNameRetrofit


            }

        }


    }
}