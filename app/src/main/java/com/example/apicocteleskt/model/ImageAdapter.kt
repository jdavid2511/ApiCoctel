package com.example.apicocteleskt.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apicocteleskt.R
import com.example.apicocteleskt.model.DrinkAdapter.OnItemClickListener

class ImageAdapter(var context: Context, var listImages: MutableList<Drink>) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    private var listener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onItemClick(item: Drink)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.image_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listImages[position]
        Glide.with(context).load(listImages[position].strDrinkThumb).into(holder.imageView)

        holder.itemView.setOnClickListener {
           listener?.onItemClick(item)
        }
    }

    override fun getItemCount(): Int {
        return listImages.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.list_item_image)
    }
}