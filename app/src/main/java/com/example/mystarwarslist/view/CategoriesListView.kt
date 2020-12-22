package com.example.mystarwarslist.view

import com.example.mystarwarslist.base.BaseView
import org.json.JSONObject

interface CategoriesListView : BaseView {

    fun displayLoader()
    fun hideLoader()
    fun showCategories(categoriesList: ArrayList<String>)
    fun showError(throwable: Throwable)
    fun gotoList(position: Int)

}