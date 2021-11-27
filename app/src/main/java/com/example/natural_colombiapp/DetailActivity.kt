package com.example.natural_colombiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.natural_colombiapp.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val parks: ParkItem = intent.extras?.getSerializable("parks") as ParkItem
        with(detailBinding) {
            nombreParqueTextview.text = parks.name
            Picasso.get().load(parks.imgUrlDetail).into(parqueImageView)
            descripcionContenidoTextView.text = parks.descDetail
            ubicacionContenidoTextView.text = parks.loc
            temperaturaContenidoTextView.text = parks.temp
            sitiosContenidoTextView.text = parks.relSites
        }
    }
}