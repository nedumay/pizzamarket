package com.example.pizzamarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pizzamarket.databinding.ActivityMainBinding
import com.example.pizzamarket.ui.Registration

class MainActivity : AppCompatActivity() {

    lateinit var bindingStart: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        bindingStart = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingStart.root)

        bindingStart.loginBtn.setOnClickListener {

        }

        bindingStart.guestBtn.setOnClickListener {
            val regIntent = Intent(this@MainActivity, Registration::class.java)
            startActivity(regIntent)
        }

    }
}