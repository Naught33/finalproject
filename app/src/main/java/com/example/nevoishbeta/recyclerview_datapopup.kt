package com.example.nevoishbeta.recyclerviewdataview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nevoishbeta.R
import com.google.firebase.database.*

class recyclerview_datapopup : AppCompatActivity() {

    private lateinit var recyclerViewmain:RecyclerView
    private lateinit var service_list:ArrayList<Service_retreive_model>
    private lateinit var saveref :DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview_datapopup)

        recyclerViewmain = findViewById(R.id.data_popup_rv)
        recyclerViewmain.layoutManager = LinearLayoutManager(this)
        recyclerViewmain.setHasFixedSize(true)

        service_list = arrayListOf<Service_retreive_model>()
        getServiceData()

    }

    private fun getServiceData() {
        recyclerViewmain.visibility = View.GONE

       saveref = FirebaseDatabase.getInstance().getReference("job_data")
        saveref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                service_list.clear()
                if (snapshot.exists()){
                    for (services in snapshot.children){
                        val service_data = services.getValue(Service_retreive_model::class.java)
                        service_list.add(service_data!!)
                    }

                    val adapter = serrvice_data_adapter(service_list)
                    recyclerViewmain.adapter = adapter
                    recyclerViewmain.visibility = View.VISIBLE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}