package com.example.nevoishbeta

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.LinearLayout

class splash : AppCompatActivity() {

    private lateinit var splashanim: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()



        val splashbg = findViewById<LinearLayout>(R.id.splashbg).apply {
            setBackgroundResource(R.drawable.splash_anim)
            splashanim = background as AnimationDrawable
            splashanim.start()

        }
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },5800)


    }
}