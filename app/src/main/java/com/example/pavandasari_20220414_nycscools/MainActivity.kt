package com.example.pavandasari_20220414_nycscools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: NycAdapter
    private lateinit var viewModel: NycViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider(this)[NycViewModel::class.java]
        adapter = NycAdapter()
        findViewById<RecyclerView>(R.id.rv_list).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.rv_list).adapter = adapter


        viewModel.fetchData()
        viewModel.data?.observe(
            this
        ) {
            if (it != null) {
                adapter.setData(it.list)
            }
        }
    }
}