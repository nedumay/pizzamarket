package com.example.pizzamarket.adapters

import com.example.pizzamarket.data.DataItem

interface onRecyclerClickListener {
    fun onClick(dataItem:DataItem, position:Int)
}