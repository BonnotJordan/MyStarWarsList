package com.example.mystarwarslist.data.network

import com.example.mystarwarslist.data.entity.*
import io.reactivex.Single
import retrofit2.http.GET

interface MyStarWarsListService {

    @GET(".")
    fun getCategories():
            Single<Any>

    @GET("films/")
    fun getFilms():
            Single<FilmsResults>

    @GET("people/")
    fun getPeople():
            Single<People>

    @GET("planets/")
    fun getPlanets():
            Single<Planet>

    @GET("species/")
    fun getSpecies():
            Single<Species>

    @GET("starships/")
    fun getStarships():
            Single<Starships>

    @GET("vehicles/")
    fun getVehicles():
            Single<Vehicles>

}