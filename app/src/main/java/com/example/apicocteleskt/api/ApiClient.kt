package com.example.apicocteleskt.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        fun getClient(): Retrofit {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }

        fun getImgIngredient(): Retrofit {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.thecocktaildb.com/images/ingredients/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
    }
}