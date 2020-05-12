package com.example.futurehouse.Profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.futurehouse.ProfileFragment
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
            finish()
        }

        text_back.setOnClickListener{
            finish()
        }
    }
}
