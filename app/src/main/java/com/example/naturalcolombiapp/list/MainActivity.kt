package com.example.naturalcolombiapp.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.naturalcolombiapp.R
import com.example.naturalcolombiapp.detail.DetailActivity
import com.example.naturalcolombiapp.model.Parques
import com.example.naturalcolombiapp.model.ParquesItem
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var listaParques: ArrayList<ParquesItem>
    private lateinit var parquesAdapter: ParquesAdapter
    private lateinit var parquesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        parquesRecyclerView = findViewById(R.id.lista_parques_recyclerview)

        // listaParques = createMockParques()

        listaParques = cargaListaJson()
        parquesAdapter = ParquesAdapter(listaParques, onItemClicked = { onMainActivityClicked(it) })

        parquesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = parquesAdapter
            setHasFixedSize(false)
        }

        parquesRecyclerView.adapter = parquesAdapter
    }

    private fun onMainActivityClicked(parques: ParquesItem) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("parques", parques)
        startActivity(intent)

    }

    private fun cargaListaJson(): ArrayList<ParquesItem> {
        val parquesString: String =
            applicationContext.assets.open("parques.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val datos = gson.fromJson(parquesString, Parques::class.java)
        return datos
    }
}