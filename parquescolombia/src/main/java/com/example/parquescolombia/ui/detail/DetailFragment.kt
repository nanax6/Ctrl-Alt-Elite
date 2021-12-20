package com.example.parquescolombia.ui.detail
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.parquescolombia.databinding.FragmentDetailBinding
import com.example.parquescolombia.ui.main.MainActivity
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.mostrarIcono()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val parques = args.parque

        with(detailBinding) {
            nombreParqueTextview.text = parques.parqueNacional
            Picasso.get().load(parques.fotoDetail).into(parqueImageView)
            descripcionContenidoTextView.text = parques.descripcionDetail
            ubicacionContenidoTextView.text = parques.ubicacion
            temperaturaContenidoTextView.text = parques.temperatura
            sitiosContenidoTextView.text = parques.sitios

            mapButton.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToMapsFragment(mapArgs = parques))
            }
        }
    }

}