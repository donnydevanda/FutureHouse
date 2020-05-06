package com.example.futurehouse.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_edit_profile.btn_back
import kotlinx.android.synthetic.main.activity_edit_profile.btn_next
import kotlinx.android.synthetic.main.activity_edit_profile.text_back

class EditProfilePassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile_password)

        btn_back.setOnClickListener{
            val intent = Intent(this@EditProfilePassword,
                EditProfile::class.java)
            startActivity(intent)
        }

        text_back.setOnClickListener{
            val intent = Intent(this@EditProfilePassword,
                EditProfile::class.java)
            startActivity(intent)
        }

        btn_next.setOnClickListener{
            val intent = Intent(this@EditProfilePassword,
                EditProfile::class.java)
            startActivity(intent)
        }
    }
}
