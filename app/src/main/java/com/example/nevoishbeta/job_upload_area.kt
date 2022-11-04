package com.example.nevoishbeta
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class job_upload_area : AppCompatActivity() {

    private lateinit var filechooser:Button
    private lateinit var preview:ImageView

    //firebase

    private lateinit var auth: FirebaseAuth
    private lateinit var firebaseDatabase: FirebaseDatabase

    private lateinit var upload:Button
    lateinit var servicebio:EditText
    lateinit var phoneno:EditText
    lateinit var servicename:EditText
    lateinit var showdata:TextView
    lateinit var imageuri: Uri






    companion object{
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_upload_area)

        //firebase

        firebaseDatabase = FirebaseDatabase.getInstance()

//        filechooser = findViewById(R.id.pickimage_btn)
//        preview = findViewById(R.id.imageview)
        upload = findViewById(R.id.upload_btn)
        showdata = findViewById(R.id.dataoutput)
        showdata.text.toString()
//        getinfopage = findViewById(R.id.flash_shift)
//        getinfopage2 = findViewById(R.id.flash_shift2)



         servicename = findViewById(R.id.servicename_edt)

        servicebio = findViewById(R.id.description_edt)

        phoneno = findViewById(R.id.phone_edt)







        upload.setOnClickListener {
            uploadServiceData()
//            uploadImage()
        }

//        filechooser.setOnClickListener {
//            pickimage()
//
//        }
    }

//    private fun uploadImage() {
//
//        val storageReference = FirebaseStorage.getInstance().getReference("images/")
//
//        storageReference.putFile()
//
//    }



    private fun uploadServiceData() {
        val servicename = servicename.text.toString()
        val servicebio = servicebio.text.toString()
        val phone = phoneno.text.toString()

        val saveref = firebaseDatabase.getReference("job_data")
        saveref.child(phone).setValue(job_data(servicename,servicebio, "+254$phone"))
            .addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(this, "upload successful",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,MyHome::class.java))
                }

            }
            .addOnFailureListener {
                Toast.makeText(this, "upload failed",Toast.LENGTH_SHORT).show()
            }


    }

    private fun pickimage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            preview.setImageURI(data?.data)
        }
    }
}