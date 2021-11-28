package com.example.naturalcolombiapp.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.naturalcolombiapp.databinding.ActivityDetailBinding
import com.example.naturalcolombiapp.model.ParquesItem
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val parques: ParquesItem = intent.extras?.getSerializable("parques") as ParquesItem

        with(detailBinding) {
            nombreParqueTextview.text = parques.parqueNacional
            Picasso.get().load(parques.fotoDetail).into(parqueImageView)
            descripcionContenidoTextView.text = parques.descripcionDetail
            ubicacionContenidoTextView.text = parques.ubicacion
            temperaturaContenidoTextView.text = parques.temperatura
            sitiosContenidoTextView.text = parques.sitios
        }

    }
}