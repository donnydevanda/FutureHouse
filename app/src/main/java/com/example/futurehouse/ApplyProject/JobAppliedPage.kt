package com.example.futurehouse.ApplyProject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.futurehouse.Home
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_job_applied_page.*

class JobAppliedPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_applied_page)

        btn_apply.setOnClickListener{
            val intent = Intent(this@JobAppliedPage,
                Home::class.java)
            startActivity(intent)
        }
    }
}
