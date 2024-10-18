package com.example.apicocteleskt.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClientInt {

    @GET("filter.php?a=Alcoholic")
    fun getDrinkAlcoholic(): Call<ApiResponse>

    @GET("filter.php?a=Non_Alcoholic")
    fun getDrinksNonAlcoholic(): Call<ApiResponse>

    @GET("filter.php?c=Ordinary_Drink")
    fun getDrinksOrdinary(): Call<ApiResponse>

    @GET("filter.php?c=Cocktail")
    fun getCocktail(): Call<ApiResponse>

    @GET("filter.php?g=Cocktail_glass")
    fun getCocktailglass(): Call<ApiResponse>

    @GET("filter.php?g=Champagne_flute")
    fun getChampageFlute(): Call<ApiResponse>

    @GET("lookup.php")
    fun getDrinkById(@Query("i") idDrink : String): Call<ApiResponse>

    @GET("{ingredient}")
    fun getImgIngredients(@Path("ingredient") ingredient: String): Call<ApiResponse>
}