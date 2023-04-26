package com.tecchidesi.mvvmpattern.network

import com.tecchidesi.mvvmpattern.model.LoginResp
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("txtUsername") email: String,
        @Field("txtPassword") password: String
    ): Response<LoginResp>

}