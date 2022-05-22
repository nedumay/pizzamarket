package com.example.pizzamarket.ui.menu

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.pizzamarket.PizzaInfo
import com.example.pizzamarket.R
import com.example.pizzamarket.adapters.RecyclerAdapter
import com.example.pizzamarket.adapters.onRecyclerClickListener
import com.example.pizzamarket.data.DataInitItem
import com.example.pizzamarket.data.DataItem
import com.example.pizzamarket.databinding.FragmentMenuBinding
import com.example.pizzamarket.ui.Registration


class MenuFragment : Fragment() {

    private val dataItem = DataInitItem()

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataItem.setInitialSavedStatePopPizza()
        dataItem.setInitialSavedStateWeekPizza()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recClickListenerPop = object: onRecyclerClickListener {
            override fun onCLick(dataItem: DataItem, position: Int) {
                when(position){
                    0 -> {
                        val cesarIntent = Intent(context, PizzaInfo::class.java)
                        cesarIntent.putExtra("image",R.drawable.cesar)
                        cesarIntent.putExtra("name", R.string.pizza_cesar)
                        cesarIntent.putExtra("star", "4/5")
                        cesarIntent.putExtra("price", "2.5$")
                        startActivity(cesarIntent)
                    }
                    1 ->{
                        val cheeseIntent = Intent(context, PizzaInfo::class.java)
                        cheeseIntent.putExtra("image",R.drawable.cheezz)
                        cheeseIntent.putExtra("name", R.string.pizza_cheese)
                        cheeseIntent.putExtra("star", "3.6/5")
                        cheeseIntent.putExtra("price", "1.5$")
                        startActivity(cheeseIntent)
                    }
                    2->{
                        val classicIntent = Intent(context,PizzaInfo::class.java)
                        classicIntent.putExtra("image",R.drawable.classic)
                        classicIntent.putExtra("name", R.string.pizza_classic)
                        classicIntent.putExtra("star", "4.5/5")
                        classicIntent.putExtra("price", "1.36$")
                        startActivity(classicIntent)
                    }
                    3->{
                        val fourcheeseIntent = Intent(context,PizzaInfo::class.java)
                        fourcheeseIntent.putExtra("image",R.drawable.fourcheez)
                        fourcheeseIntent.putExtra("name", R.string.pizza_four_cheese)
                        fourcheeseIntent.putExtra("star", "3.5/5")
                        fourcheeseIntent.putExtra("price", "2$")
                        startActivity(fourcheeseIntent)
                    }
                    4->{
                        val marghIntent = Intent(context,PizzaInfo::class.java)
                        marghIntent.putExtra("image",R.drawable.margarita)
                        marghIntent.putExtra("name", R.string.pizza_margharita)
                        marghIntent.putExtra("star", "3.9/5")
                        marghIntent.putExtra("price", "3.16$")
                        startActivity(marghIntent)
                    }
                    5->{
                        val meatIntent = Intent(context,PizzaInfo::class.java)
                        meatIntent.putExtra("image",R.drawable.meat)
                        meatIntent.putExtra("name", R.string.pizza_meat)
                        meatIntent.putExtra("star", "4.9/5")
                        meatIntent.putExtra("price", "1.23$")
                        startActivity(meatIntent)
                    }
                    6->{
                        val neoplIntent = Intent(context,PizzaInfo::class.java)
                        neoplIntent.putExtra("image",R.drawable.neapolitan)
                        neoplIntent.putExtra("name", R.string.pizza_neopl)
                        neoplIntent.putExtra("star", "3.2/5")
                        neoplIntent.putExtra("price", "2$")
                        startActivity(neoplIntent)
                    }
                    7->{
                        val penapleIntent = Intent(context,PizzaInfo::class.java)
                        penapleIntent.putExtra("image",R.drawable.penapple)
                        penapleIntent.putExtra("name", R.string.pizza_penaple)
                        penapleIntent.putExtra("star", "5/5")
                        penapleIntent.putExtra("price", "1.1$")
                        startActivity(penapleIntent)
                    }
                    8->{
                        val peperIntent = Intent(context,PizzaInfo::class.java)
                        peperIntent.putExtra("image",R.drawable.pepperony)
                        peperIntent.putExtra("name", R.string.pizza_pepperony)
                        peperIntent.putExtra("star", "4.2/5")
                        peperIntent.putExtra("price", "1.5$")
                        startActivity(peperIntent)
                    }
                    9->{
                        val seaIntent = Intent(context,PizzaInfo::class.java)
                        seaIntent.putExtra("image",R.drawable.sea)
                        seaIntent.putExtra("name", R.string.pizza_sea)
                        seaIntent.putExtra("star", "3.2/5")
                        seaIntent.putExtra("price", "3$")
                        startActivity(seaIntent)
                    }
                    10->{
                        val assortedIntent = Intent(context,PizzaInfo::class.java)
                        assortedIntent.putExtra("image",R.drawable.season)
                        assortedIntent.putExtra("name", R.string.pizza_assorted)
                        assortedIntent.putExtra("star", "4.5/5")
                        assortedIntent.putExtra("price", "2.33$")
                        startActivity(assortedIntent)
                    }
                }
            }
        }
        val adapterPop = RecyclerAdapter(context, dataItem.dataItemPopPizza, recClickListenerPop)
        binding.recyclerView.adapter = adapterPop

        val recClickListenerWeek = object: onRecyclerClickListener {
            override fun onCLick(dataItem: DataItem, position: Int) {
                when(position){
                    0->{
                        val neoplIntent = Intent(context,PizzaInfo::class.java)
                        neoplIntent.putExtra("image",R.drawable.neapolitan)
                        neoplIntent.putExtra("name", R.string.pizza_neopl)
                        neoplIntent.putExtra("star", "3.2/5")
                        neoplIntent.putExtra("price", "2$")
                        startActivity(neoplIntent)
                    }
                    1->{
                        val penapleIntent = Intent(context,PizzaInfo::class.java)
                        penapleIntent.putExtra("image",R.drawable.penapple)
                        penapleIntent.putExtra("name", R.string.pizza_penaple)
                        penapleIntent.putExtra("star", "5/5")
                        penapleIntent.putExtra("price", "1.1$")
                        startActivity(penapleIntent)
                    }
                    2->{
                        val peperIntent = Intent(context,PizzaInfo::class.java)
                        peperIntent.putExtra("image",R.drawable.pepperony)
                        peperIntent.putExtra("name", R.string.pizza_pepperony)
                        peperIntent.putExtra("star", "4.2/5")
                        peperIntent.putExtra("price", "1.5$")
                        startActivity(peperIntent)
                    }
                    3->{
                        val seaIntent = Intent(context,PizzaInfo::class.java)
                        seaIntent.putExtra("image",R.drawable.sea)
                        seaIntent.putExtra("name", R.string.pizza_sea)
                        seaIntent.putExtra("star", "3.2/5")
                        seaIntent.putExtra("price", "3$")
                        startActivity(seaIntent)
                    }
                    4->{
                        val assortedIntent = Intent(context,PizzaInfo::class.java)
                        assortedIntent.putExtra("image",R.drawable.season)
                        assortedIntent.putExtra("name", R.string.pizza_assorted)
                        assortedIntent.putExtra("star", "4.5/5")
                        assortedIntent.putExtra("price", "2.33$")
                        startActivity(assortedIntent)
                    }
                }
            }
        }
        val adapterWeek = RecyclerAdapter(context, dataItem.dataItemWeekPizza, recClickListenerWeek)
        binding.recyclerView2.adapter = adapterWeek

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}