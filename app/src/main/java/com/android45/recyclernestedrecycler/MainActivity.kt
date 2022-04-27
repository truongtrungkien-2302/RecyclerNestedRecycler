package com.android45.recyclernestedrecycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createMockData()
    }

    private fun bindDataWithUi(itemData: ArrayList<HashMap<String, String>>) {
        // Create vertical Layout Manager
        val rv = findViewById<RecyclerView>(R.id.locationDatesList)
        rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // Access RecyclerView Adapter and load the data
        val adapter = MainAdapter(itemData)
        rv.adapter = adapter
    }

    private fun createMockData() {
        // Initialize test locations
        val items: ArrayList<HashMap<String, String>> = ArrayList()
        val time = System.currentTimeMillis()
        // Load items into ArrayList
        items.add(hashMapOf("name" to "Walmart", "address" to "7250 Carson Blvd, Long Beach CA 90808, USA", "time" to time.toString()))
        items.add(hashMapOf("name" to "CVS", "address" to "7250 Carson Blvd, Long Beach CA 90808, USA", "time" to time.toString()))
        items.add(hashMapOf("name" to "Target", "address" to "7250 Carson Blvd, Long Beach CA 90808, USA", "time" to time.toString()))

        val tomorrowTime = time + (1000 * 60 * 60 * 24 * 3)
        items.add(hashMapOf("name" to "Whole Foods", "address" to "7250 Carson Blvd, Long Beach CA 90808, USA", "time" to tomorrowTime.toString()))
        items.add(hashMapOf("name" to "Rite Aid", "address" to "7250 Carson Blvd, Long Beach CA 90808, USA", "time" to tomorrowTime.toString()))
        items.add(hashMapOf("name" to "Publix", "address" to "7250 Carson Blvd, Long Beach CA 90808, USA", "time" to tomorrowTime.toString()))
        // Bind items to RecyclerView
        bindDataWithUi(items)
    }
}
