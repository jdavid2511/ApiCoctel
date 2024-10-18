package com.example.apicocteleskt.model

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apicocteleskt.R

class DrinkAdapter(private var drinkList: MutableList<Drink>, private val context: Context) :
    RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {
    private val drinkListOriginal = drinkList.toMutableList()

    private lateinit var listener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(item: Drink)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_drink, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = drinkList[position]
        holder.idDrink.setText(drinkList[position].idDrink)
        holder.idNombre.setText(drinkList[position].strDrink)
        Glide.with(context).load(drinkList[position].strDrinkThumb).into(holder.iv_Drinks)
        holder.itemView.setOnClickListener {
            listener?.onItemClick(item)
        }
    }

    fun filtrado(txtBuscar: String) {
        val longitud = txtBuscar.length
        if (longitud == 0) {
            drinkList.run {
                clear()
                addAll(drinkListOriginal)
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                drinkList = drinkList.filter { drink ->
                        drink!!.strDrink?.toLowerCase()?.contains(txtBuscar.toLowerCase()) == true
                    }.toMutableList()
            } else {
                for (d in drinkList) {
                    if (d?.strDrink?.toLowerCase()
                            ?.contains(txtBuscar.toLowerCase())!!
                    ) {
                        drinkList.add(d)
                    }
                }
            }
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return drinkList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv_Drinks: ImageView = itemView.findViewById(R.id.iv_drink)
        val idNombre: TextView = itemView.findViewById(R.id.idNombre)
        internal val idDrink: TextView = itemView.findViewById(R.id.idDrink)
    }
}