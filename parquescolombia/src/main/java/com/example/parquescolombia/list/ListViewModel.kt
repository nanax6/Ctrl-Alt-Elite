package com.example.parquescolombia.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.parquescolombia.model.Parques
import com.example.parquescolombia.model.ParquesItem
import com.google.gson.Gson
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var parquesLoad : MutableLiveData<ArrayList<ParquesItem>> = MutableLiveData()
    val onParquesLoaded : LiveData<ArrayList<ParquesItem>> = parquesLoad

    fun cargaListaJson(parquesString: InputStream?) {
        val parquesString = parquesString?.bufferedReader().use{ it!!.readText() }
        val gson = Gson()
        parquesLoad.value = gson.fromJson(parquesString, Parques::class.java)

    }
}