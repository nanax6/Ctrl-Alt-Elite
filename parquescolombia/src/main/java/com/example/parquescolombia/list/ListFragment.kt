package com.example.parquescolombia.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parquescolombia.databinding.FragmentListBinding
import com.example.parquescolombia.main.MainActivity
import com.example.parquescolombia.model.ParquesItem


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var parquesAdapter: ParquesAdapter
    private var listaParques: ArrayList<ParquesItem> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]

        return listBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity?)?.ocultarIcono()
        listViewModel.cargaListaJson(context?.assets?.open("parques.json"))

        listViewModel.onParquesLoaded.observe(viewLifecycleOwner, {resultado ->
            onParquesLoadedSubscribe(resultado)
        })

        parquesAdapter = ParquesAdapter(listaParques, onItemClicked = { onMainActivityClicked (it) })

        listBinding.listaParquesRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = parquesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onParquesLoadedSubscribe(resultado: ArrayList<ParquesItem>?) {
        resultado?.let { listaParques ->
            parquesAdapter.agregarItems(listaParques)

        }

    }

    private fun onMainActivityClicked(parques: ParquesItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(parque = parques))

    }


}