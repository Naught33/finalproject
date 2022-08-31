package com.example.nevoishbeta.recyclerviewdataview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nevoishbeta.R

class serrvice_data_adapter(private  val service_list:ArrayList<Service_retreive_model>):RecyclerView.Adapter<serrvice_data_adapter.Viewholder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):Viewholder {

        val  itemView = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent,false)
        return Viewholder(itemView)

    }

    override fun onBindViewHolder(holder: serrvice_data_adapter.Viewholder, position: Int) {
        val curr_service = service_list[position]
        holder.view1.text = curr_service.service_name
        holder.view2.text = curr_service.service_bio
        holder.view3.text = curr_service.client_contact
    }



    override fun getItemCount(): Int {
        return service_list.size
    }

    class Viewholder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val view1 : TextView = itemView.findViewById(R.id.textView)
        val view2 : TextView = itemView.findViewById(R.id.textView2)
        val view3 : TextView = itemView.findViewById(R.id.textView3)

    }
}