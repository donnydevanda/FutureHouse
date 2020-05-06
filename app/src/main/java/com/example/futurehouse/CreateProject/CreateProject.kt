package com.example.futurehouse.CreateProject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futurehouse.Home
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.btn_next

class CreateProject : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_project)

        btn_next.setOnClickListener{
            val intent = Intent(this@CreateProject,
                CreateProjectReview::class.java)
            startActivity(intent)
        }

        btn_back.setOnClickListener{
            val intent = Intent(this@CreateProject,
                Home::class.java)
            startActivity(intent)
        }

        text_back.setOnClickListener{
            val intent = Intent(this@CreateProject,
                Home::class.java)
            startActivity(intent)
        }
    }
}
