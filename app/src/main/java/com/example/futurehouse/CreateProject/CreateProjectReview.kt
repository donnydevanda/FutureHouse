package com.example.futurehouse.CreateProject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.futurehouse.ApplyProject.Project
import com.example.futurehouse.R
import com.example.futurehouse.Utils.Preferences
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_create_project_review.*
import kotlinx.android.synthetic.main.activity_sign_up.btn_back
import kotlinx.android.synthetic.main.activity_sign_up.text_back

class CreateProjectReview : AppCompatActivity() {

    companion object {
        const val getTitle = "title"
        const val getDesc = "desc"
        const val getAddress = "address"
        const val getDuration = "duration"
        const val getImage = "link"
    }

    private lateinit var mFirebaseDatabase: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase
    private lateinit var mDatabase: DatabaseReference

    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_project_review)


        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabase = FirebaseDatabase.getInstance().getReference()
        mFirebaseDatabase = mFirebaseInstance.getReference("Project")

        preferences = Preferences(this)

        btn_next_cpr.setOnClickListener {
            var sTitle = intent.getStringExtra(getTitle)
            var sDesc = intent.getStringExtra(getDesc)
            var sAddress = intent.getStringExtra(getAddress)
            var sDuration = intent.getStringExtra(getDuration)
            var sImage = intent.getStringExtra(getImage)
            var sFront = form_frontend.text.toString()
            var sBack = form_backend.text.toString()
            var sUI = form_ui.text.toString()
            var sUX = form_ux.text.toString()

            saveProject(sTitle, sDesc, sAddress, sDuration, sImage, sFront, sBack, sUI, sUX)
        }

        btn_back.setOnClickListener {
            val intent = Intent(
                this@CreateProjectReview,
                CreateProjectReview::class.java
            )
            startActivity(intent)
        }

        text_back.setOnClickListener {
            val intent = Intent(
                this@CreateProjectReview,
                CreateProjectReview::class.java
            )
            startActivity(intent)
        }
    }

    private fun saveProject(sTitle: String?, sDesc: String?, sAddress: String?, sDuration: String?,
                            sImage: String?, sFront: String?, sBack: String?, sUI: String?, sUX: String?) {
        val project = Project()
        project.title = sTitle
        project.desc = sDesc
        project.address = sAddress
        project.duration = sDuration
        project.images = sImage
        project.frontend = sFront
        project.backend = sBack
        project.ui = sUI
        project.ux = sUX

        if (sTitle != null) {
            checkingUsername(sTitle, project)
        }
    }

    private fun checkingUsername(iTitle: String, data: Project) {
        mFirebaseDatabase.child(iTitle).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val user = dataSnapshot.getValue(Project::class.java)
                if (user == null) {
                    mFirebaseDatabase.child(iTitle).setValue(data)
                    preferences.setValues("title", data.title.toString())
                    preferences.setValues("desc", data.desc.toString())
                    preferences.setValues("address", data.address.toString())
                    preferences.setValues("duration", data.duration.toString())
                    preferences.setValues("images", data.images.toString())
                    preferences.setValues("frontend", data.frontend.toString())
                    preferences.setValues("backend", data.backend.toString())
                    preferences.setValues("ui", data.ui.toString())
                    preferences.setValues("ux", data.ux.toString())
                    preferences.setValues("status", "1")

                    val intent = Intent(this@CreateProjectReview,
                        PostSuccess::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this@CreateProjectReview, "Title Used", Toast.LENGTH_LONG).show()

                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@CreateProjectReview, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}


