package com.example.domain.repository

import com.example.domain.models.SaveUserEmailParam
import com.example.domain.models.UserEmail

interface UserRepository {
    fun saveEmail(saveParam:SaveUserEmailParam):Boolean
    fun getEmal():UserEmail
}