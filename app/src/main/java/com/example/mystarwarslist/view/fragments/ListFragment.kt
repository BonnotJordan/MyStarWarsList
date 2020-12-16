package com.example.mystarwarslist.view.fragments

import android.content.Context
import android.os.Bundle
import com.example.mystarwarslist.base.BaseFragment
import com.example.mystarwarslist.R
import com.example.mystarwarslist.base.BaseView
import com.example.mystarwarslist.viewmodel.ListFragmentViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ListFragment : BaseFragment<ListFragmentViewModel>(), BaseView {

    override val layoutId: Int = R.layout.fragment_list

    @Inject
    override lateinit var viewModel: ListFragmentViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel.attach(this)
        super.onCreate(savedInstanceState)
    }


}