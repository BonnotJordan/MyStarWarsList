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

class StarshipListAdapter(private val datas : ArrayList<Starship>, private val listener : StarshipListAdapter.ClickOnRecycler) : RecyclerView.Adapter<StarshipListAdapter.ViewHolder>() {

    class ViewHolder(view: View, private val listener : StarshipListAdapter.ClickOnRecycler) : RecyclerView.ViewHolder(view) {
        val context: Context = itemView.context
        val title: TextView = itemView.textViewTitle
        val subtitle : TextView = itemView.textViewSubtitle

        fun bindItems(data: Starship, position: Int) {

            var result : Any? = null

            title.text = data.name
            subtitle.text = data.crew

            itemView.setOnClickListener {
                listener.itemClicked(position, context)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarshipListAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return StarshipListAdapter.ViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: StarshipListAdapter.ViewHolder, position: Int) {
        holder.bindItems(datas[position],position)
    }

    interface ClickOnRecycler {
        fun itemClicked(position: Int, context: Context)
    }
}