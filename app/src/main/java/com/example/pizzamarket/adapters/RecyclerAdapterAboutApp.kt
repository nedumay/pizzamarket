package com.example.pizzamarket.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzamarket.R
import com.example.pizzamarket.data.DataItemAboutApp

class RecyclerAdapterAboutApp internal constructor(context: Context?, dataItemAboutApp: List<DataItemAboutApp>, private val onClickListener:onRecyclerClickListenerAboutApp):
    RecyclerView.Adapter<RecyclerAdapterAboutApp.ViewHolder>(){

    private val inflater: LayoutInflater
    private val dataItemAboutApp: List<DataItemAboutApp>
    init {
        this.dataItemAboutApp = dataItemAboutApp
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = inflater.inflate(R.layout.list_item_about_app,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person: DataItemAboutApp = dataItemAboutApp[position]
        holder.nameView.setText(person.name)

        holder.itemView.setOnClickListener {
            onClickListener.onClick(person,position)
        }
    }


    override fun getItemCount(): Int {
        return dataItemAboutApp.size
    }

    class ViewHolder internal constructor(view:View):RecyclerView.ViewHolder(view) {
        val nameView: TextView
        init {
            nameView = view.findViewById(R.id.text_item_doc)
        }
    }

}