package com.example.pizzamarket

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pizzamarket.databinding.ActivityMainBinding
import com.example.pizzamarket.domain.LoginUserEmail
import com.example.pizzamarket.ui.Registration

class MainActivity : AppCompatActivity() {

    private lateinit var bindingStart: ActivityMainBinding
    private val loginUserEmail = LoginUserEmail()
    private lateinit var loginPreferences: SharedPreferences
    private lateinit var loginPrefsEditor: SharedPreferences.Editor
    private var saveLogin: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        bindingStart = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingStart.root)

        /***Сохранение логина***/
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE)
        loginPrefsEditor = loginPreferences.edit()
        saveLogin = loginPreferences.getBoolean("saveLogin", false)

        /** Вход через аккаунт **/
        var email:String
        var password:String
        bindingStart.loginBtn.setOnClickListener {
            email = bindingStart.inputLogin.text.toString()
            password = bindingStart.inputPassword.text.toString()
            loginUserEmail.loginUser(email, password, this@MainActivity)
        }
        if(saveLogin){
            bindingStart.inputLogin.setText(loginPreferences.getString("username"," "))
            bindingStart.inputPassword.setText(loginPreferences.getString("password"," "))
            bindingStart.chekLogin.isChecked = true
        }

        bindingStart.registrBtn.setOnClickListener {
            val regIntent = Intent(this@MainActivity, Registration::class.java)
            startActivity(regIntent)
        }

    }

    fun saveLogin(view: View) {
        if (view == bindingStart.chekLogin){
            val username = bindingStart.inputLogin.text.toString()
            val password = bindingStart.inputPassword.text.toString()
            if(bindingStart.chekLogin.isChecked){
                loginPrefsEditor.putBoolean("saveLogin", true)
                loginPrefsEditor.putString("username", username)
                loginPrefsEditor.putString("password",password)
                loginPrefsEditor.commit()
            } else {
                loginPrefsEditor.clear()
                loginPrefsEditor.commit()
            }
        }
    }

    fun forgotPassword(view: View){

    }
}