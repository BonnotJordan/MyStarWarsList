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
import com.example.mystarwarslist.data.entity.*
import com.example.mystarwarslist.viewmodel.ListFragmentViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject
import com.example.mystarwarslist.view.ListView
import com.example.mystarwarslist.view.adapters.*

class ListFragment : BaseFragment<ListFragmentViewModel>(), ListView {

    override val layoutId: Int = R.layout.fragment_list

    @Inject
    override lateinit var viewModel: ListFragmentViewModel

    var categorieId : Int = -1

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
        viewModel.start(categorieId)
    }

    override fun displayLoader() {
        //progressBar.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        //progressBar.visibility = View.INVISIBLE
    }

    override fun showFilms(filmsResults: FilmsResults) {
        val adapter = FilmListAdapter(filmsResults, viewModel)
        recyclerView.adapter = adapter
    }

    override fun showPeople(peopleList: ArrayList<People>) {
        val adapter = PeopleListAdapter(peopleList, viewModel)
        recyclerView.adapter = adapter
    }

    override fun showPlanets(planetsList: ArrayList<Planet>) {
        val adapter = PlanetListAdapter(planetsList, viewModel)
        recyclerView.adapter = adapter
    }

    override fun showSpecies(speciesList: ArrayList<Specie>) {
        val adapter = SpecieListAdapter(speciesList, viewModel)
        recyclerView.adapter = adapter
    }

    override fun showStarships(starshipsList: ArrayList<Starship>) {
        val adapter = StarshipListAdapter(starshipsList, viewModel)
        recyclerView.adapter = adapter
    }

    override fun showVehicles(vehiclesList: ArrayList<Vehicle>) {
        val adapter = VehicleListAdapter(vehiclesList, viewModel)
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