package com.example.nevoishbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.nevoishbeta.adapters.viewpagerAdapter
import com.example.nevoishbeta.fragments.HomeFragment
import com.example.nevoishbeta.fragments.PostJobFragment

import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth

class Nevoish : AppCompatActivity() {

    private lateinit var viewpager:ViewPager
    private lateinit var tabs:TabLayout
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nevoish)

        auth = FirebaseAuth.getInstance()

//        val email = intent.getStringExtra("email")
//        val displayName = intent.getStringExtra("name")

//        findViewById<TextView>(R.id.curr_user).text = email + "\n" + displayName

        findViewById<Button>(R.id.logout_btn).setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
        }


        viewpager = findViewById(R.id.viewpager)
        tabs = findViewById(R.id.tabs)
        setuptab()
    }

    override fun onBackPressed() {
//        super.onBackPressed()
    }



    private fun setuptab(){
        val adapter = viewpagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(PostJobFragment(), "Post Job")
//        adapter.addFragment(settings(), "settings")
        viewpager.adapter = adapter
        tabs.setupWithViewPager(viewpager)



    }
}
