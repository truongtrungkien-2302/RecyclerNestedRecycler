package com.android45.recyclernestedrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android45.recyclernestedrecycler.R

class MainLocationAdapter(private val locationList: ArrayList<HashMap<String, String>>): RecyclerView.Adapter<MainLocationAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val location = locationList[position]
        holder.locationName.text = location["name"]
        holder.locationAddress.text = location["address"]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_locations, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return locationList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val locationName: TextView = itemView.findViewById(R.id.locationName)
        val locationAddress: TextView = itemView.findViewById(R.id.locationAddress)
    }

}