package com.example.futurehouse.Login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.futurehouse.R
import com.example.futurehouse.Utils.Preferences
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUp : AppCompatActivity() {

    lateinit var sUsername:String
    lateinit var sPassword:String
    lateinit var sEmail:String

    private lateinit var mFirebaseDatabase: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase
    private lateinit var mDatabase: DatabaseReference

    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabase = FirebaseDatabase.getInstance().getReference()
        mFirebaseDatabase = mFirebaseInstance.getReference("User")

        preferences = Preferences(this)

        btn_next.setOnClickListener{
            sUsername = signup_username.text.toString()
            sPassword = signup_password.text.toString()
            sEmail = signup_email.text.toString()

            if (sUsername.equals("")) {
                signup_username.error = "Fill Username"
                signup_username.requestFocus()
            } else if (sPassword.equals("")) {
                signup_password.error = "Fill Password"
                signup_password.requestFocus()
            } else if (sEmail.equals("")) {
                signup_email.error = "Fill Email"
                signup_email.requestFocus()
            } else {

                saveUser(sUsername, sPassword, sEmail)

            }
        }

        btn_back.setOnClickListener{
            val intent = Intent(this@SignUp,
                SignIn::class.java)
            startActivity(intent)
        }

        text_back.setOnClickListener{
            val intent = Intent(this@SignUp,
                SignIn::class.java)
            startActivity(intent)
        }
    }

    private fun saveUser(sUsername: String, sPassword: String, sEmail: String) {
        val user = User()
        user.email = sEmail
        user.username = sUsername
        user.password = sPassword

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
                    preferences.setValues("status", "1")

                    val intent = Intent(this@SignUp,
                         SignUpPhoto::class.java)
                     startActivity(intent)

                } else {
                    Toast.makeText(this@SignUp, "Username used", Toast.LENGTH_LONG).show()

                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@SignUp, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
