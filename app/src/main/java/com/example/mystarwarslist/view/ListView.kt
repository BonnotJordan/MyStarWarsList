package com.example.mystarwarslist.view

import com.example.mystarwarslist.base.BaseView
import com.example.mystarwarslist.data.entity.Film
import com.example.mystarwarslist.data.entity.FilmsResults

interface ListView : BaseView {
    fun displayLoader()
    fun hideLoader()
    fun showFilms(filmsResults: FilmsResults)
    fun showError(throwable: Throwable)
    fun gotoFilmDetails(film: Film)
}