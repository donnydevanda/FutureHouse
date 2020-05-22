package com.example.futurehouse.ApplyProject.UIUX

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futurehouse.Fragment.Navbar
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_u_i.text_left
import kotlinx.android.synthetic.main.activity_u_x.*

class UX : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_x)

        text_back_ux.setOnClickListener{
            val intent = Intent(this@UX,
                Navbar::class.java)
            startActivity(intent)
            finish()
        }

        text_back_ux.setOnClickListener{
            val intent = Intent(this@UX,
                Navbar::class.java)
            startActivity(intent)
            finish()
        }

        text_left.setOnClickListener{
            val intent = Intent(this@UX,
                UI::class.java)
            startActivity(intent)
            finish()
        }
    }
}
