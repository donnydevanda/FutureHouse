package com.example.futurehouse.CreateProject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futurehouse.Fragment.Navbar
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_post_success.*

class PostSuccess : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_success)

        btn_back_home.setOnClickListener{
            val intent = Intent(this@PostSuccess,
                Navbar::class.java)
            startActivity(intent)
        }
    }
}
