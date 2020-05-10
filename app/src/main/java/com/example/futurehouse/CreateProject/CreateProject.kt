package com.example.futurehouse.CreateProject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.futurehouse.Home
import com.example.futurehouse.R
import com.example.futurehouse.Utils.Preferences
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_create_project.*
import kotlinx.android.synthetic.main.activity_sign_up.btn_back
import kotlinx.android.synthetic.main.activity_sign_up.btn_next
import kotlinx.android.synthetic.main.activity_sign_up.text_back

class CreateProject : AppCompatActivity() {

    lateinit var sTitle:String
    lateinit var sDesc:String
    lateinit var sAddress:String
    lateinit var sDuration:String

    private lateinit var mFirebaseDatabase: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase
    private lateinit var mDatabase: DatabaseReference

    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_project)

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabase = FirebaseDatabase.getInstance().getReference()
        mFirebaseDatabase = mFirebaseInstance.getReference("Project")

        preferences = Preferences(this)

        btn_next.setOnClickListener{
            sTitle = project_title.text.toString()
            sDesc = project_desc.text.toString()
            sAddress = project_address.text.toString()
            sDuration = project_duration.text.toString()

            if (sTitle.equals("")) {
                project_title.error = "Fill Title"
                project_title.requestFocus()
            } else if (sDesc.equals("")) {
                project_desc.error = "Fill Desc"
                project_desc.requestFocus()
            } else if (sAddress.equals("")) {
                project_address.error = "Fill Email"
                project_address.requestFocus()
            } else {
                saveProject(sTitle, sDesc, sAddress, sDuration)
            }
        }

        btn_back.setOnClickListener{
            val intent = Intent(this@CreateProject,
                Home::class.java)
            startActivity(intent)
        }

        text_back.setOnClickListener{
            val intent = Intent(this@CreateProject,
                Home::class.java)
            startActivity(intent)
        }
    }

    private fun saveProject(sTitle: String, sDesc: String, sAddress: String, sDuration: String) {
        val project = Project()
        project.title = sTitle
        project.desc = sDesc
        project.address = sAddress
        project.duration = sDuration

        if (sTitle!= null) {
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
                    preferences.setValues("status", "1")

                    val intent = Intent(this@CreateProject,
                        CreateProjectReview::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this@CreateProject, "Title used", Toast.LENGTH_LONG).show()

                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@CreateProject, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
