package com.example.futurehouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.futurehouse.ApplyProject.AllPage
import com.example.futurehouse.ApplyProject.UIUX.UI
import com.example.futurehouse.ApplyProject.WebDeveloper.WebFront
import com.example.futurehouse.CreateProject.CreateProject
import com.example.futurehouse.MyProject.MyProjectApplied
import com.example.futurehouse.Profile.ProfilePageExperience
import com.example.futurehouse.Utils.Preferences
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    private lateinit var preferences: Preferences
    lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        preferences = Preferences(this.applicationContext)
        mDatabase = FirebaseDatabase.getInstance().getReference("User")

        tv_name.text = "Welcome " + preferences.getValues("user") +" !"

        Glide.with(this)
            .load(preferences.getValues("url"))
            .apply(RequestOptions.circleCropTransform())
            .into(home_pic)

        //CREATE PROJECT
        btn_next.setOnClickListener {
            val intent = Intent(
                this@Home,
                CreateProject::class.java
            )
            startActivity(intent)
        }

        //FIND PROJECT (ALL)
        all.setOnClickListener {
            val intent = Intent(
                this@Home,
                AllPage::class.java
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

        //FIND PROJECT (UI/UX)
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
