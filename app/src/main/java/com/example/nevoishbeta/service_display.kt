package com.example.nevoishbeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nevoishbeta.adapters.Firebase_data_recyclerview
import com.google.firebase.database.*

class service_display : AppCompatActivity() {

    private lateinit var saveref:DatabaseReference
    private lateinit var serviceRecyclerview:RecyclerView
    private lateinit var servicedata:ArrayList<job_view_data>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_display)

        serviceRecyclerview = findViewById(R.id.service_disp)
        serviceRecyclerview.layoutManager = LinearLayoutManager(this)
        serviceRecyclerview.setHasFixedSize(true)

        servicedata = arrayListOf<job_view_data>()
            getServiceData()



    }

    private fun getServiceData() {

        saveref = FirebaseDatabase.getInstance().getReference("job_data")
        saveref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){


                    for (myjob_view_data in snapshot.children){

                        val service = myjob_view_data.getValue(job_view_data::class.java)
                        servicedata.add(service!!)

                    }

                    serviceRecyclerview.adapter = Firebase_data_recyclerview(servicedata)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }
}