package com.example.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.DataClass

class RepositoryAdapter:RecyclerView.Adapter<RepositoryAdapter.RepoViewHolder>(){

    private val data = mutableListOf<DataClass>()

    fun setData(repos: DataClass) {
        repos?.let {
            data.clear()
            data.addAll(listOf(repos))
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        return RepoViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.name.text = data[position].name
        holder.description.text = data[position].description
    }

    class RepoViewHolder(view: View): RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.name)
        val description: TextView = view.findViewById(R.id.description)
    }
}