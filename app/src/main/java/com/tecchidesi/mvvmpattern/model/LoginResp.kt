package com.tecchidesi.mvvmpattern.model

data class LoginResp(
    var status: Boolean? = null,
    var message: String? = null,
    var data: LoginData? = LoginData(0,"","","","","","","","","","","","","",0,"",0,"",0,"",0,"",0,"",0),
    var validation_error: String? = null
)