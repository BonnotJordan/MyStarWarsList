package com.example.mystarwarslist.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mystarwarslist.R
import kotlinx.android.synthetic.main.category_item.view.*
import org.json.JSONObject
import java.net.URL

class CategoriesListAdapter(private val categories : ArrayList<String>, private val listener : ClickOnRecycler ) : RecyclerView.Adapter<CategoriesListAdapter.ViewHolder>(){

    class ViewHolder(view: View, private val listener : ClickOnRecycler) : RecyclerView.ViewHolder(view) {
        val context: Context = itemView.context
        val name: TextView = itemView.categorieName

        fun bindItems(data: String, position: Int) {

            name.text = data

            itemView.setOnClickListener {
                listener.itemClicked(position, context)
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.category_item, viewGroup, false)

        return ViewHolder(view, listener)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.bindItems(categories[position],position)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() =  categories.size

    interface ClickOnRecycler {
        fun itemClicked(position: Int, context: Context)
    }
}