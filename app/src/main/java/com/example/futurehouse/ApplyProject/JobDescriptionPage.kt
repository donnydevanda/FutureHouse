package com.example.futurehouse.ApplyProject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_job_description_page.*

class JobDescriptionPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_description_page)

        val data = intent.getParcelableExtra<Project>("data")

        titlemain.text = data?.title
        address.text = data?.address
        dur_desc.text = data?.duration
        desc_desc.text = data?.desc
        front_desc.text = data?.frontend
        back_desc.text = data?.backend
        ui_desc.text = data?.ui
        ux_desc.text = data?.ux
        Glide.with(this)
            .load(data?.images)
            .into(image_jd)


        btn_back_jd.setOnClickListener{
            val intent = Intent(this@JobDescriptionPage,
                AllPage::class.java)
            startActivity(intent)
            finish()
        }

        txt_back_jd.setOnClickListener{
            val intent = Intent(this@JobDescriptionPage,
                AllPage::class.java)
            startActivity(intent)
            finish()
        }

        btn_apply_jd.setOnClickListener{
            val intent = Intent(this@JobDescriptionPage,
                JobAppliedPage::class.java)
            startActivity(intent)
            finish()
        }

    }
}
