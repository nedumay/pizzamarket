package com.example.pizzamarket.ui.aboutapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.pizzamarket.R
import com.example.pizzamarket.adapters.RecyclerAdapter
import com.example.pizzamarket.adapters.RecyclerAdapterAboutApp
import com.example.pizzamarket.adapters.onRecyclerClickListener
import com.example.pizzamarket.adapters.onRecyclerClickListenerAboutApp
import com.example.pizzamarket.data.DataInitItem
import com.example.pizzamarket.data.DataItem
import com.example.pizzamarket.data.DataItemAboutApp
import com.example.pizzamarket.databinding.FragmentAboutAppBinding
import com.example.pizzamarket.ui.info.PizzaInfo

class AboutAppFragment : Fragment() {

    private val dataInitItem = DataInitItem()

    private var _binding: FragmentAboutAppBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataInitItem.setInitialSavedAboutApp()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAboutAppBinding.inflate(inflater,container,false)
        val root: View = binding.root

        val recClickListenerAboutApp = object : onRecyclerClickListenerAboutApp {
            override fun onClick(dataItemAboutApp: DataItemAboutApp, position: Int) {
                when(position){
                    0 ->{Toast.makeText(context, R.string.users_agreement, Toast.LENGTH_LONG).show()}
                    1 ->{Toast.makeText(context, R.string.license_agreement, Toast.LENGTH_LONG).show()}
                    2 ->{Toast.makeText(context, R.string.promotion_terms, Toast.LENGTH_LONG).show()}
                    3 ->{Toast.makeText(context, R.string.privacy_policy, Toast.LENGTH_LONG).show()}
                    4 ->{Toast.makeText(context, R.string.payment_rules, Toast.LENGTH_LONG).show()}
                }
            }
        }
        val adapterAboutApp = RecyclerAdapterAboutApp(context,dataInitItem.dataItemAboutApp,recClickListenerAboutApp)
        binding.recyclerDoc.adapter = adapterAboutApp

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}