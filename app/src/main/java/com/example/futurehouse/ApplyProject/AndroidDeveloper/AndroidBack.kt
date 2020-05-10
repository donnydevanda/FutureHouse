package com.example.futurehouse.ApplyProject.AndroidDeveloper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futurehouse.Home
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_android_back.*
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_u_i.*
import kotlinx.android.synthetic.main.activity_u_i.text_left

class AndroidBack : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_back)

        text_back_ab.setOnClickListener{
            val intent = Intent(this@AndroidBack,
                Home::class.java)
            startActivity(intent)
            finish()
        }

        text_back_ab.setOnClickListener{
            val intent = Intent(this@AndroidBack,
                Home::class.java)
            startActivity(intent)
            finish()
        }

        text_left.setOnClickListener{
            val intent = Intent(this@AndroidBack,
                AndroidFront::class.java)
            startActivity(intent)
            finish()
        }
    }
}
