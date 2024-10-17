package com.example.apicocteleskt.presenter

import com.example.apicocteleskt.model.Drink

interface DrinksContract {

    interface Model {
        fun getCoctelsAlcoholics()
        fun getCoctelNoAlcoholic()
        fun getOrdinaryDrinks()
        fun getCocktail()
        fun getCocktailGlass()
        fun getChampageFlute()
    }

    interface Presenter {
        fun viewCoctelAlcoholic(drinksMutableList: MutableList<Drink>)
        fun getCoctelsAlcoholics()
        fun viewCoctelNoAlcoholic(drinksMutableList: MutableList<Drink>)
        fun getCoctelNoAlcoholic()
        fun viewOrdinary(drinksMutableList: MutableList<Drink>)
        fun getOrdinary()
        fun viewCocktail(drinksMutableList: MutableList<Drink>)
        fun getCocktail()
        fun viewCocktailGlass(drinksMutableList: MutableList<Drink>)
        fun getCocktailGlass()
        fun viewChampageFlute(drinksMutableList: MutableList<Drink>)
        fun getChampageFlute()
    }

    interface View {
        fun viewCoctelAlcoholic(drinksMutableList: MutableList<Drink>)
        fun viewCoctelNoAlcoholic(drinksMutableList: MutableList<Drink>)
        fun viewOrdinary(drinksMutableList: MutableList<Drink>)
        fun viewCocktail(drinksMutableList: MutableList<Drink>)
        fun viewCocktailGlass(drinksMutableList: MutableList<Drink>)
        fun viewChampageFlute(drinksMutableList: MutableList<Drink>)
    }
}