package com.example.pizzamarket.ui.main

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.example.data.repository.UserRepositoryImpl
import com.example.data.storage.SharedPrefUserStorage
import com.example.domain.models.SaveUserEmailParam
import com.example.domain.usecase.GetEmail
import com.example.domain.usecase.SaveEmail
import com.example.pizzamarket.R
import com.example.pizzamarket.domain.LoginUserEmail
import com.example.pizzamarket.ui.registration.Registration

class MainActivity : AppCompatActivity() {


    private val loginUserEmail = LoginUserEmail()
    // Это нужно обязательно додумать и изменить
    private lateinit var loginPreferences: SharedPreferences
    private lateinit var loginPrefsEditor: SharedPreferences.Editor
    //
    private var saveLogin: Boolean = false

    private val userRepository by lazy { UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = applicationContext))}
    private val getEmail by lazy { GetEmail(userRepository = userRepository)}
    private val saveEmail by lazy { SaveEmail(userRepository = userRepository) }


    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var check: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailEditText = findViewById(R.id.input_login)
        passwordEditText = findViewById(R.id.input_password)
        check = findViewById(R.id.chekLogin)
        val nextButton = findViewById<Button>(R.id.login_btn)
        val registrButton = findViewById<Button>(R.id.registr_btn)

        registrButton.setOnClickListener {
            val regIntent = Intent(this@MainActivity, Registration::class.java)
            startActivity(regIntent)
        }

        nextButton.setOnClickListener {
            val emailText = emailEditText.text.toString()
            val passwordText = passwordEditText.text.toString()
            loginUserEmail.loginUser(emailText, passwordText, this@MainActivity)

        }

        // Это нужно обязательно додумать и изменить
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE)
        loginPrefsEditor = loginPreferences.edit()
        saveLogin = loginPreferences.getBoolean("saveLogin", false)

        val userName = getEmail.execute()
        if(saveLogin){
            emailEditText.setText(userName.email)
            passwordEditText.setText(userName.password)
            check.isChecked = true
        }

    }

    fun saveLogin(view: View){
        if(view == check){
            val userEmail = emailEditText.text.toString()
            val userPassword = passwordEditText.text.toString()
            if(check.isChecked){
                loginPrefsEditor.putBoolean("saveLogin", true)
                val params = SaveUserEmailParam(email = userEmail, password = userPassword)
                saveEmail.execute(param = params)
                loginPrefsEditor.commit()
            } else {
                loginPrefsEditor.putBoolean("saveLogin", false)
                val params = SaveUserEmailParam(email = "", password = "")
                saveEmail.execute(param = params)
                loginPrefsEditor.clear()
                loginPrefsEditor.commit()
            }
        }
    }
}

