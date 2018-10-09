package com.dangets

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ClientK {
    @GET("users")
    fun getAllUsers(): Call<List<UserDto>>

    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): Call<List<UserDto>>

    data class UserDto(val id: Int, val name: String, val email: String)

    companion object {
        fun getObjectMapper() = ObjectMapper().registerKotlinModule()
    }
}
