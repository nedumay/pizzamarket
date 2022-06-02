package com.example.pizzamarket.ui.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pizzamarket.databinding.ActivityRegistrationBinding
import com.example.pizzamarket.domain.RegistrationUserEmail

class Registration : AppCompatActivity() {

    private lateinit var bindingRegistration: ActivityRegistrationBinding
    private val registrationUserEmail = RegistrationUserEmail()

    override fun onCreate(savedInstanceState: Bundle?) {
        bindingRegistration = ActivityRegistrationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingRegistration.root)

        bindingRegistration.regBtn.setOnClickListener {
            val email = bindingRegistration.regInputLogin.text.toString()
            val password = bindingRegistration.regInputPassword.text.toString()
            registrationUserEmail.registrUser(email,password,this@Registration)
        }
    }
}