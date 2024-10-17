package com.example.apicocteleskt.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apicocteleskt.R
import com.example.apicocteleskt.model.Drink
import com.example.apicocteleskt.model.DrinkAdapter
import com.example.apicocteleskt.model.DrinkAdapter.OnItemClickListener
import com.example.apicocteleskt.model.ImageAdapter
import com.example.apicocteleskt.presenter.DrinksContract
import com.example.apicocteleskt.presenter.Presenter

class MainActivity : AppCompatActivity(), DrinksContract.View, SearchView.OnQueryTextListener {

    private val presenter: DrinksContract.Presenter = Presenter(this)
    private lateinit var recyclerViewDrinks: RecyclerView
    private lateinit var etBuscar: SearchView
    private lateinit var drinkAdapter: DrinkAdapter

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

        etBuscar = findViewById(R.id.search_bar)
        etBuscar.setOnQueryTextListener(this)

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
        drinkAdapter = DrinkAdapter(drinksList, this)
        recyclerViewDrinks.setAdapter(drinkAdapter)

        setupImageCarousel(drinksList.asReversed())

        drinkAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(item: Drink) {
                val intent = Intent(
                    this@MainActivity,
                    DetailDrink::class.java
                )
                intent.putExtra("id", item.idDrink)
                intent.putExtra("name", item.strDrink)
                intent.putExtra("img", item.strDrinkThumb)
                startActivity(intent)
            }
        })
    }

    override fun viewCoctelNoAlcoholic(drinksList: MutableList<Drink>) {
        drinkAdapter = DrinkAdapter(drinksList, this)
        recyclerViewDrinks.setAdapter(drinkAdapter)

        drinkAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(item: Drink) {
                val intent = Intent(
                    this@MainActivity,
                    DetailDrink::class.java
                )
                intent.putExtra("id", item.idDrink)
                intent.putExtra("name", item.strDrink)
                intent.putExtra("img", item.strDrinkThumb)
                startActivity(intent)
            }
        })
    }

    override fun viewOrdinary(drinksList: MutableList<Drink>) {
        drinkAdapter = DrinkAdapter(drinksList, this)
        recyclerViewDrinks.setAdapter(drinkAdapter)

        drinkAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(item: Drink) {
                val intent = Intent(
                    this@MainActivity,
                    DetailDrink::class.java
                )
                intent.putExtra("id", item.idDrink)
                intent.putExtra("name", item.strDrink)
                intent.putExtra("img", item.strDrinkThumb)
                startActivity(intent)
            }
        })
    }

    override fun viewCocktail(drinksList: MutableList<Drink>) {
        drinkAdapter = DrinkAdapter(drinksList, this)
        recyclerViewDrinks.setAdapter(drinkAdapter)

        drinkAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(item: Drink) {
                val intent = Intent(
                    this@MainActivity,
                    DetailDrink::class.java
                )
                intent.putExtra("id", item.idDrink)
                intent.putExtra("name", item.strDrink)
                intent.putExtra("img", item.strDrinkThumb)
                startActivity(intent)
            }
        })
    }

    override fun viewCocktailGlass(drinksList: MutableList<Drink>) {
        drinkAdapter = DrinkAdapter(drinksList, this)
        recyclerViewDrinks.setAdapter(drinkAdapter)

        drinkAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(item: Drink) {
                val intent = Intent(
                    this@MainActivity,
                    DetailDrink::class.java
                )
                intent.putExtra("id", item.idDrink)
                intent.putExtra("name", item.strDrink)
                intent.putExtra("img", item.strDrinkThumb)
                startActivity(intent)
            }
        })
    }

    override fun viewChampageFlute(drinksList: MutableList<Drink>) {
        drinkAdapter = DrinkAdapter(drinksList, this)
        recyclerViewDrinks.setAdapter(drinkAdapter)

        drinkAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(item: Drink) {
                val intent = Intent(
                    this@MainActivity,
                    DetailDrink::class.java
                )
                intent.putExtra("id", item.idDrink)
                intent.putExtra("name", item.strDrink)
                intent.putExtra("img", item.strDrinkThumb)
                startActivity(intent)
            }
        })
    }

    private fun setupImageCarousel(imageUrls: MutableList<Drink>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerCarousel)
        val imageAdapter = ImageAdapter(this@MainActivity, imageUrls)
        recyclerView.adapter = imageAdapter
        imageAdapter.setOnItemClickListener { item ->
            val intent = Intent(
                this@MainActivity,
                DetailDrink::class.java
            )
            intent.putExtra("id", item.idDrink)
            intent.putExtra("name", item.strDrink)
            intent.putExtra("img", item.strDrinkThumb)
            startActivity(intent)
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        drinkAdapter
        if (newText != null) {
            drinkAdapter.filtrado(newText)
        }
        return false
    }
}