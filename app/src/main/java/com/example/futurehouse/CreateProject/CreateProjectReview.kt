package com.example.futurehouse.CreateProject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class CreateProjectReview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_project_review)

        btn_next.setOnClickListener{
            val intent = Intent(this@CreateProjectReview,
                PostSuccess::class.java)
            startActivity(intent)
        }

        btn_back.setOnClickListener{
            val intent = Intent(this@CreateProjectReview,
                CreateProjectReview::class.java)
            startActivity(intent)
        }

        text_back.setOnClickListener{
            val intent = Intent(this@CreateProjectReview,
                CreateProjectReview::class.java)
            startActivity(intent)
        }
    }
}
