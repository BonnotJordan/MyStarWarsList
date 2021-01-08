package com.example.mystarwarslist.data.network

import com.example.mystarwarslist.data.entity.*
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MyStarWarsListService {

    @GET(".")
    fun getCategories():
            Single<Any>

    @GET("films/")
    fun getFilms():
            Single<FilmsResults>

    @GET("people/")
    fun getPeople(@Query("page") page : Int):
            Single<PeopleResult>

    @GET("planets/")
    fun getPlanets(@Query("page") page : Int):
            Single<PlanetsResult>

    @GET("species/")
    fun getSpecies(@Query("page") page : Int):
            Single<SpeciesResult>

    @GET("starships/")
    fun getStarships(@Query("page") page : Int):
            Single<StarshipsResult>

    @GET("vehicles/")
    fun getVehicles(@Query("page") page : Int):
            Single<VehiclesResult>

}