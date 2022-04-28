package com.example.pizzamarket.adapters

import com.example.pizzamarket.data.DataItem

interface onRecyclerClickListener {
    fun onCLick(dataItem:DataItem, position:Int)
}