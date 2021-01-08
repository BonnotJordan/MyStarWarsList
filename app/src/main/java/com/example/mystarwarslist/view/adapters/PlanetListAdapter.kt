package com.example.mystarwarslist.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mystarwarslist.R
import com.example.mystarwarslist.data.entity.*
import kotlinx.android.synthetic.main.list_item.view.*

class PlanetListAdapter(private val datas : ArrayList<Planet>, private val listener : PlanetListAdapter.ClickOnRecycler) : RecyclerView.Adapter<PlanetListAdapter.ViewHolder>() {

    class ViewHolder(view: View, private val listener : PlanetListAdapter.ClickOnRecycler) : RecyclerView.ViewHolder(view) {
        val context: Context = itemView.context
        val title: TextView = itemView.textViewTitle
        val subtitle : TextView = itemView.textViewSubtitle

        fun bindItems(data: Planet, position: Int) {

            var result : Any? = null

            title.text = data.name
            subtitle.text = data.climate

            itemView.setOnClickListener {
                listener.itemClicked(position, context)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetListAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return PlanetListAdapter.ViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: PlanetListAdapter.ViewHolder, position: Int) {
        holder.bindItems(datas[position],position)
    }

    interface ClickOnRecycler {
        fun itemClicked(position: Int, context: Context)
    }
}