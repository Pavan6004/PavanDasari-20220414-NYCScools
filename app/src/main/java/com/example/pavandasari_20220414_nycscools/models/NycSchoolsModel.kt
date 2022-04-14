package com.example.pavandasari_20220414_nycscools.models

data class NycResponse(
    val list:List<nyc>
)

data class nyc (
     val school_name: String,
     val website:String,
     val city :String
        )