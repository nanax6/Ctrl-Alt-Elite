package com.example.natural_colombiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class rv_MainActivity : AppCompatActivity() {
    private lateinit var parkList: ArrayList<Park>
    private lateinit var parkAdapter: parkAdapter
    private lateinit var parkRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_main)

        parkList = makeParkList()

        parkAdapter = parkAdapter(parkList)

        parkRecyclerView = findViewById(R.id.parks_recyclerview)

        parkRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = parkAdapter
            setHasFixedSize(false)
        }

        parkRecyclerView.adapter = parkAdapter


    }

    private fun makeParkList() : ArrayList<Park>{
        return arrayListOf(
            Park("Park 1","lorem 123"),
            Park("Park 1","lorem 123"),
            Park("Park 1","lorem 123"),
            Park("Park 1","lorem 123"),
            Park("Park 1","lorem 123"),
            Park("Park 1","lorem 123"),
            Park("Park 1","lorem 123"),
        )
    }
}