package com.example.natural_colombiapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class parkAdapter(private val parks: ArrayList<Park>) : RecyclerView.Adapter<parkAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val park = parks[position]
        holder.bind(park)
    }

    override fun getItemCount(): Int {
        return parks.size
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private var titleTextView : TextView = view.findViewById(R.id.title_textView)
        private var descTextView : TextView = view.findViewById(R.id.desc_textView)
        private var pictureImageView : ImageView = view.findViewById(R.id.picture_imageView)

        fun bind(park : Park){
            titleTextView.text = park.name
            descTextView.text = park.desc
            // pictureImageView

        }

    }
}