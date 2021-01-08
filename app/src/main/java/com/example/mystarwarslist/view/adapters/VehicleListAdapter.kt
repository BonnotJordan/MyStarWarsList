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

class VehicleListAdapter(private val datas : ArrayList<Vehicle>, private val listener : VehicleListAdapter.ClickOnRecycler) : RecyclerView.Adapter<VehicleListAdapter.ViewHolder>() {

    class ViewHolder(view: View, private val listener : VehicleListAdapter.ClickOnRecycler) : RecyclerView.ViewHolder(view) {
        val context: Context = itemView.context
        val title: TextView = itemView.textViewTitle
        val subtitle : TextView = itemView.textViewSubtitle

        fun bindItems(data: Vehicle, position: Int) {

            var result : Any? = null

            title.text = data.name
            subtitle.text = data.crew

            itemView.setOnClickListener {
                listener.itemClicked(position, context)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleListAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return VehicleListAdapter.ViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: VehicleListAdapter.ViewHolder, position: Int) {
        holder.bindItems(datas[position],position)
    }

    interface ClickOnRecycler {
        fun itemClicked(position: Int, context: Context)
    }
}