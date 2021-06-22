package com.example.Models

class ProductModel {

    var dataProductData: ProductData? = null

    data class ProductData(
        val name: String,
        val description: String,
        val id: Int,
        val price: Long,
        val discount_amount: Long

    )

    data class Support(
        var url: String,
        var text: String
    )


}