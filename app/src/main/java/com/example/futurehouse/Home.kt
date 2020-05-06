package com.example.futurehouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futurehouse.ApplyProject.AndroidDeveloper.AndroidFront
import com.example.futurehouse.ApplyProject.UIUX.UI
import com.example.futurehouse.ApplyProject.WebDeveloper.WebFront
import com.example.futurehouse.CreateProject.CreateProject
import com.example.futurehouse.MyProject.MyProjectApplied
import com.example.futurehouse.Profile.ProfilePageExperience
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //CREATE PROJECT
        btn_next.setOnClickListener {
            val intent = Intent(
                this@Home,
                CreateProject::class.java
            )
            startActivity(intent)
        }

        //FIND PROJECT (WEB)
        web.setOnClickListener {
            val intent = Intent(
                this@Home,
                WebFront::class.java
            )
            startActivity(intent)
        }

        //FIND PROJECT (ANDROID)
        android.setOnClickListener {
            val intent = Intent(
                this@Home,
                AndroidFront::class.java
            )
            startActivity(intent)
        }

        //FIND PROJECT UI/UX
        uiux.setOnClickListener {
            val intent = Intent(
                this@Home,
                UI::class.java
            )
            startActivity(intent)
        }

        //NAVBAR MYPROJECT
        nav_myproject.setOnClickListener {
            val intent = Intent(
                this@Home,
                MyProjectApplied::class.java
            )
            startActivity(intent)
        }

        //NAVBAR PROFILE
        nav_profile.setOnClickListener {
            val intent = Intent(
                this@Home,
                ProfilePageExperience::class.java
            )
            startActivity(intent)
        }
    }
}
