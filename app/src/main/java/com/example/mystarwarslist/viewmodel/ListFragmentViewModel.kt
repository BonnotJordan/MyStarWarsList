package com.example.mystarwarslist.viewmodel

import android.content.Context
import com.example.mystarwarslist.base.BaseViewModel
import com.example.mystarwarslist.data.network.MyStarWarsListService
import com.example.mystarwarslist.view.ListView
import javax.inject.Inject

class ListFragmentViewModel
@Inject constructor(private val service: MyStarWarsListService, private val context: Context) : BaseViewModel<ListView>() {


}