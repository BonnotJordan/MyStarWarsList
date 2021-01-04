package com.example.mystarwarslist.view.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mystarwarslist.R
import com.example.mystarwarslist.base.BaseFragment
import com.example.mystarwarslist.view.CategoriesListView
import com.example.mystarwarslist.view.adapters.CategoriesListAdapter
import com.example.mystarwarslist.viewmodel.CategoriesListViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_categories_list.*
import javax.inject.Inject

class CategoriesListFragment : BaseFragment<CategoriesListViewModel>(), CategoriesListView {
    override val layoutId: Int = R.layout.fragment_categories_list

    @Inject
    override lateinit var viewModel: CategoriesListViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.attach(this)
        recyclerViewCategories.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val dividerItemDecoration = DividerItemDecoration(recyclerViewCategories.context,
                RecyclerView.VERTICAL)
        recyclerViewCategories.addItemDecoration(dividerItemDecoration)
        viewModel.start()
    }

    override fun displayLoader() {
        //progressBar.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        //progressBar.visibility = View.INVISIBLE
    }

    override fun showCategories(categoriesList: ArrayList<String>) {
        val adapter = CategoriesListAdapter(categoriesList, viewModel)
        recyclerViewCategories.adapter = adapter
    }

    override fun showError(throwable: Throwable) {
        Log.d("test","error",throwable)
        Toast.makeText(context,throwable.localizedMessage, Toast.LENGTH_LONG).show()
    }

    override fun gotoList(position: Int) {
        lateinit var fragment : Fragment
        when(position){
            0 -> fragment = FilmsListFragment()
            1 -> fragment = FilmsListFragment()
            2 -> fragment = FilmsListFragment()
            3 -> fragment = FilmsListFragment()
            4 -> fragment = FilmsListFragment()
            5 -> fragment = FilmsListFragment()
        }

        activity!!.supportFragmentManager
                .beginTransaction()
                .replace(R.id.activityContainer, fragment)
                .commit()
    }
}