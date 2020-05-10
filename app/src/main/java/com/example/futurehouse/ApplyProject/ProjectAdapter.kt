package com.example.futurehouse.ApplyProject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.futurehouse.CreateProject.Project
import com.example.futurehouse.R

class ProjectAdapter(private var data: List<Project>,
                        private val listener: (Project) -> Unit)
    : RecyclerView.Adapter<ProjectAdapter.LeagueViewHolder>() {

    lateinit var ContextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context
        val inflatedView: View = layoutInflater.inflate(R.layout.item_list, parent, false)

        return LeagueViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(data[position], listener, ContextAdapter, position)
    }

    override fun getItemCount(): Int = data.size

    class LeagueViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvTitle: TextView = view.findViewById(R.id.item_title)
        private val tvDesc: TextView = view.findViewById(R.id.item_desc)
        private val tvAddress: TextView = view.findViewById(R.id.item_address)

        //private val tvImage: ImageView = view.findViewById(R.id.iv_poster_image)

        fun bindItem(data: Project, listener: (Project) -> Unit, context : Context, position : Int) {

            tvTitle.text = data.title
            tvDesc.text = data.desc
            tvAddress.text = data.address

            itemView.setOnClickListener {
                listener(data)
            }
        }

    }

}