package com.example.pizzamarket.adapters.aboutappadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzamarket.R
import com.example.pizzamarket.data.dataaboutapp.DataItemAboutApp

class RecylerAdapterAboutApp internal constructor(context: Context?, dataItemAboutApp: List<DataItemAboutApp>, private val onClickListener: onRecyclerClickListenerAboutApp):
    RecyclerView.Adapter<RecylerAdapterAboutApp.ViewHolder>(){

    private val inflater:LayoutInflater
    private var dataItemAboutApp: List<DataItemAboutApp>

    init {
        this.dataItemAboutApp = dataItemAboutApp
        inflater = LayoutInflater.from(context)
    }

    class ViewHolder internal constructor(view: View):RecyclerView.ViewHolder(view){
        val titleView: TextView
        val layout: ConstraintLayout
        init {
            titleView = view.findViewById(R.id.text_item_doc)
            layout = view.findViewById(R.layout.list_item_about_app)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = inflater.inflate(R.layout.list_item_about_app, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person: DataItemAboutApp = dataItemAboutApp[position]
        holder.titleView.setText(person.titleId)

        holder.layout.setOnClickListener {
            onClickListener.onClick(person,position)
        }
    }

    override fun getItemCount() = dataItemAboutApp.size
}