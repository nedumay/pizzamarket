package com.example.pizzamarket.di

import com.example.domain.usecase.GetEmail
import com.example.domain.usecase.SaveEmail
import org.koin.dsl.module

val domainModule = module{
    factory<GetEmail> { GetEmail(userRepository = get()) }
    factory<SaveEmail> { SaveEmail(userRepository = get()) }
}