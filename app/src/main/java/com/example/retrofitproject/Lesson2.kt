package com.example.retrofitproject

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Lesson2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson2)

        GlobalScope.launch(Dispatchers.IO) {
            val call =
                ProductRetrofitService.retrofit.create(ProductInterfacee::class.java)
                    .getProductSingle()


            val nameRetrofit = call.execute().body()?.dataProductData?.name
            val descriptionRetrofit = call.clone().execute().body()?.dataProductData?.description
            val idRetrofit = call.clone().execute().body()?.dataProductData?.id
            val priceRetrofit = call.clone().execute().body()?.dataProductData?.price
            val discountRetrofit = call.clone().execute().body()?.dataProductData?.discount_amount


            withContext(Dispatchers.Main){
                val name = findViewById<TextView>(R.id.name)
                val description = findViewById<TextView>(R.id.description)
                val id = findViewById<TextView>(R.id.idRetrofitt)
                val price = findViewById<TextView>(R.id.price)
                val discount_amount = findViewById<TextView>(R.id.discount_amount)

                name.text = nameRetrofit
                description.text = descriptionRetrofit
                id.text = idRetrofit.toString()
                price.text = priceRetrofit.toString()
                discount_amount.text = discountRetrofit.toString()
            }

        }
    }
}