package com.example.retrofitproject

import com.google.gson.annotations.SerializedName

class UserModel {

    var data: UserData? = null

    data class UserData(
        val id: Int,
        val email: String,
        @SerializedName("first_name")
        val firstNamee: String,
        val last_name: String,
        val avatar: String
    )

    data class Support(
        var url: String,
        var text: String
    )


}