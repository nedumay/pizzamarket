package com.example.pizzamarket.domain

import android.app.ProgressDialog
import android.content.Intent
import android.widget.Toast
import com.example.pizzamarket.MainActivity
import com.example.pizzamarket.MenuActivity
import com.example.pizzamarket.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await

class LoginUserEmail {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var progDialog: ProgressDialog

    internal  fun loginUser(email:String, password:String, loginActivity: MainActivity){
        progDialog = ProgressDialog(loginActivity)
        progDialog.setTitle(R.string.loading)
        progDialog.setMessage(loginActivity.getResources().getString(R.string.check))

        if(email.isNotEmpty() && password.isNotEmpty()){

            CoroutineScope(Dispatchers.IO).launch{
                try {
                    auth.signInWithEmailAndPassword(email,password).await()
                    withContext(Dispatchers.Main){
                        progDialog.show()
                        delay(5000)
                        checkLoggedInState(loginActivity)
                        progDialog.dismiss()
                    }
                } catch (e:Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(loginActivity, e.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

    }

    private fun checkLoggedInState( loginActivity: MainActivity){
        val logIntent = Intent(loginActivity, MenuActivity::class.java)
        if(auth.currentUser == null){
            Toast.makeText(loginActivity, R.string.no_log, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(loginActivity, R.string.logged, Toast.LENGTH_SHORT).show()
            loginActivity.startActivity(logIntent)
        }
    }
}