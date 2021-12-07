package com.example.parquescolombia.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parquescolombia.R
import com.example.parquescolombia.model.ParquesItem
import com.squareup.picasso.Picasso


class ParquesAdapter(
    private val parquesList: ArrayList<ParquesItem>,
    private val onItemClicked: (ParquesItem) -> Unit
) : RecyclerView.Adapter<ParquesAdapter.ParquesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParquesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_lista_parques, parent, false)
        return ParquesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParquesViewHolder, position: Int) {
        val parques = parquesList[position]
        holder.itemView.setOnClickListener{ onItemClicked(parquesList[position]) }
        holder.bind(parques)
    }

    override fun getItemCount(): Int = parquesList.size

    fun agregarItems(newItems: ArrayList<ParquesItem>) {
        parquesList.clear()
        parquesList.addAll(newItems)
        notifyDataSetChanged()
    }


    class ParquesViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        private var nombreParqueTextView: TextView =
            ItemView.findViewById(R.id.nombre_parque_textView)
        private var descripcionTextView: TextView = ItemView.findViewById(R.id.descripcion_textView)
        private var fotoParqueImageView: ImageView =
            ItemView.findViewById(R.id.foto_parque_imageView)
        private var ratingBar: RatingBar = ItemView.findViewById(R.id.ratingBar)

        fun bind(parque: ParquesItem) {
            nombreParqueTextView.text = parque.parqueNacional
            descripcionTextView.text = parque.descripcion
            Picasso.get().load(parque.foto).into(fotoParqueImageView)
            ratingBar.rating = parque.puntuacion
        }

    }
}