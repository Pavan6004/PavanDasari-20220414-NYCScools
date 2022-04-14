package com.example.pavandasari_20220414_nycscools

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pavandasari_20220414_nycscools.models.nyc

class NycAdapter:RecyclerView.Adapter<NycAdapter.ViewHolder>() {
    private var list : List<nyc>? = null

    fun setData( data : List<nyc>){
        list = data
        notifyDataSetChanged()
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val textView:TextView = itemView.findViewById(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list?.get(position)
       holder.textView.text =item?.school_name
    }

    override fun getItemCount(): Int {
      return list?.size?:0
    }
}