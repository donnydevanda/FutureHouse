package com.example.futurehouse.Profile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.futurehouse.Login.SignUpPhoto
import com.example.futurehouse.Login.User
import com.example.futurehouse.R
import com.example.futurehouse.Utils.Preferences
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_edit_profile.btn_back
import kotlinx.android.synthetic.main.activity_edit_profile.text_back
import kotlinx.android.synthetic.main.activity_sign_up.*


class EditProfile : AppCompatActivity() {

    lateinit var sUsername:String
    lateinit var sPassword:String
    lateinit var sEmail:String
    lateinit var sWhatsapp:String
    lateinit var sFacebook:String
    lateinit var sLinkedin:String
    lateinit var sLocation:String

    private lateinit var mFirebaseDatabase: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase
    private lateinit var mDatabase: DatabaseReference

    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabase = FirebaseDatabase.getInstance().getReference()
        mFirebaseDatabase = mFirebaseInstance.getReference("User")

        preferences = Preferences(this)

        btn_save_ep.setOnClickListener{
            sUsername = preferences.getValues("user").toString()
            sEmail = preferences.getValues("email").toString()
            sWhatsapp = form_whatsapp.text.toString()
            sFacebook = form_facebook.text.toString()
            sLinkedin = form_linkedin.text.toString()
            sLocation = form_location.text.toString()

            saveUser(sUsername, sPassword, sEmail)

        }

        btn_back.setOnClickListener{
            finish()
        }

        text_back.setOnClickListener{
            finish()
        }
    }

    private fun saveUser(sUsername: String, sPassword: String, sEmail: String) {
        val user = User()
        user.email = sEmail
        user.username = sUsername
        user.whatsapp = sWhatsapp
        user.facebook = sFacebook
        user.linkedin = sLinkedin
        user.location = sLocation

        if (sUsername != null) {
            checkingUsername(sUsername, user)
        }
    }

    private fun checkingUsername(iUsername: String, data: User) {
        mFirebaseDatabase.child(iUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val user = dataSnapshot.getValue(User::class.java)
                if (user == null) {
                    mFirebaseDatabase.child(iUsername).setValue(data)

                    preferences.setValues("user", data.username.toString())
                    preferences.setValues("email", data.email.toString())
                    preferences.setValues("facebook", data.facebook.toString())
                    preferences.setValues("whatsapp", data.whatsapp.toString())
                    preferences.setValues("linkedin", data.linkedin.toString())
                    preferences.setValues("location", data.location.toString())
                    preferences.setValues("status", "1")
                    finish()

                } else {
                    Toast.makeText(this@EditProfile, "Username used", Toast.LENGTH_LONG).show()

                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@EditProfile, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
