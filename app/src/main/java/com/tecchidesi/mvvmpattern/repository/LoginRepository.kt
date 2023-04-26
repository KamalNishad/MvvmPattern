package com.tecchidesi.mvvmpattern.repository

import com.bumptech.glide.load.engine.Resource
import com.tecchidesi.mvvmpattern.model.LoginResp
import com.tecchidesi.mvvmpattern.network.ApiService

class LoginRepository(private val apiService: ApiService) {

/*    suspend fun login(username: String, password: String): Resource<LoginResp> {
        val response = apiService.login(username, password)
        if (response.isSuccessful) {
            response.body()?.let {
               it.status
            }
        }
        return Resource.error("Unable to login", null)
    }*/


}