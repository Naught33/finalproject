package com.example.nevoishbeta.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nevoishbeta.R
import com.example.nevoishbeta.job_data
import com.example.nevoishbeta.job_view_data

class Firebase_data_recyclerview(private val serviceList :ArrayList<job_view_data>): RecyclerView.Adapter<Firebase_data_recyclerview.viewholder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val serviceItemView = LayoutInflater.from(parent.context).inflate(R.layout.cardview,
        parent,false)
        return viewholder(serviceItemView)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val currentservice = serviceList[position]

        holder.service_alias.text = currentservice.job_name
        holder.service_bio.text = currentservice.job_description
        holder.client_contact.text = currentservice.phone
    }

    override fun getItemCount(): Int {
        return serviceList.size
    }

    class viewholder(serviceItemView:View) :RecyclerView.ViewHolder(serviceItemView){

        val service_alias : TextView = serviceItemView.findViewById(R.id.textView)
        val service_bio : TextView = serviceItemView.findViewById(R.id.textView2)
        val client_contact : TextView = serviceItemView.findViewById(R.id.textView3)



    }
}