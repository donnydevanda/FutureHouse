package com.example.futurehouse.ApplyProject.WebDeveloper

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_u_i.*


class WebBack : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_back)

        text_left.setOnClickListener {
            val intent = Intent(
                this@WebBack,
                WebFront::class.java
            )
            startActivity(intent)
            finish()
        }
    }
}