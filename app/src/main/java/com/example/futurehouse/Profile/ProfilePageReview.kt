package com.example.futurehouse.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futurehouse.Home
import com.example.futurehouse.MyProject.MyProjectApplied
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_profile_page_experience.*
import kotlinx.android.synthetic.main.activity_profile_page_portfolio.*
import kotlinx.android.synthetic.main.activity_profile_page_review.*
import kotlinx.android.synthetic.main.activity_profile_page_review.nav_home
import kotlinx.android.synthetic.main.activity_profile_page_review.nav_myproject
import kotlinx.android.synthetic.main.activity_profile_page_review.text_edit

class ProfilePageReview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page_review)

        text_edit.setOnClickListener{
            val intent = Intent(this@ProfilePageReview,
                EditProfile::class.java)
            startActivity(intent)
        }

        nav_home.setOnClickListener{
            val intent = Intent(this@ProfilePageReview,
                Home::class.java)
            startActivity(intent)
        }

        nav_myproject.setOnClickListener{
            val intent = Intent(this@ProfilePageReview,
                MyProjectApplied::class.java)
            startActivity(intent)
        }

        text_experience3.setOnClickListener {
            val intent = Intent(
                this@ProfilePageReview,
                ProfilePageExperience::class.java
            )
            startActivity(intent)
        }

        text_portfolio3.setOnClickListener {
            val intent = Intent(
                this@ProfilePageReview,
                ProfilePagePortfolio::class.java
            )
            startActivity(intent)
        }
    }
}
