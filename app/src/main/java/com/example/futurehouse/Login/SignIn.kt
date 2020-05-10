package com.example.futurehouse.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.futurehouse.Home
import com.example.futurehouse.R
import com.example.futurehouse.Utils.Preferences
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignIn : AppCompatActivity() {

    lateinit var iUsername :String
    lateinit var iPassword :String

    lateinit var mDatabase: DatabaseReference
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        mDatabase = FirebaseDatabase.getInstance().getReference("User")
        preferences = Preferences(this)

        btn_signin.setOnClickListener{
            iUsername = form_username.text.toString()
            iPassword = form_password.text.toString()

            if (iUsername == "") {
                form_username.error = "Fill Username"
                form_username.requestFocus()
            } else if (iPassword == "") {
                form_password.error = "Fill Password"
                form_password.requestFocus()
            } else {
                pushLogin(iUsername, iPassword)
            }
        }

        text_signup.setOnClickListener{
            val intent = Intent(this@SignIn,
                SignUp::class.java)
            startActivity(intent)
        }
    }

    private fun pushLogin(iUsername: String, iPassword: String) {
        mDatabase.child(iUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val intent = Intent(this@SignIn,
                            Home::class.java)
                        startActivity(intent)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@SignIn, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}

