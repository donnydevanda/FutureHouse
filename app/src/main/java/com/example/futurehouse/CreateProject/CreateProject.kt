package com.example.futurehouse.CreateProject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.futurehouse.R
import kotlinx.android.synthetic.main.activity_create_project.*

class CreateProject : AppCompatActivity(), View.OnClickListener {

    lateinit var sTitle:String
    lateinit var sDesc:String
    lateinit var sAddress:String
    lateinit var sDuration:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_project)

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_next_cp)
        btnMoveWithDataActivity.setOnClickListener(this)

        btn_back.setOnClickListener {
            val intent = Intent(
                this@CreateProject,
                CreateProjectReview::class.java
            )
            startActivity(intent)
        }

        text_back.setOnClickListener {
            val intent = Intent(
                this@CreateProject,
                CreateProjectReview::class.java
            )
            startActivity(intent)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_next_cp -> {
                btn_next_cp.setOnClickListener {
                    val moveWithDataIntent = Intent(this@CreateProject, CreateProjectReview::class.java)
                    moveWithDataIntent.putExtra(CreateProjectReview.getTitle,  project_title.text.toString())
                    moveWithDataIntent.putExtra(CreateProjectReview.getDesc, project_desc.text.toString())
                    moveWithDataIntent.putExtra(CreateProjectReview.getAddress, project_address.text.toString())
                    moveWithDataIntent.putExtra(CreateProjectReview.getDuration, project_duration.text.toString())
                    startActivity(moveWithDataIntent)
                }
            }
        }
    }
}
