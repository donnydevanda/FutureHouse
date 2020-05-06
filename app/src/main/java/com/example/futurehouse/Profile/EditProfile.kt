package com.example.futurehouse.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futurehouse.Home
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_edit_profile.*

class EditProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        text_password.setOnClickListener{
            val intent = Intent(this@EditProfile,
                EditProfilePassword::class.java)
            startActivity(intent)
        }

        btn_back.setOnClickListener{
            val intent = Intent(this@EditProfile,
                ProfilePageExperience::class.java)
            startActivity(intent)
        }

        text_back.setOnClickListener{
            val intent = Intent(this@EditProfile,
                ProfilePageExperience::class.java)
            startActivity(intent)
        }

        btn_next.setOnClickListener{
            val intent = Intent(this@EditProfile,
                ProfilePageExperience::class.java)
            startActivity(intent)
        }
    }
}
