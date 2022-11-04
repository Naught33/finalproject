package com.example.nevoishbeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.nevoishbeta.databinding.ActivityJobappMainBinding
import com.google.firebase.database.*

class jobapp_main : AppCompatActivity() {
    lateinit var binding: ActivityJobappMainBinding
    lateinit var dataBase:DatabaseReference
    lateinit var servicename:TextView
    lateinit var get_INFO:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jobapp_main)

        servicename = findViewById(R.id.view1)
        get_INFO = findViewById(R.id.getinfo)

        get_INFO.setOnClickListener {

            printInfo()

        }



    }

    private fun printInfo() {

        dataBase = FirebaseDatabase.getInstance().getReference("job_data")

        var service_name = dataBase.child("job_name").get().addOnCompleteListener {
            it.toString()
            Toast.makeText(this, "successful", Toast.LENGTH_SHORT).show()
        }


        servicename.setText("Service Name:${service_name.toString()}")
        }



    }
