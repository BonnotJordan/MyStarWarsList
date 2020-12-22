package com.example.mystarwarslist.viewmodel

import android.content.Context
import android.util.Log
import com.example.mystarwarslist.base.BaseViewModel
import com.example.mystarwarslist.common.Constants
import com.example.mystarwarslist.data.network.MyStarWarsListService
import com.example.mystarwarslist.view.CategoriesListView
import com.example.mystarwarslist.view.adapters.CategoriesListAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class CategoriesListViewModel
@Inject constructor(private val service: MyStarWarsListService, private val context: Context) : BaseViewModel<CategoriesListView>(),
    CategoriesListAdapter.ClickOnRecycler {

    override fun itemClicked(position: Int, context: Context) {
        view.gotoList(position)
    }

    fun start() {
        view.displayLoader()
        getCategories()
    }

    fun getCategories(){
/*        service.getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onError = {
                            /*view.hideLoader()
                            view.showError(it)*/
                            view.showError(it)
                        },
                        onSuccess = {
                            /*view.hideLoader()*/
                            var array : ArrayList<String> = ArrayList()
                            val keys: Enumeration<String> = it.keys()

                            while (keys.hasMoreElements()) {
                                val key = keys.nextElement()
                                array.add(it.get(key).toString())
                            }

                            view.showCategories(array)
                        }
                )*/

        view.showCategories(Constants.categories)
    }
}