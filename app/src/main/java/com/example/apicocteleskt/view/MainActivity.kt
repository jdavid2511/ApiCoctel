package com.example.apicocteleskt.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apicocteleskt.R
import com.example.apicocteleskt.model.Drink
import com.example.apicocteleskt.model.DrinkAdapter
import com.example.apicocteleskt.model.ImageAdapter
import com.example.apicocteleskt.model.ImageAdapter.OnItemClickListener
import com.example.apicocteleskt.presenter.DrinksContract
import com.example.apicocteleskt.presenter.Presenter

class MainActivity : AppCompatActivity(), DrinksContract.View {

    private val presenter: DrinksContract.Presenter = Presenter(this)
    private lateinit var recyclerViewDrinks: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerViewDrinks = findViewById(R.id.rv_drinks)
        recyclerViewDrinks.layoutManager = GridLayoutManager(applicationContext, 2)

        activateOnClick()
    }

    /**
     * este metodo usa una propiedad performClick para que apenas
     * se inicie la aplicacion se simula un click en el boton seleccionado  */
    private fun activateOnClick() {
        findViewById<View>(R.id.Alcoholic).performClick()
    }

    fun getCoctelAlcoholic(view: View?) {
        presenter.getCoctelsAlcoholics()
    }

    fun getCocteNonAlcoholic(view: View?) {
        presenter.getCoctelNoAlcoholic()
    }

    fun getOrdinaryDrinks(view: View?) {
        presenter.getOrdinary()
    }

    fun getCocktail(view: View?) {
        presenter.getCocktail()
    }

    fun getCocktailGlass(view: View?) {
        presenter.getCocktailGlass()
    }

    fun getChampageFlute(view: View?) {
        presenter.getChampageFlute()
    }

    override fun viewCoctelAlcoholic(drinksList: MutableList<Drink>) {
        val drinkAdapter = DrinkAdapter(drinksList, this)
        recyclerViewDrinks.setAdapter(drinkAdapter)

        drinksList.reverse()
        setupImageCarousel(drinksList)
        drinkAdapter.setOnItemClickListener {
            fun onItemClick(item: Drink) {
                val intent = Intent(
                    this@MainActivity,
                    DrinkDetail::class.java
                )
                intent.putExtra("id", item.idDrink)
                intent.putExtra("name", item.strDrink)
                intent.putExtra("img", item.strDrinkThumb)
                startActivity(intent)
            }
        }
    }

    override fun viewCoctelNoAlcoholic(drinksList: MutableList<Drink>) {
        val drinkAdapter = DrinkAdapter(drinksList, this)
        recyclerViewDrinks.setAdapter(drinkAdapter)

        drinkAdapter.setOnItemClickListener {
            fun onItemClick(item: Drink) {
                val intent = Intent(
                    this@MainActivity,
                    DrinkDetail::class.java
                )
                intent.putExtra("id", item.idDrink)
                intent.putExtra("name", item.strDrink)
                intent.putExtra("img", item.strDrinkThumb)
                startActivity(intent)
            }
        }
    }

    override fun viewOrdinary(drinksList: MutableList<Drink>) {
        val drinkAdapter = DrinkAdapter(drinksList, this)
        recyclerViewDrinks.setAdapter(drinkAdapter)

        drinkAdapter.setOnItemClickListener ( DrinkAdapter.OnItemClickListener () {
            fun onItemClick(item: Drink) {
                val intent = Intent(
                    this@MainActivity,
                    DrinkDetail::class.java
                )
                intent.putExtra("id", item.idDrink)
                intent.putExtra("name", item.strDrink)
                intent.putExtra("img", item.strDrinkThumb)
                startActivity(intent)
            }
        })
    }

    override fun viewCocktail(drinksList: MutableList<Drink>) {
        val drinkAdapter = DrinkAdapter(drinksList, this)
        recyclerViewDrinks.setAdapter(drinkAdapter)

        drinkAdapter.setOnItemClickListener {
            fun onItemClick(item: Drink) {
                val intent = Intent(
                    this@MainActivity,
                    DrinkDetail::class.java
                )
                intent.putExtra("id", item.idDrink)
                intent.putExtra("name", item.strDrink)
                intent.putExtra("img", item.strDrinkThumb)
                startActivity(intent)
            }
        }
    }

    override fun viewCocktailGlass(drinksList: MutableList<Drink>) {
        val drinkAdapter = DrinkAdapter(drinksList, this)
        recyclerViewDrinks.setAdapter(drinkAdapter)

        drinkAdapter.setOnItemClickListener {
            fun onItemClick(item: Drink) {
                val intent = Intent(
                    this@MainActivity,
                    DrinkDetail::class.java
                )
                intent.putExtra("id", item.idDrink)
                intent.putExtra("name", item.strDrink)
                intent.putExtra("img", item.strDrinkThumb)
                startActivity(intent)
            }
        }
    }

    override fun viewChampageFlute(drinksList: MutableList<Drink>) {
        val drinkAdapter = DrinkAdapter(drinksList, this)
        recyclerViewDrinks.setAdapter(drinkAdapter)

        drinkAdapter.setOnItemClickListener {
            fun onItemClick(item: Drink) {
                val intent = Intent(
                    this@MainActivity,
                    DrinkDetail::class.java
                )
                intent.putExtra("id", item.idDrink)
                intent.putExtra("name", item.strDrink)
                intent.putExtra("img", item.strDrinkThumb)
                startActivity(intent)
            }
        }
    }

    private fun setupImageCarousel(imageUrls: MutableList<Drink>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerCarousel)
        val imageAdapter: ImageAdapter = ImageAdapter(this@MainActivity, imageUrls)
        recyclerView.adapter = imageAdapter
        OnItemClickListener{

        }
    }
}