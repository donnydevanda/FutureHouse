package com.example.futurehouse.ApplyProject.WebDeveloper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_u_i.*

class WebFront : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_front)

        text_right.setOnClickListener{
            val intent = Intent(this@WebFront,
                WebBack::class.java)
            startActivity(intent)
            finish()
        }
    }
}
