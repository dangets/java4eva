package com.dangets

import retrofit2.Call
import retrofit2.http.GET

interface ClientK {
    data class UserDto(val id: Int = 0, val name: String = "", val email: String? = null)

    @GET("users")
    fun getAllUsers(): Call<List<UserDto>>
}
