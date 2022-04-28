package com.example.pizzamarket.data

import com.example.pizzamarket.R

class DataInitItem {

    internal val dataItemPopPizza: ArrayList<DataItem> = ArrayList()
    internal val dataItemWeekPizza: ArrayList<DataItem> = ArrayList()

    fun setInitialSavedStatePopPizza(){
        dataItemPopPizza.add(DataItem(R.string.pizza_cesar,R.drawable.cesar,"4/5"))
        dataItemPopPizza.add(DataItem(R.string.pizza_cheese,R.drawable.cheezz,"3.6/5"))
        dataItemPopPizza.add(DataItem(R.string.pizza_classic,R.drawable.classic,"4.5/5"))
        dataItemPopPizza.add(DataItem(R.string.pizza_four_cheese,R.drawable.fourcheez,"3.5/5"))
        dataItemPopPizza.add(DataItem(R.string.pizza_margharita,R.drawable.margarita,"3.9/5"))
        dataItemPopPizza.add(DataItem(R.string.pizza_meat,R.drawable.meat,"4.9/5"))
        dataItemPopPizza.add(DataItem(R.string.pizza_neopl,R.drawable.neapolitan,"3.2/5"))
        dataItemPopPizza.add(DataItem(R.string.pizza_penaple,R.drawable.penapple,"5/5"))
        dataItemPopPizza.add(DataItem(R.string.pizza_pepperony,R.drawable.pepperony,"4.2/5"))
        dataItemPopPizza.add(DataItem(R.string.pizza_sea,R.drawable.sea,"3.2/5"))
        dataItemPopPizza.add(DataItem(R.string.pizza_assorted,R.drawable.season,"4.5/5"))
    }

    fun setInitialSavedStateWeekPizza(){
        dataItemWeekPizza.add(DataItem(R.string.pizza_neopl,R.drawable.neapolitan,"3.2/5"))
        dataItemWeekPizza.add(DataItem(R.string.pizza_penaple,R.drawable.penapple,"5/5"))
        dataItemWeekPizza.add(DataItem(R.string.pizza_pepperony,R.drawable.pepperony,"4.2/5"))
        dataItemWeekPizza.add(DataItem(R.string.pizza_sea,R.drawable.sea,"3.2/5"))
        dataItemWeekPizza.add(DataItem(R.string.pizza_assorted,R.drawable.season,"4.5/5"))
    }

}