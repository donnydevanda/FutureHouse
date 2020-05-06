package com.example.futurehouse.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futurehouse.Home
import com.example.futurehouse.MyProject.MyProjectApplied
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_profile_page_experience.*
import kotlinx.android.synthetic.main.activity_profile_page_portfolio.*
import kotlinx.android.synthetic.main.activity_profile_page_portfolio.nav_home
import kotlinx.android.synthetic.main.activity_profile_page_portfolio.nav_myproject
import kotlinx.android.synthetic.main.activity_profile_page_portfolio.text_edit
import kotlinx.android.synthetic.main.activity_profile_page_review.*

class ProfilePagePortfolio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page_portfolio)

        text_edit.setOnClickListener{
            val intent = Intent(this@ProfilePagePortfolio,
                EditProfile::class.java)
            startActivity(intent)
        }

        nav_home.setOnClickListener{
            val intent = Intent(this@ProfilePagePortfolio,
                Home::class.java)
            startActivity(intent)
        }

        nav_myproject.setOnClickListener{
            val intent = Intent(this@ProfilePagePortfolio,
                MyProjectApplied::class.java)
            startActivity(intent)
        }

        text_experience2.setOnClickListener {
            val intent = Intent(
                this@ProfilePagePortfolio,
                ProfilePageExperience::class.java
            )
            startActivity(intent)
        }

        text_review2.setOnClickListener {
            val intent = Intent(
                this@ProfilePagePortfolio,
                ProfilePageReview::class.java
            )
            startActivity(intent)
        }
    }
}
