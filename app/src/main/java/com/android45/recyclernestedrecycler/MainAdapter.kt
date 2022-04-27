package com.android45.recyclernestedrecycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat


class MainAdapter(locationList: ArrayList<HashMap<String, String>>): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val byDates = locationList.groupBy { it["time"] }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Update date label
        val sdf = SimpleDateFormat("MM/dd/yyyy")
        val dateList = byDates.values.toMutableList()
        holder.date.text = sdf.format(dateList[position][0]["time"]?.toLong())
        // Create vertical Layout Manager
        holder.locationList.layoutManager = LinearLayoutManager(holder.locationList.context, RecyclerView.VERTICAL, false)
        // Access RecyclerView Adapter and load the data
        val adapter = MainLocationAdapter(dateList[position] as ArrayList<HashMap<String, String>>)
        holder.locationList.adapter = adapter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_dates, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return byDates.count()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val date: TextView = itemView.findViewById(R.id.locationDate)
        val locationList: RecyclerView = itemView.findViewById(R.id.locationList)
    }

}