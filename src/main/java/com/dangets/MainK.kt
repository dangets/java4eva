package com.dangets

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

fun main(args: Array<String>) {
    val okHttpClient = OkHttpClient()
    val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:4567")
            .client(okHttpClient)
            .build()

    useClientJ(retrofit)

    okHttpClient.dispatcher().executorService().shutdown()
}

fun useClientJ(baseRetrofit: Retrofit) {
    val retrofit = baseRetrofit.newBuilder()
            .addConverterFactory(JacksonConverterFactory.create(ClientJ.getObjectMapper()))
            .build()

    val j = retrofit.create(ClientJ::class.java)
    val resp = j.allUsers.execute()
    resp.body()?.forEach { println(it) }
}