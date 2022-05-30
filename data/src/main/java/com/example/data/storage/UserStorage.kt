package com.example.data.storage

import android.content.SharedPreferences


interface UserStorage {
    fun saveEmail(user: User):Boolean
    fun getEmal(): User
}