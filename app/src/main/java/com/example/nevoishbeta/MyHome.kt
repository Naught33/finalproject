package com.example.nevoishbeta

import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nevoishbeta.adapters.RecyclerViewAdapter
import com.example.nevoishbeta.databinding.ActivityMyHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.header_sidenav.*


class MyHome : AppCompatActivity() {

     private lateinit var auth: FirebaseAuth
     lateinit var menubar:ImageView
     lateinit var toggle:ActionBarDrawerToggle
     lateinit var databaseReference: DatabaseReference
    private lateinit var recyclerViewmain:RecyclerView
    private lateinit var service_list:ArrayList<Service_retreive_model>
    private lateinit var saveref :DatabaseReference

     lateinit var binding: ActivityMyHomeBinding


    override fun onBackPressed() {
//        super.onBackPressed()


    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMyHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerViewmain = findViewById(R.id.recyclerview1)
        recyclerViewmain.layoutManager = LinearLayoutManager(this)
        recyclerViewmain.setHasFixedSize(true)

        service_list = arrayListOf<Service_retreive_model>()
        getServiceData()
        getServices()

        var text = intent.getStringExtra(EXTRA_MESSAGE)





        binding.apply {
            toggle = ActionBarDrawerToggle(this@MyHome,DrawerLayout,R.string.open,R.string.close)
            DrawerLayout.addDrawerListener(toggle)
            toggle.syncState()
            sidenav.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.logout-> logout()
                    R.id.post_job-> startActivity(Intent(this@MyHome,job_upload_area::class.java))
                    R.id.switch_-> switchUser()

                }
                true
            }
        }



        auth = FirebaseAuth.getInstance()









        // getting the recyclerview by its id
//        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview1)
//        recyclerview.setHasFixedSize(true)
//
//        // this creates a vertical layout Manager
//        recyclerview.layoutManager = LinearLayoutManager(this)
//
//        // ArrayList of class ItemsViewModel
//        val data = ArrayList<ItemsViewModel>()
//
//        // This area lets me chose an image and give it a title
//        // the image with the count of view
//        for (i in 1..30) {
//
//            data.add(ItemsViewModel(R.drawable.splash_59, "service title","service bio","phone" ))
//        }
//
//        // This will pass the ArrayList to our Adapter
//        val adapter = RecyclerViewAdapter(data)
//
//        // Setting the Adapter with the recyclerview
//        recyclerview.adapter = adapter

        //other functions




    }

    private fun getServices() {

    }

    private fun openDrawer() {

    }

    private fun switchUser() {
        auth.signOut()
        startActivity(Intent(this, loginactivity::class.java))
    }

    private fun logout() {
        auth.signOut()

        startActivity(Intent(this, MainActivity::class.java))
    }
    private fun getServiceData() {
        recyclerViewmain.visibility = View.GONE

        saveref = FirebaseDatabase.getInstance().getReference("job_data")
        saveref.addValueEventListener(object : ValueEventListener {
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



