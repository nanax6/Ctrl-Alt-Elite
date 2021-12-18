package com.example.parquescolombia.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parquescolombia.databinding.FragmentListBinding
import com.example.parquescolombia.ui.main.MainActivity
import com.example.parquescolombia.model.ParquesItem


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private val listViewModel:ListViewModel by viewModels()
    private lateinit var parquesAdapter: ParquesAdapter
    private var listaParques: ArrayList<ParquesItem> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.ocultarIcono()

//        listViewModel.cargaListaJson(context?.assets?.open("parques.json")?.bufferedReader().use{ it!!.readText() })

        listViewModel.getParksFromServer()

        listViewModel.onParquesLoaded.observe(viewLifecycleOwner, { result ->
            onParquesLoadedSubscriber(result)
        })

        parquesAdapter = ParquesAdapter(listaParques, onItemClicked = { onMainActivityClicked (it) })

        listBinding.listaParquesRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = parquesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onParquesLoadedSubscriber(result: ArrayList<ParquesItem>?) {
        result?.let{ listaParques ->
            parquesAdapter.appendItems(listaParques)
        }
    }

    private fun onMainActivityClicked(parques: ParquesItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(parque = parques))
    }

}