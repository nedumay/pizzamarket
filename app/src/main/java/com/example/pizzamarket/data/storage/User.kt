package com.example.pizzamarket.data.storage

class User {
    var email = ""
    var password = ""

    fun name(email: String){
        this.email = email
    }
    fun password(password:String){
        this.password = password
    }
}