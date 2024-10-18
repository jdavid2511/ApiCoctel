package com.example.apicocteleskt.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.apicocteleskt.R
import com.example.apicocteleskt.api.ApiClient
import com.example.apicocteleskt.api.ApiClientInt
import com.example.apicocteleskt.api.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IngredientAdapter(var ingredients: List<String>, private val context: Context) :
    RecyclerView.Adapter<IngredientAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ingredient, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ingredient = ingredients[position]
        holder.name.text = ingredient
        val call = ApiClient.getImgIngredient().create(ApiClientInt::class.java).getImgIngredients( "$ingredient.png")
        val url = call.request().url().toString()
        Glide.with(context)
            .load(url)
            .into(holder.iv_ingredient)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name)
        var iv_ingredient: ImageView = itemView.findViewById(R.id.iv_ingredient)
    }
}