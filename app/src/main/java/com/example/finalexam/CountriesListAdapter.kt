package com.example.finalexam

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountriesListAdapter(val countries: ArrayList<Country>, val context: Context): RecyclerView.Adapter<CountriesListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_country, parent, false)
        return MyViewHolder(view as RecyclerView)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val country = countries.get(position)
        holder.nameText.text = country.name
    }

    class MyViewHolder(view: RecyclerView): RecyclerView.ViewHolder(view){
        var nameText: TextView = view.findViewById(R.id.name)
    }

}