package com.example.mystarwarslist.viewmodel

import android.content.Context
import com.example.mystarwarslist.base.BaseViewModel
import com.example.mystarwarslist.data.entity.*
import com.example.mystarwarslist.data.network.MyStarWarsListService
import com.example.mystarwarslist.view.ListView
import com.example.mystarwarslist.view.adapters.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListFragmentViewModel
@Inject constructor(private val service: MyStarWarsListService, private val context: Context) : BaseViewModel<ListView>(),
 FilmListAdapter.ClickOnRecycler, PeopleListAdapter.ClickOnRecycler, PlanetListAdapter.ClickOnRecycler, SpecieListAdapter.ClickOnRecycler, StarshipListAdapter.ClickOnRecycler, VehicleListAdapter.ClickOnRecycler {

    var people = ArrayList<People>()
    var species = ArrayList<Specie>()
    var planets = ArrayList<Planet>()
    var vehicles = ArrayList<Vehicle>()
    var starships = ArrayList<Starship>()

    override fun itemClicked(position: Int, context: Context) {
        TODO("Not yet implemented")
    }

    fun start(position: Int) {
        view.displayLoader()
        when(position){
            0 -> getPeople(1)
            1 -> getPlanets(1)
            2 -> getFilms()
            3 -> getSpecies(1)
            4 -> getVehicles(1)
            5 -> getStarships(1)
        }

    }

    fun getFilms() {
        service.getFilms()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy (
                        onError = {
                            view.showError(it)
                        },
                    onSuccess = {
                        view.showFilms(it)
                    }
                )

    }

    fun getPlanets(page : Int) {
        var myPage : Int = page
        service.getPlanets(myPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy (
                        onError = {
                            view.showError(it)
                        },
                        onSuccess = {
                            if (it.next != null) {
                                myPage++
                                getPlanets(myPage)
                            }
                            for (i in 0..it.results.size-1){
                                planets.add(it.results[i])
                            }
                            view.showPlanets(planets)
                        }
                )

    }

    fun getVehicles(page : Int) {
        var myPage : Int = page
        service.getVehicles(myPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy (
                        onError = {
                            view.showError(it)
                        },
                        onSuccess = {
                            if (it.next != null) {
                                myPage++
                                getVehicles(myPage)
                            }
                            for (i in 0..it.results.size-1){
                                vehicles.add(it.results[i])
                            }
                            view.showVehicles(vehicles)
                        }
                )

    }
    fun getStarships(page : Int) {
        var myPage : Int = page
        service.getStarships(myPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy (
                        onError = {
                            view.showError(it)
                        },
                        onSuccess = {
                            if (it.next != null) {
                                myPage++
                                getStarships(myPage)
                            }
                            for (i in 0..it.results.size-1){
                                starships.add(it.results[i])
                            }
                            view.showStarships(starships)
                        }
                )

    }

    fun getPeople(page : Int) {
        var myPage : Int = page

        service.getPeople(myPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy (
                        onError = {
                            view.showError(it)
                        },
                        onSuccess = {
                            if (it.next != null) {
                                myPage++
                                getPeople(myPage)
                            }
                            for (i in 0..it.results.size-1){
                                people.add(it.results[i])
                            }
                            view.showPeople(people)
                        }
                )

    }

    fun getSpecies(page : Int) {
        var myPage : Int = page
        service.getSpecies(myPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy (
                        onError = {
                            view.showError(it)
                        },
                        onSuccess = {
                            if (it.next != null) {
                                myPage++
                                getSpecies(myPage)
                            }
                            for (i in 0..it.results.size-1){
                                species.add(it.results[i])
                            }
                            view.showSpecies(species)
                        }
                )

    }


}