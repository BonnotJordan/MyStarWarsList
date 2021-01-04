package com.example.mystarwarslist.view.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mystarwarslist.base.BaseFragment
import com.example.mystarwarslist.R
import com.example.mystarwarslist.data.entity.Film
import com.example.mystarwarslist.data.entity.FilmsResults
import com.example.mystarwarslist.viewmodel.FilmsListFragmentViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject
import com.example.mystarwarslist.view.ListView
import com.example.mystarwarslist.view.adapters.ListAdapter

class FilmsListFragment : BaseFragment<FilmsListFragmentViewModel>(), ListView {

    override val layoutId: Int = R.layout.fragment_list

    @Inject
    override lateinit var viewModel: FilmsListFragmentViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.attach(this)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,
                false)
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context,
                RecyclerView.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
        viewModel.start()
    }

    override fun displayLoader() {
        //progressBar.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        //progressBar.visibility = View.INVISIBLE
    }

    override fun showFilms(filmsResults: FilmsResults) {
        val adapter = ListAdapter(filmsResults, viewModel)
        recyclerView.adapter = adapter
    }

    override fun showError(throwable: Throwable) {
        Log.d("test","error",throwable)
        Toast.makeText(context,throwable.localizedMessage, Toast.LENGTH_LONG).show()
    }

    override fun gotoFilmDetails(film: Film) {
        TODO("Not yet implemented")
    }


}