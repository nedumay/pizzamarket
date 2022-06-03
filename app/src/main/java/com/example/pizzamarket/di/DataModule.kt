package com.example.pizzamarket.di

import com.example.data.repository.UserRepositoryImpl
import com.example.data.storage.SharedPrefUserStorage
import com.example.data.storage.UserStorage
import com.example.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module{
    single<UserStorage> { SharedPrefUserStorage(context = get()) }
    single<UserRepository> { UserRepositoryImpl(userStorage = get()) }
}