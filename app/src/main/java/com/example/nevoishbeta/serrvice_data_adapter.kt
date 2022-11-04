package com.example.nevoishbeta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class serrvice_data_adapter(private  val service_list:ArrayList<Service_retreive_model>):RecyclerView.Adapter<serrvice_data_adapter.Viewholder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Viewholder {

        val  itemView = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent,false)
        return Viewholder(itemView)

    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val curr_service = service_list[position]
        holder.view1.text = curr_service.job_name
        holder.view2.text = curr_service.job_description
        holder.view3.text = curr_service.phone
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