package com.example.natural_colombiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var parkList: ArrayList<ParkItem>
    private lateinit var parkAdapter: ParkAdapter
    private lateinit var parkRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        parkList = parkListFromJSON()
        parkAdapter = ParkAdapter(parkList, onItemClicked = { onRecyclerViewActivityClicked(it) })
        parkRecyclerView = findViewById(R.id.parks_recyclerview)

        parkRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = parkAdapter
            setHasFixedSize(false)
        }

        parkRecyclerView.adapter = parkAdapter
    }

    private fun onRecyclerViewActivityClicked(parks: ParkItem) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("parks", parks)
        startActivity(intent)
    }


    private fun parkListFromJSON(): ArrayList<ParkItem> {
        val parkListString : String = applicationContext.assets.open("parks.json").bufferedReader().use{it.readText()}
        val gson = Gson()
        return gson.fromJson(parkListString, Park::class.java)
    }
}