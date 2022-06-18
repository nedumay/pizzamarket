package com.example.pizzamarket.ui.aboutapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.pizzamarket.R
import com.example.pizzamarket.adapters.aboutappadapter.RecylerAdapterAboutApp
import com.example.pizzamarket.adapters.aboutappadapter.onRecyclerClickListenerAboutApp
import com.example.pizzamarket.data.DataInitItem
import com.example.pizzamarket.data.dataaboutapp.DataItemAboutApp
import com.example.pizzamarket.databinding.FragmentAboutAppBinding

class AboutAppFragment : Fragment() {

    private val dataItem = DataInitItem()

    private var _binding: FragmentAboutAppBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataItem.setInitialAboutApp()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAboutAppBinding.inflate(inflater,container,false)
        val root: View = binding.root

        val recyclerView = object : onRecyclerClickListenerAboutApp{
            override fun onClick(dataItemAboutApp: DataItemAboutApp, position: Int) {
                when(position){
                    0 ->{Toast.makeText(context, R.string.users_agreement, Toast.LENGTH_SHORT).show()}
                    1 ->{Toast.makeText(context, R.string.license_agreement, Toast.LENGTH_SHORT).show()}
                    2 ->{Toast.makeText(context, R.string.promotion_terms, Toast.LENGTH_SHORT).show()}
                    3 ->{Toast.makeText(context, R.string.privacy_policy, Toast.LENGTH_SHORT).show()}
                    4 ->{Toast.makeText(context, R.string.payment_rules, Toast.LENGTH_SHORT).show()}
                }
            }
        }
        val adapterAboutApp = RecylerAdapterAboutApp(context = context, dataItemAboutApp = dataItem.dataItemDocument, recyclerView)
        binding.recyclerViewDoc.adapter = adapterAboutApp

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}