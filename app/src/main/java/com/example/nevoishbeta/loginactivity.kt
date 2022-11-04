package com.example.nevoishbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text


class loginactivity : AppCompatActivity() {

    lateinit var loginbutton:Button
    lateinit var pass2:EditText
    lateinit var enteremail:EditText
    lateinit var username:EditText
    //firebase auth

    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginactivity)

        supportActionBar?.hide()

        loginbutton = findViewById(R.id.log_in_button)
        pass2 = findViewById(R.id.pass2)
        enteremail = findViewById(R.id.enter_email)
        username = findViewById(R.id.username_edt2)

        loginbutton.setOnClickListener {
        }


        firebaseAuth = FirebaseAuth.getInstance()



        // initialising Firebase auth object


        loginbutton.setOnClickListener {
            login()

        }

    }




    private fun login() {


        val email = enteremail.text.toString()
        val pass = pass2.text.toString()
        // calling signInWithEmailAndPassword(email, pass)
        // function using Firebase auth object
        // On successful response Display a Toast
        firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "login succsessful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MyHome::class.java))

            } else
                Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
        }
        val username = username.text.toString()
        val intent = Intent(this, MyHome::class.java).apply {
            putExtra(EXTRA_MESSAGE, extras)


        }


    }


}

//private fun FirebaseAuth.signInWithCredential(username: String) {
//
//}
