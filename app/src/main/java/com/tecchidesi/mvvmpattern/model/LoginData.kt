package com.tecchidesi.mvvmpattern.model

data class LoginData(
    var id: Int = 0,
    var userId: String?,
    var username: String? ,
    var fullname: String? ,
    var mobile: String? ,
    var email: String? ,
    var access_platform: String? ,
    var is_password_changed: String? ,
    var department_id: String? ,
    var department_name: String? ,
    var designation_id: String? ,
    var designation_name: String? ,
    var designation_code: String? ,
    var userlevel: String? ,
    var hierarchy: Int? ,
    var department_code: String? ,
    var district_id: Int? ,
    var district: String? ,
    var subdistrict_id: Int? ,
    var subdistrict_hi: String? ,
    var gp_id: Int? ,
    var gp_hi: String? ,
    var is_active: Int? ,
    var token: String? ,
    var client_id: Int? 
)




