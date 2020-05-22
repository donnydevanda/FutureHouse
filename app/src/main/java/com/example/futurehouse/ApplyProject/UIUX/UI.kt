package com.example.futurehouse.ApplyProject.UIUX

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futurehouse.Fragment.Navbar
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_u_i.*

class UI : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_i)

        text_back_ui.setOnClickListener{
            val intent = Intent(this@UI,
                Navbar::class.java)
            startActivity(intent)
            finish()
        }

        text_back_ui.setOnClickListener{
            val intent = Intent(this@UI,
                Navbar::class.java)
            startActivity(intent)
            finish()
        }

        text_right.setOnClickListener{
            val intent = Intent(this@UI,
                UX::class.java)
            startActivity(intent)
            finish()
        }
    }
}
