package com.example.mystarwarslist.view

import com.example.mystarwarslist.base.BaseView
import com.example.mystarwarslist.data.entity.*
import java.text.FieldPosition

interface ListView : BaseView {
    fun displayLoader()
    fun hideLoader()
    fun showFilms(filmsResults: ArrayList<Film>)
    fun showPeople(peopleList : ArrayList<People>)
    fun showPlanets(planetsList: ArrayList<Planet>)
    fun showSpecies(speciesList: ArrayList<Specie>)
    fun showStarships(starshipsList: ArrayList<Starship>)
    fun showVehicles(vehiclesList: ArrayList<Vehicle>)
    fun showError(throwable: Throwable)
    //fun gotoFilmDetails(film: Film)
}