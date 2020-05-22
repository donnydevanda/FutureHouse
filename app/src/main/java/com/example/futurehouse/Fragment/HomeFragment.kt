package com.example.futurehouse.Fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.futurehouse.ApplyProject.AllPage
import com.example.futurehouse.ApplyProject.UIUX.UI
import com.example.futurehouse.ApplyProject.WebDeveloper.WebFront
import com.example.futurehouse.CreateProject.CreateProject
import com.example.futurehouse.R
import com.example.futurehouse.Utils.Preferences
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var preferences: Preferences
    lateinit var mDatabase: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        preferences = Preferences(activity!!.applicationContext)
        mDatabase = FirebaseDatabase.getInstance().getReference("User")

        tv_name.text = "Welcome " + preferences.getValues("user") +" !"

        Glide.with(this)
            .load(preferences.getValues("url"))
            .apply(RequestOptions.circleCropTransform())
            .into(home_pic)

        //CREATE PROJECT
        btn_next.setOnClickListener {
            val i = Intent(activity, CreateProject::class.java)
            startActivity(i)
            (activity as Activity?)!!
        }

        //FIND PROJECT (ALL)
        all.setOnClickListener {
            val i = Intent(activity, AllPage::class.java)
            startActivity(i)
            (activity as Activity?)!!
        }

        //FIND PROJECT (WEB)
        web.setOnClickListener {
            val i = Intent(activity, WebFront::class.java)
            startActivity(i)
            (activity as Activity?)!!
        }

        //FIND PROJECT (UI/UX)
        uiux.setOnClickListener {
            val i = Intent(activity, UI::class.java)
            startActivity(i)
            (activity as Activity?)!!
        }
    }
}
