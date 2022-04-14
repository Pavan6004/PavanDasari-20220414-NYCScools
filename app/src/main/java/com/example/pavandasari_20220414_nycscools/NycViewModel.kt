package com.example.pavandasari_20220414_nycscools

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pavandasari_20220414_nycscools.models.NycResponse
import com.example.pavandasari_20220414_nycscools.repository.NyCRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NycViewModel :ViewModel() {

    private var repo : NyCRepo? = null
    var data :MutableLiveData<NycResponse>? = null

    init {
        repo = NyCRepo()
        data = MutableLiveData()
    }

    fun fetchData() {
        repo?.getData()?.enqueue(object :Callback<NycResponse> {
            override fun onResponse(call: Call<NycResponse>, response: Response<NycResponse>) {
                if(response.isSuccessful){
                    data?.postValue(response.body())
                }else{
                    data?.postValue(null)
                }

            }

            override fun onFailure(call: Call<NycResponse>, t: Throwable) {
                data?.postValue(null)
            }

        })
    }
}