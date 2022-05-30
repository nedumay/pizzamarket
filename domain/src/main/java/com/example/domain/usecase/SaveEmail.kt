package com.example.domain.usecase

import com.example.domain.models.SaveUserEmailParam
import com.example.domain.repository.UserRepository

class SaveEmail(private val userRepository: UserRepository) {

    fun execute(param:SaveUserEmailParam):Boolean{
        val oldUserEmail = userRepository.getEmal()
        if(oldUserEmail.email == param.email && oldUserEmail.password == param.password){
            return true
        }
        val result = userRepository.saveEmail(saveParam = param)
        return result
    }
}