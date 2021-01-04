package com.example.mystarwarslist.viewmodel

import android.content.Context
import com.example.mystarwarslist.base.BaseViewModel
import com.example.mystarwarslist.data.entity.Films
import com.example.mystarwarslist.data.network.MyStarWarsListService
import com.example.mystarwarslist.view.ListView
import com.example.mystarwarslist.view.adapters.ListAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FilmsListFragmentViewModel
@Inject constructor(private val service: MyStarWarsListService, private val context: Context) : BaseViewModel<ListView>(),
 ListAdapter.ClickOnRecycler {
    override fun itemClicked(position: Int, context: Context) {
        TODO("Not yet implemented")
    }

    fun start() {
        view.displayLoader()
        getFilms()
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


}