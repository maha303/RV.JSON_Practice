package com.example.rvjson_practice

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("/people/")
    fun getName(): Call<List<NameItem>>

}