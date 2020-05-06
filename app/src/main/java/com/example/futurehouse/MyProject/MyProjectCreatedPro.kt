package com.example.futurehouse.MyProject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futurehouse.Home
import com.example.futurehouse.Profile.ProfilePageExperience
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_my_project_created_pro.*

class MyProjectCreatedPro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_project_created_pro)

        text_applied_project.setOnClickListener {
            val intent = Intent(
                this@MyProjectCreatedPro,
                MyProjectApplied::class.java
            )
            startActivity(intent)
        }

        nav_home.setOnClickListener {
            val intent = Intent(
                this@MyProjectCreatedPro,
                Home::class.java
            )
            startActivity(intent)
        }

        nav_profile.setOnClickListener {
            val intent = Intent(
                this@MyProjectCreatedPro,
                ProfilePageExperience::class.java
            )
            startActivity(intent)
        }
    }
}
