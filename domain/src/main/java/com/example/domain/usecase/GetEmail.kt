package com.example.domain.usecase

import com.example.domain.models.UserEmail
import com.example.domain.repository.UserRepository

class GetEmail(private val userRepository: UserRepository) {
    fun execute():UserEmail{
        return userRepository.getEmal()
    }
}