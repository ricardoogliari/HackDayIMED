package com.estudos.hackdayimed.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.estudos.hackdayimed.DetailActivity
import com.estudos.hackdayimed.R
import com.estudos.hackdayimed.model.Book

class CustomAdapter(private val dataSet: List<Book>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.list_item_name)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_simple, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position].titulo
        viewHolder.view.setOnClickListener {
            val intent = Intent(
                viewHolder.view.context,
                DetailActivity::class.java
            )
            intent.putExtra(DetailActivity.BOOK_KEY, dataSet[position])
            viewHolder.view.context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataSet.size
}