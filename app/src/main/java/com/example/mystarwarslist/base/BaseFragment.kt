package com.example.mystarwarslist.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment<out vM : BaseViewModel<BaseView>> : Fragment(), BaseView {
    @get:LayoutRes
    protected abstract val layoutId: Int

    protected abstract val viewModel: vM


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.attach(this)
    }

    override fun onDestroyView() {
        viewModel.detach()
        super.onDestroyView()
    }


}