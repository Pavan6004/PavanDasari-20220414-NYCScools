package com.example.pavandasari_20220414_nycscools.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.Time
import java.util.concurrent.TimeUnit


private val BASEURL = "https://data.cityofnewyork.us/"
class ApiClient {
    companion object {
        private var retrofit : Retrofit? = null
        fun getApiClient():Retrofit {
            val gson = GsonBuilder().setLenient().create()
            val okhttp = OkHttpClient.Builder()
                .readTimeout(100, TimeUnit.SECONDS)
                .connectTimeout(100,TimeUnit.SECONDS)
                .build()
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .client(okhttp)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }

            return  retrofit!!
        }
    }
}