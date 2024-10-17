package com.example.apicocteleskt.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

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
    fun getDrinkById(@Path("i") id : String): Call<ApiResponse>


}