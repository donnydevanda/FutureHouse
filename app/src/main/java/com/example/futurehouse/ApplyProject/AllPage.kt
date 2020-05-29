package com.example.futurehouse.ApplyProject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.futurehouse.R
import com.example.futurehouse.Utils.Preferences
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_all_page.*
import java.util.*

class AllPage : AppCompatActivity() {

    private lateinit var preferences: Preferences
    lateinit var mDatabase: DatabaseReference

    private var dataList = ArrayList<Project>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_page)

        preferences = Preferences(this)
        mDatabase = FirebaseDatabase.getInstance().getReference("Project")
        rv_player_all.layoutManager = LinearLayoutManager(this@AllPage, LinearLayoutManager.VERTICAL, false)
        getData()

        btn_back_all.setOnClickListener{
            finish()
        }

        text_back_all.setOnClickListener{
            finish()
        }
    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                dataList.clear()
                for (getdataSnapshot in dataSnapshot.getChildren()) {

                    val projectX = getdataSnapshot.getValue(Project::class.java)
                    dataList.add(projectX!!)
                }

                rv_player_all.adapter =
                    ProjectAdapter(dataList) {
                        val intent = Intent(
                            this@AllPage,
                            JobDescriptionPage::class.java
                        ).putExtra("data", it)
                        startActivity(intent)
                    }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@AllPage, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }

}
