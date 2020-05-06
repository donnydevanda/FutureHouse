package com.example.futurehouse.ApplyProject.AndroidDeveloper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futurehouse.Home
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_android_front.*
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_u_i.*
import kotlinx.android.synthetic.main.activity_u_i.text_right
import kotlinx.android.synthetic.main.activity_u_x.*

class AndroidFront : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_front)

        text_right.setOnClickListener{
            val intent = Intent(this@AndroidFront,
                AndroidBack::class.java)
            startActivity(intent)
            finish()
        }
    }
}
