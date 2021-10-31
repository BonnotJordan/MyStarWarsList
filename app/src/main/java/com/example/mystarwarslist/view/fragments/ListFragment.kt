package com.example.mystarwarslist.view.fragments

import android.content.Context
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
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
import androidx.appcompat.widget.SearchView.*

class ListFragment : BaseFragment<ListFragmentViewModel>(), ListView, SearchView.OnQueryTextListener {

    override val layoutId: Int = R.layout.fragment_list

    lateinit var arrayData : ArrayList<Any>

    @Inject
    override lateinit var viewModel: ListFragmentViewModel

    var categorieId : Int = -1

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        searchView.setOnQueryTextListener(this)
        viewModel.attach(this)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,
                false)
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context,
                RecyclerView.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
        viewModel.start(categorieId)
    }

    override fun displayLoader() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun showFilms(filmsList: ArrayList<Film>) {
        val adapter = FilmListAdapter(filmsList, viewModel)
        recyclerView.adapter = adapter
        arrayData = filmsList as ArrayList<Any>
    }

    override fun showPeople(peopleList: ArrayList<People>) {
        val adapter = PeopleListAdapter(peopleList, viewModel)
        recyclerView.adapter = adapter
        arrayData = peopleList as ArrayList<Any>
    }

    override fun showPlanets(planetsList: ArrayList<Planet>) {
        val adapter = PlanetListAdapter(planetsList, viewModel)
        recyclerView.adapter = adapter
        arrayData = planetsList as ArrayList<Any>
    }

    override fun showSpecies(speciesList: ArrayList<Specie>) {
        val adapter = SpecieListAdapter(speciesList, viewModel)
        recyclerView.adapter = adapter
        arrayData = speciesList as ArrayList<Any>
    }

    override fun showStarships(starshipsList: ArrayList<Starship>) {
        val adapter = StarshipListAdapter(starshipsList, viewModel)
        recyclerView.adapter = adapter
        arrayData = starshipsList as ArrayList<Any>
    }

    override fun showVehicles(vehiclesList: ArrayList<Vehicle>) {
        val adapter = VehicleListAdapter(vehiclesList, viewModel)
        recyclerView.adapter = adapter
        arrayData = vehiclesList as ArrayList<Any>
    }

    override fun showError(throwable: Throwable) {
        Log.d("test","error",throwable)
        Toast.makeText(context,throwable.localizedMessage, Toast.LENGTH_LONG).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        when {
            arrayData.first() is People -> {
                var filteredDatas = ArrayList<People>()
                if (newText!!.trim() != ""){
                    for (data in arrayData as ArrayList<People>){
                        if(data.name.toLowerCase().contains(newText!!.toLowerCase())){
                            filteredDatas.add(data)
                        }
                    }
                } else {
                    filteredDatas = arrayData as ArrayList<People>
                }
                val adapter = PeopleListAdapter(filteredDatas, viewModel)
                recyclerView.adapter = adapter
            }
            arrayData.first() is Planet -> {
                var filteredDatas = ArrayList<Planet>()
                for (data in arrayData as ArrayList<Planet>){
                    if(data.name.toLowerCase().contains(newText!!.toLowerCase())){
                        filteredDatas.add(data)
                    }
                }
                val adapter = PlanetListAdapter(filteredDatas, viewModel)
                recyclerView.adapter = adapter
            }
            arrayData.first()is Film -> {
                var filteredDatas = ArrayList<Film>()
                for (data in arrayData as ArrayList<Film>){
                    if(data.title.toLowerCase().contains(newText!!.toLowerCase())){
                        filteredDatas.add(data)
                    }
                }
                val adapter = FilmListAdapter(filteredDatas, viewModel)
                recyclerView.adapter = adapter
            }
            arrayData.first()is Specie -> {
                var filteredDatas = ArrayList<Specie>()
                for (data in arrayData as ArrayList<Specie>){
                    if(data.name.toLowerCase().contains(newText!!.toLowerCase())){
                        filteredDatas.add(data)
                    }
                }
                val adapter = SpecieListAdapter(filteredDatas, viewModel)
                recyclerView.adapter = adapter
            }
            arrayData.first()is Vehicle -> {
                var filteredDatas = ArrayList<Vehicle>()
                for (data in arrayData as ArrayList<Vehicle>){
                    if(data.name.toLowerCase().contains(newText!!.toLowerCase())){
                        filteredDatas.add(data)
                    }
                }
                val adapter = VehicleListAdapter(filteredDatas, viewModel)
                recyclerView.adapter = adapter
            }
            arrayData.first()is Starship -> {
                var filteredDatas = ArrayList<Starship>()
                for (data in arrayData as ArrayList<Starship>){
                    if(data.name.toLowerCase().contains(newText!!.toLowerCase())){
                        filteredDatas.add(data)
                    }
                }
                val adapter = StarshipListAdapter(filteredDatas, viewModel)
                recyclerView.adapter = adapter
            }
        }

        return false
    }


}