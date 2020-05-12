package com.example.futurehouse.CreateProject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.futurehouse.R

class ProjectAdapter(private var data: List<Project>,
                        private val listener: (Project) -> Unit)
    : RecyclerView.Adapter<ProjectAdapter.LeagueViewHolder>() {

    lateinit var ContextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context
        val inflatedView: View = layoutInflater.inflate(R.layout.item_list, parent, false)

        return LeagueViewHolder(
            inflatedView
        )
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(data[position], listener, ContextAdapter, position)
    }

    override fun getItemCount(): Int = data.size

    class LeagueViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvTitle: TextView = view.findViewById(R.id.item_title)
        private val tvAddress: TextView = view.findViewById(R.id.item_address)
        private val tvImage: ImageView = view.findViewById(R.id.item_image)

        fun bindItem(data: Project, listener: (Project) -> Unit, context : Context, position : Int) {

            tvTitle.text = data.title
            tvAddress.text = data.address
            Glide.with(context)
                .load(data.images)
                .into(tvImage);



            itemView.setOnClickListener {
                listener(data)
            }
        }

    }

}