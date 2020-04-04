package com.rohman.koinexample.feature.contact

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rohman.koinexample.R
import com.rohman.koinexample.model.ContactModel

class ContactAdapter(private val context: Context,private val callback: AdapterCallback) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    private var list = emptyList<ContactModel>()
    fun setData(data: List<ContactModel>) {
        list = data
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textName = view.findViewById(R.id.tvName) as TextView
        val textDescription = view.findViewById(R.id.tvDescription) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(list[position]) {
            holder.textName.text = name
            holder.textDescription.text = description
            holder.itemView.setOnClickListener { callback.onItemClicked(this) }
        }
    }

}