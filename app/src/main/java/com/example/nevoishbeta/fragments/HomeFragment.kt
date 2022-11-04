package com.example.nevoishbeta.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nevoishbeta.R
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nevoishbeta.ItemsViewModel
import com.example.nevoishbeta.adapters.RecyclerViewAdapter


class HomeFragment : Fragment() {

//    lateinit var recyclerview:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        // getting the recyclerview by its id
//        recyclerview = view.findViewById(R.id.recyclerview)
//        // this creates a vertical layout Manager
//        recyclerview.layoutManager = LinearLayoutManager(this)
//
//        // ArrayList of class ItemsViewModel
//        val data = ArrayList<ItemsViewModel>()
//
//        // This loop will create 20 Views containing
//        // the image with the count of view
//        for (i in 1..20) {
//            data.add(ItemsViewModel(R.drawable.splash_59, "Item " + i))
//        }
//
//        // This will pass the ArrayList to our Adapter
//        val adapter = RecyclerViewAdapter(data)
//
//        // Setting the Adapter with the recyclerview
//        recyclerview.adapter = adapter

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)



    }



}


