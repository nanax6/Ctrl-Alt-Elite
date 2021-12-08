package com.example.parquescolombia.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.parquescolombia.data.ParkRepository
import com.example.parquescolombia.model.Parques
import com.example.parquescolombia.model.ParquesItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListViewModel: ViewModel() {
    private val parquesLoad : MutableLiveData<ArrayList<ParquesItem>> = MutableLiveData()
    val onParquesLoaded : LiveData<ArrayList<ParquesItem>> =  parquesLoad

    private val repo = ParkRepository()

    fun getParksFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
            parquesLoad.postValue(repo.getParks())
        }
    }

    fun cargaListaJson(parquesString: String) {
        val gson = Gson()
        parquesLoad.value = gson.fromJson(parquesString, Parques::class.java)
    }
}