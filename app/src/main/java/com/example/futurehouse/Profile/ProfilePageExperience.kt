package com.example.futurehouse.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futurehouse.Home
import com.example.futurehouse.MyProject.MyProjectApplied
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_my_project_applied.*
import kotlinx.android.synthetic.main.activity_profile_page_experience.*
import kotlinx.android.synthetic.main.activity_profile_page_experience.nav_myproject
import kotlinx.android.synthetic.main.activity_profile_page_review.nav_home
import kotlinx.android.synthetic.main.activity_profile_page_review.text_edit

class ProfilePageExperience : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page_experience)

        text_edit.setOnClickListener{
            val intent = Intent(this@ProfilePageExperience,
                EditProfile::class.java)
            startActivity(intent)
        }

        nav_home.setOnClickListener{
            val intent = Intent(this@ProfilePageExperience,
                Home::class.java)
            startActivity(intent)
        }

        nav_myproject.setOnClickListener{
            val intent = Intent(this@ProfilePageExperience,
                MyProjectApplied::class.java)
            startActivity(intent)
        }

        text_portfolio.setOnClickListener {
            val intent = Intent(
                this@ProfilePageExperience,
                ProfilePagePortfolio::class.java
            )
            startActivity(intent)
        }

        text_review.setOnClickListener {
            val intent = Intent(
                this@ProfilePageExperience,
                ProfilePageReview::class.java
            )
            startActivity(intent)
        }
    }
}
