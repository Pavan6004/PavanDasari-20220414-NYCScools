package com.example.pavandasari_20220414_nycscools.api

import com.example.pavandasari_20220414_nycscools.models.NycResponse
import retrofit2.Call
import retrofit2.http.GET

interface NyCService {
    @GET("resource/s3k6-pzi2.json")
    fun getSchoolData(): Call<NycResponse>
}