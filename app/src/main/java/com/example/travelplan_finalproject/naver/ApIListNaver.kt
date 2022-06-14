package com.example.travelplan_finalproject.naver

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApIListNaver {

    @GET("local")
    fun getSearchlocal(

        @Query("query") keyword: String,
        @Query("display") display : Int
        ): Call<BasicResponseNaver>

}