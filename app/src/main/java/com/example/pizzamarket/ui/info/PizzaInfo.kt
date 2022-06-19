package com.example.pizzamarket.ui.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import com.example.pizzamarket.R

class PizzaInfo : AppCompatActivity() {

    lateinit var size:Spinner
    lateinit var addit:Spinner
    lateinit var deliv:Spinner
    lateinit var imgView: ImageView
    lateinit var namePizza: TextView
    lateinit var starText: TextView
    lateinit var priceText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_info)

        val size_menu = resources.getStringArray(R.array.menu_size)
        val addit_menu = resources.getStringArray(R.array.addit_menu)
        val deliver_menu = resources.getStringArray(R.array.menu_deliver)

        size = findViewById(R.id.menu_size)
        if(size !=null){
            val adapterSize = ArrayAdapter(this,android.R.layout.simple_list_item_1, size_menu)
            size.adapter = adapterSize
            size.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                    //Toast.makeText(this@PizzaInfo, getString(R.string.size_pizza ) + " " + size_menu[position], Toast.LENGTH_LONG).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
        addit = findViewById(R.id.menu_additive)
        if(addit !=null){
            val adapterAdd = ArrayAdapter(this, android.R.layout.simple_list_item_1, addit_menu)
            addit.adapter = adapterAdd
            addit.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                    //Toast.makeText(this@PizzaInfo, getString(R.string.dditives) + " " + addit_menu[position], Toast.LENGTH_LONG).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
        deliv = findViewById(R.id.menu_delivery)
        if(deliv!=null){
            val adapterDeliv = ArrayAdapter(this, android.R.layout.simple_list_item_1, deliver_menu)
            deliv.adapter = adapterDeliv
            deliv.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                    //Toast.makeText(this@PizzaInfo, getString(R.string.delivery_method) + " " + deliver_menu[position], Toast.LENGTH_LONG).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }

        imgView = findViewById(R.id.img_view)
        namePizza = findViewById(R.id.name_pizza)
        starText = findViewById(R.id.text_star_pizza)
        priceText = findViewById(R.id.price)

        //Получение данных из прошлой активити
        val img = intent.extras?.getInt("image")
        val name = intent.extras?.getInt("name")
        val star = intent.extras?.getString("star")
        val price = intent.extras?.getString("price")
        imgView.setImageResource(img!!)
        namePizza.setText(name!!)
        starText.setText(star)
        priceText.setText(price)

    }
}