package com.example.pizzamarket.ui.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import com.example.pizzamarket.R

class PizzaInfo : AppCompatActivity() {

    lateinit var size:TextView
    lateinit var addit:TextView
    lateinit var deliv:TextView
    lateinit var imgView: ImageView
    lateinit var namePizza: TextView
    lateinit var starText: TextView
    lateinit var priceText: TextView

    //size
    val size_32 = 1
    val size_48 = 2
    val size_55 = 3
    //additive
    val no_add = 4
    val cheese = 5
    val sauce  = 6
    //delivery
    val courier = 7
    val pickup  = 8

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_info)

        size = findViewById(R.id.menu_size)
        addit = findViewById(R.id.menu_additive)
        deliv = findViewById(R.id.menu_delivery)
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
        //Контекстное меню
        registerForContextMenu(size)
        registerForContextMenu(addit)
        registerForContextMenu(deliv)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        when (v?.id) {
            R.id.menu_size -> {
                menu?.add(0, size_32, 0, R.string.size_32)
                menu?.add(0, size_48, 0, R.string.size_48)
                menu?.add(0, size_55, 0, R.string.size_55)
            }
            R.id.menu_additive -> {
                menu?.add(0, no_add, 0, R.string.no)
                menu?.add(0, cheese, 0, R.string.cheese)
                menu?.add(0, sauce, 0, R.string.sauce)
            }
            R.id.menu_delivery -> {
                menu?.add(0, courier, 0, R.string.courier)
                menu?.add(0, pickup, 0, R.string.pickup)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            //Пункты меню для размера
            size_32 ->{
                size.setText(R.string.size_32)
            }
            size_48 ->{
                size.setText(R.string.size_48)
            }
            size_55 ->{
                size.setText(R.string.size_55)
            }
            //Пункты меню для добавок
            no_add -> {
                addit.setText(R.string.no)
            }
            cheese -> {
                addit.setText(R.string.cheese)
            }
            sauce -> {
                addit.setText(R.string.sauce)
            }
            //Пункты меню для доставки
            courier -> {
                deliv.setText(R.string.courier)
            }
            pickup -> {
                deliv.setText(R.string.pickup)
            }
        }
        return super.onContextItemSelected(item)
    }
}