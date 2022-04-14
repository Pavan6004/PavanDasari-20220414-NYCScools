package com.example.pavandasari_20220414_nycscools.repository

import com.example.pavandasari_20220414_nycscools.api.ApiClient
import com.example.pavandasari_20220414_nycscools.api.NyCService

class NyCRepo {
    private var apiService:NyCService? = null
    init {
        apiService = ApiClient.getApiClient().create(NyCService::class.java)
    }

    fun getData()  = apiService?.getSchoolData()
}