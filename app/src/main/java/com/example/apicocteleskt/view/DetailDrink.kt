package com.example.apicocteleskt.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.apicocteleskt.R
import com.example.apicocteleskt.api.ApiClient
import com.example.apicocteleskt.api.ApiClientInt
import com.example.apicocteleskt.api.ApiResponse
import com.example.apicocteleskt.model.Drink
import com.example.apicocteleskt.model.IngredientAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailDrink : AppCompatActivity() {

    private lateinit var drink_name: TextView
    private lateinit var image_drink: ImageView
    private lateinit var recyclerView: RecyclerView
    private lateinit var id: String
    private lateinit var name: String
    private lateinit var img: String
    private lateinit var listIngredients: List<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_drink)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init()
        loadImage()
        loadIngredient()
    }

    private fun loadIngredient() {
        val call = ApiClient.getClient().create(ApiClientInt::class.java).getDrinkById(id)
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    val drinkDetailsList: List<Drink>? = apiResponse?.getDrinksList()

                    if (drinkDetailsList != null) {
                        for (drink in drinkDetailsList) {
                            listIngredients = listOfNotNull(
                                drink.strIngredient1,
                                drink.strIngredient2,
                                drink.strIngredient3,
                                drink.strIngredient4,
                                drink.strIngredient5,
                                drink.strIngredient6,
                                drink.strIngredient7,
                                drink.strIngredient8,
                                drink.strIngredient9,
                                drink.strIngredient10,
                                drink.strIngredient11,
                                drink.strIngredient12,
                                drink.strIngredient13,
                                drink.strIngredient14,
                                drink.strIngredient15
                            )
                        }

                        val recyclerView = findViewById<RecyclerView>(R.id.rv_ingredientes)
                        recyclerView.layoutManager = LinearLayoutManager(this@DetailDrink)
                        val adapter = IngredientAdapter(listIngredients)
                        recyclerView.adapter = adapter
                    }

                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                println("Error de conexión ingredientes: " + t.message)
                t.printStackTrace()
            }
        })
    }

    private fun loadImage() {
        Glide.with(this)
            .load(img) // URL de la imagen o recurso local
            .placeholder(R.drawable.ic_launcher_background) // Recurso de imagen de marcador de posición (opcional)
            .error(R.drawable.ic_launcher_background) // Recurso de imagen de error (opcional)
            .transition(DrawableTransitionOptions.withCrossFade()) // Opciones de transición (opcional)
            .into(image_drink)

    }

    private fun init(){
        id  = intent.getStringExtra("id").toString()
        name = intent.getStringExtra("name").toString()
        img = intent.getStringExtra("img").toString()

        drink_name = findViewById(R.id.drink_name)
        drink_name.text = name

        image_drink = findViewById(R.id.image_drink)
        recyclerView = findViewById(R.id.rv_ingredientes)
    }
}