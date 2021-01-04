package com.example.mystarwarslist.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mystarwarslist.R
import com.example.mystarwarslist.data.entity.Film
import com.example.mystarwarslist.data.entity.Films
import com.example.mystarwarslist.data.entity.FilmsResults
import kotlinx.android.synthetic.main.list_item.view.*

class ListAdapter(private val datas : FilmsResults, private val listener : ListAdapter.ClickOnRecycler) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    class ViewHolder(view: View, private val listener : ListAdapter.ClickOnRecycler) : RecyclerView.ViewHolder(view) {
        val context: Context = itemView.context
        val title: TextView = itemView.textViewTitle
        val subtitle : TextView = itemView.textViewSubtitle

        fun bindItems(data: Film, position: Int) {

            var result : Any? = null

            title.text = data.title
            subtitle.text = data.episode_id.toString()

            itemView.setOnClickListener {
                listener.itemClicked(position, context)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)

        return ListAdapter.ViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return datas.results.size
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        var list : List<Film> = datas.results.sortedWith(compareBy { it.episode_id })
        holder.bindItems(list[position],position)
    }

    interface ClickOnRecycler {
        fun itemClicked(position: Int, context: Context)
    }
}