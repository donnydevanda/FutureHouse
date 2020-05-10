package com.example.futurehouse.CreateProject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.futurehouse.Home
import com.example.futurehouse.R
import com.example.futurehouse.Utils.Preferences
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_create_project.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.btn_back
import kotlinx.android.synthetic.main.activity_sign_up.btn_next
import kotlinx.android.synthetic.main.activity_sign_up.text_back

class CreateProjectReview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_project_review)

        btn_next.setOnClickListener {
            val intent = Intent(
                this@CreateProjectReview,
                PostSuccess::class.java
            )
            startActivity(intent)
        }

        btn_back.setOnClickListener {
            val intent = Intent(
                this@CreateProjectReview,
                CreateProjectReview::class.java
            )
            startActivity(intent)
        }

        text_back.setOnClickListener {
            val intent = Intent(
                this@CreateProjectReview,
                CreateProjectReview::class.java
            )
            startActivity(intent)
        }
    }
}


