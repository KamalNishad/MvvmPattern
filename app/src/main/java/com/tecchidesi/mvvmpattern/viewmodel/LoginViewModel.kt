package com.tecchidesi.mvvmpattern.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tecchidesi.mvvmpattern.model.Login

class LoginViewModel : ViewModel() {

    var EmailAddress: MutableLiveData<String> = MutableLiveData()
    var Password: MutableLiveData<String> = MutableLiveData()


    private var userMutableLiveData: MutableLiveData<Login>? = null

    fun getUser(): MutableLiveData<Login>? {
        if (userMutableLiveData == null) {
            userMutableLiveData = MutableLiveData()
        }
        return userMutableLiveData
    }

    fun onClick() {
        val loginUser = Login(EmailAddress.value, Password.value)
        userMutableLiveData!!.setValue(loginUser)
    }

}