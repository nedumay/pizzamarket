package com.example.data.storage

import android.content.Context
import android.content.SharedPreferences

private const val SHARED_PREF_USER = "shared_pref_user"
private const val KEY_EMAIL = "key_email"
private const val KEY_PASSWORD = "key_password"
private const val KEY_EMAIL_DEFAULT = "key_email_default"
private const val KEY_PASSWORD_DEFAULT = "key_password_default"
private const val KEY_CHEKBOX = "key_chekbox"

class SharedPrefUserStorage(private val context: Context):UserStorage {
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF_USER, Context.MODE_PRIVATE)


    override fun saveEmail(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_EMAIL, user.email).apply()
        sharedPreferences.edit().putString(KEY_PASSWORD, user.password).apply()
        return true
    }

    override fun getEmal(): User {
        val userEmail = sharedPreferences.getString(KEY_EMAIL, KEY_EMAIL_DEFAULT)?: KEY_EMAIL_DEFAULT
        val userPassword = sharedPreferences.getString(KEY_PASSWORD, KEY_PASSWORD_DEFAULT)?: KEY_PASSWORD_DEFAULT
        return User(email = userEmail, password = userPassword)
    }

}