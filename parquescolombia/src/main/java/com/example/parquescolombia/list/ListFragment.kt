package com.example.parquescolombia.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parquescolombia.databinding.FragmentListBinding
import com.example.parquescolombia.model.Parques
import com.example.parquescolombia.model.ParquesItem
import com.google.gson.Gson



class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var parquesAdapter: ParquesAdapter
    private lateinit var listaParques: ArrayList<ParquesItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listaParques = cargaListaJson ()
        parquesAdapter = ParquesAdapter(listaParques, onItemClicked = { onMainActivityClicked (it) })

        listBinding.listaParquesRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = parquesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onMainActivityClicked(parques: ParquesItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(parque = parques))

    }

    private fun cargaListaJson(): ArrayList<ParquesItem> {
        val parquesString: String = context?.assets?.open("parques.json")?.bufferedReader().use{ it!!.readText() }
        val gson = Gson()
        val datos = gson.fromJson(parquesString, Parques::class.java)
        return datos
    }
}