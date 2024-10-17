package com.example.apicocteleskt.presenter

import com.example.apicocteleskt.model.Drink
import com.example.apicocteleskt.model.DrinksModel

class Presenter(val view: DrinksContract.View) : DrinksContract.Presenter {

    private val model: DrinksContract.Model = DrinksModel(this)

    override fun viewCoctelAlcoholic(drinksList: MutableList<Drink>) {
        view.viewCoctelAlcoholic(drinksList)
    }

    override fun getCoctelsAlcoholics() {
        model.getCoctelsAlcoholics()
    }

    override fun viewCoctelNoAlcoholic(drinksList: MutableList<Drink>) {
        view.viewCoctelNoAlcoholic(drinksList)
    }

    override fun getCoctelNoAlcoholic() {
        model.getCoctelNoAlcoholic()
    }

    override fun viewOrdinary(drinksList: MutableList<Drink>) {
        view.viewOrdinary(drinksList)
    }

    override fun getOrdinary() {
        model.getOrdinaryDrinks()
    }

    override fun viewCocktail(drinksList: MutableList<Drink>) {
        view.viewCocktail(drinksList)
    }

    override fun getCocktail() {
        model.getCocktail()
    }

    override fun viewCocktailGlass(drinksList: MutableList<Drink>) {
        view.viewCocktailGlass(drinksList)
    }

    override fun getCocktailGlass() {
        model.getCocktailGlass()
    }

    override fun viewChampageFlute(drinksList: MutableList<Drink>) {
        view.viewChampageFlute(drinksList)
    }

    override fun getChampageFlute() {
        model.getChampageFlute()
    }
}