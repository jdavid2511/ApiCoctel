package com.example.apicocteleskt.model

import com.example.apicocteleskt.api.ApiClient
import com.example.apicocteleskt.api.ApiClientInt
import com.example.apicocteleskt.api.ApiResponse
import com.example.apicocteleskt.presenter.DrinksContract
import com.example.apicocteleskt.presenter.Presenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DrinksModel(val presenter: Presenter): DrinksContract.Model {

    override fun getCoctelsAlcoholics() {
        val call = ApiClient.getClient().create(ApiClientInt::class.java).getDrinkAlcoholic()
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    val coctelList: List<Drink>? = apiResponse?.getDrinksList()
                    // Asegúrate de que presenter.mostrarCoctelAlcoholics acepte una MutableLista nullable
                    coctelList?.toMutableList()?.let { presenter.viewCoctelAlcoholic(it) }
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                println("Error de conexión alcoholic: " + t.message)
                t.printStackTrace()
            }
        })
    }

    override fun getCoctelNoAlcoholic() {
        val call = ApiClient.getClient().create(ApiClientInt::class.java).getDrinksNonAlcoholic()
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    val cocteleList: List<Drink>? = apiResponse?.getDrinksList()
                    // Asegúrate de que presenter.mostrarCoctelAlcoholics acepte una MutableLista nullable
                    cocteleList?.toMutableList()?.let { presenter.viewCoctelNoAlcoholic(it) }
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                println("Error de conexión no alcoholic: " + t.message)
                t.printStackTrace()
            }
        })
    }

    override fun getOrdinaryDrinks() {
        val call = ApiClient.getClient().create(ApiClientInt::class.java).getDrinksOrdinary()
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    val coctelList: List<Drink>? = apiResponse?.getDrinksList()
                    // Asegúrate de que presenter.mostrarCoctelAlcoholics acepte una MutableLista nullable
                    coctelList?.toMutableList()?.let { presenter.viewOrdinary(it) }
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                println("Error de conexión alcoholic: " + t.message)
                t.printStackTrace()
            }
        })
    }

    override fun getCocktail() {
        val call = ApiClient.getClient().create(ApiClientInt::class.java).getCocktail()
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    val coctelList: List<Drink>? = apiResponse?.getDrinksList()
                    // Asegúrate de que presenter.mostrarCoctelAlcoholics acepte una MutableLista nullable
                    coctelList?.toMutableList()?.let { presenter.viewCocktail(it) }
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                println("Error de conexión alcoholic: " + t.message)
                t.printStackTrace()
            }
        })
    }

    override fun getCocktailGlass() {
        val call = ApiClient.getClient().create(ApiClientInt::class.java).getCocktailglass()
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    val coctelList: List<Drink>? = apiResponse?.getDrinksList()
                    // Asegúrate de que presenter.mostrarCoctelAlcoholics acepte una MutableLista nullable
                    coctelList?.toMutableList()?.let { presenter.viewCocktailGlass(it) }
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                println("Error de conexión alcoholic: " + t.message)
                t.printStackTrace()
            }
        })
    }

    override fun getChampageFlute() {
        val call = ApiClient.getClient().create(ApiClientInt::class.java).getChampageFlute()
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    val coctelList: List<Drink>? = apiResponse?.getDrinksList()
                    // Asegúrate de que presenter.mostrarCoctelAlcoholics acepte una MutableLista nullable
                    coctelList?.toMutableList()?.let { presenter.viewChampageFlute(it) }
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                println("Error de conexión alcoholic: " + t.message)
                t.printStackTrace()
            }
        })
    }
}
