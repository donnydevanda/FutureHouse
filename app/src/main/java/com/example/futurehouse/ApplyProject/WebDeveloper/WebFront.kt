package com.example.futurehouse.ApplyProject.WebDeveloper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futurehouse.Fragment.Navbar
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_u_i.text_right
import kotlinx.android.synthetic.main.activity_web_front.*

class WebFront : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_front)

        text_back_wf.setOnClickListener{
            val intent = Intent(this@WebFront,
                Navbar::class.java)
            startActivity(intent)
            finish()
        }

        btn_back_wf.setOnClickListener{
            val intent = Intent(this@WebFront,
                Navbar::class.java)
            startActivity(intent)
            finish()
        }

        text_right.setOnClickListener{
            val intent = Intent(this@WebFront,
                WebBack::class.java)
            startActivity(intent)
            finish()
        }
    }
}
