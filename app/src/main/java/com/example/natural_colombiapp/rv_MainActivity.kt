package com.example.natural_colombiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class rv_MainActivity : AppCompatActivity() {
    private lateinit var parkList: ArrayList<ParkItem>
    private lateinit var parkAdapter: parkAdapter
    private lateinit var parkRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_main)

        // parkList = makeParkList()

        parkList = parkListFromJSON()

        parkAdapter = parkAdapter(parkList)

        parkRecyclerView = findViewById(R.id.parks_recyclerview)

        parkRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = parkAdapter
            setHasFixedSize(false)
        }

        parkRecyclerView.adapter = parkAdapter
    }

    private fun parkListFromJSON(): ArrayList<ParkItem> {
        val parkListString : String = applicationContext.assets.open("parks.json").bufferedReader().use{it.readText()}
        val gson = Gson()
        val parkList = gson.fromJson(parkListString, Park::class.java)
        return parkList
    }

//    private fun makeParkList() : ArrayList<Park>{
//        return arrayListOf(
//            Park("Park 1","lorem 123","https://www.parquetayrona.com/wp-content/uploads/2018/12/DSC6345-copia-1800x828.jpg"),
//            Park("Park 1","lorem 123", "https://loremflickr.com/cache/resized/65535_51538180961_147cd85f8c_320_240_nofilter.jpg"),
//            Park("Park 1","lorem 123", "https://loremflickr.com/cache/resized/65535_51538180961_147cd85f8c_320_240_nofilter.jpg"),
//            Park("Park 1","lorem 123", "https://loremflickr.com/cache/resized/65535_51538180961_147cd85f8c_320_240_nofilter.jpg"),
//            Park("Park 1","lorem 123", "https://loremflickr.com/cache/resized/65535_51538180961_147cd85f8c_320_240_nofilter.jpg"),
//            Park("Park 1","lorem 123", "https://loremflickr.com/cache/resized/65535_51538180961_147cd85f8c_320_240_nofilter.jpg"),
//            Park("Park 1","lorem 123", "https://loremflickr.com/cache/resized/65535_51538180961_147cd85f8c_320_240_nofilter.jpg"),
//        )
//    }
}