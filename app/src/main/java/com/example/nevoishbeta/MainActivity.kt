package com.example.nevoishbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

lateinit var login:Button
lateinit var signup:Button
//lateinit var sneakpeek:Button
lateinit var sneakpeek2:Button
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        supportActionBar?.hide()

        firebaseAuth = FirebaseAuth.getInstance()




        login = findViewById(R.id.login_btn)
        login.setOnClickListener {
            checkuser()
        }

            signup = findViewById(R.id.signup_btn)
            signup.setOnClickListener {
                val intent = Intent(this,signupactivity::class.java)
                startActivity(intent)}

//        DEVELOPER PREVIEW MODE

//        sneakpeek = findViewById(R.id.sneak_peek)
//        sneakpeek.setOnClickListener {
//            val intent = Intent(this, MyHome::class.java)
//            startActivity(intent)
//            Toast.makeText(this, "on preview mode" ,Toast.LENGTH_SHORT).show()
//
//        }

    }
    private fun checkuser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser !=null){
            startActivity(Intent(this, MyHome::class.java))
            finish()
        }else{
            val intent = Intent(this, loginactivity::class.java)
            startActivity(intent)
        }
}
}