package com.example.futurehouse.MyProject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futurehouse.Home
import com.example.futurehouse.Profile.ProfilePageExperience
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_my_project_applied.*

class MyProjectApplied : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_project_applied)

        text_created_project.setOnClickListener {
            val intent = Intent(
                this@MyProjectApplied,
                MyProjectCreatedPro::class.java
            )
            startActivity(intent)
        }

        nav_home.setOnClickListener {
            val intent = Intent(
                this@MyProjectApplied,
                Home::class.java
            )
            startActivity(intent)
        }

        nav_profile.setOnClickListener {
            val intent = Intent(
                this@MyProjectApplied,
                ProfilePageExperience::class.java
            )
            startActivity(intent)
        }
    }
}
