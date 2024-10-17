package com.example.apicocteleskt.api

import com.example.apicocteleskt.model.Drink

class ApiResponse (val drinks: List<Drink>) {

    fun getDrinksList(): List<Drink> {
        return drinks
    }
}