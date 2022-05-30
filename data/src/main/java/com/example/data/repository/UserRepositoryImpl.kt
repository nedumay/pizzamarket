package com.example.data.repository

import com.example.data.storage.User
import com.example.data.storage.UserStorage
import com.example.domain.models.SaveUserEmailParam
import com.example.domain.models.UserEmail
import com.example.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage):UserRepository {
    override fun saveEmail(saveParam: SaveUserEmailParam): Boolean {
        val user = User(email = saveParam.email, password = saveParam.password)
        return userStorage.saveEmail(user)
    }

    override fun getEmal(): UserEmail {
        val user = userStorage.getEmal()
        val userEmail = UserEmail(email = user.email, password = user.password)
        return userEmail
    }

}