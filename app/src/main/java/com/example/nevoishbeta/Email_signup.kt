package com.example.nevoishbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.nevoishbeta.databinding.ActivitySignupactivityBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Email_signup : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignupactivityBinding


    lateinit var pass: EditText
    lateinit var email:EditText
    lateinit var confirmpass: EditText
    lateinit var username:EditText

    lateinit var databaseReference: DatabaseReference
    lateinit var databse:FirebaseDatabase

    lateinit var signup:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_signp)

        binding = ActivitySignupactivityBinding.inflate(layoutInflater)
        auth = FirebaseAuth.getInstance()

        pass = findViewById(R.id.pass_edt)
        confirmpass = findViewById(R.id.passconfirm_edt)
        email = findViewById(R.id.email_edt)
        signup = findViewById(R.id.sign_up_btn2)
        username = findViewById(R.id.username_edt)
        databse = FirebaseDatabase.getInstance()




        signup.setOnClickListener {
            signUpUser()
            uploadUserDeatails()
            sendUserName()

        }

        //signup area

    }

    private fun sendUserName() {
        val username = username.text.toString()

    }

    private fun uploadUserDeatails() {

            val username = username.text.toString()
            val pass = pass.text.toString()


            val saveref = databse.getReference("users")
            saveref.child(username).setValue(users(username,pass))
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this, "data updated",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,MyHome::class.java))
                    }

                }
                .addOnFailureListener {
                    Toast.makeText(this, "failed",Toast.LENGTH_SHORT).show()
                }



    }

    private fun signUpUser() {
        val email = email.text.toString()
        val pass = pass.text.toString()
        val confirmPassword = confirmpass.text.toString()

        // check pass
        if (email.isBlank() || pass.isBlank() || confirmPassword.isBlank()) {
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }

        if (pass != confirmPassword) {
            Toast.makeText(
                this,
                "Password and Confirm Password do not match",
                Toast.LENGTH_SHORT
            )
                .show()
            return
        }
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully Signed Up", Toast.LENGTH_SHORT).show()
                finish()
                val intent = Intent(this, MyHome::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Sign Up Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}