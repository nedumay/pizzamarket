package com.example.pizzamarket.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pizzamarket.R
import com.example.pizzamarket.adapters.RecyclerAdapter
import com.example.pizzamarket.adapters.onRecyclerClickListener
import com.example.pizzamarket.data.DataInitItem
import com.example.pizzamarket.data.DataItem
import com.example.pizzamarket.databinding.FragmentMenuBinding


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
                        Toast.makeText(context,R.string.pizza_cesar,Toast.LENGTH_SHORT).show()
                    }
                    1 ->{
                        Toast.makeText(context,R.string.pizza_cheese,Toast.LENGTH_SHORT).show()
                    }
                    2->{
                        Toast.makeText(context,R.string.pizza_classic,Toast.LENGTH_SHORT).show()
                    }
                    3->{
                        Toast.makeText(context,R.string.pizza_four_cheese,Toast.LENGTH_SHORT).show()
                    }
                    4->{
                        Toast.makeText(context,R.string.pizza_margharita,Toast.LENGTH_SHORT).show()
                    }
                    5->{
                        Toast.makeText(context,R.string.pizza_meat,Toast.LENGTH_SHORT).show()
                    }
                    6->{
                        Toast.makeText(context,R.string.pizza_neopl,Toast.LENGTH_SHORT).show()
                    }
                    7->{
                        Toast.makeText(context,R.string.pizza_penaple,Toast.LENGTH_SHORT).show()
                    }
                    8->{
                        Toast.makeText(context,R.string.pizza_pepperony,Toast.LENGTH_SHORT).show()
                    }
                    9->{
                        Toast.makeText(context,R.string.pizza_sea,Toast.LENGTH_SHORT).show()
                    }
                    10->{
                        Toast.makeText(context,R.string.pizza_assorted,Toast.LENGTH_SHORT).show()
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
                        Toast.makeText(context,R.string.pizza_neopl,Toast.LENGTH_SHORT).show()
                    }
                    1->{
                        Toast.makeText(context,R.string.pizza_penaple,Toast.LENGTH_SHORT).show()
                    }
                    2->{
                        Toast.makeText(context,R.string.pizza_pepperony,Toast.LENGTH_SHORT).show()
                    }
                    3->{
                        Toast.makeText(context,R.string.pizza_sea,Toast.LENGTH_SHORT).show()
                    }
                    4->{
                        Toast.makeText(context,R.string.pizza_assorted,Toast.LENGTH_SHORT).show()
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