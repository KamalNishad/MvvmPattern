package com.tecchidesi.mvvmpattern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.tecchidesi.mvvmpattern.databinding.ActivityLoginBinding
import com.tecchidesi.mvvmpattern.viewmodel.LoginViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class LoginActivity : AppCompatActivity() {

    private var mBinding:ActivityLoginBinding?=null

    private lateinit var viewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = androidx.lifecycle.ViewModelProvider(this).get(LoginViewModel::class.java)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        mBinding!!.lifecycleOwner = this;
        mBinding!!.loginViewModel = viewModel

        init()
    }

    private fun init(){

        viewModel.getUser()!!.observe(this, Observer {


            if (mBinding!!.etUsername.text.toString().isEmpty()){
                mBinding!!.etUsername.error = "Enter userid"
                mBinding!!.etUsername.requestFocus()
            }else if (mBinding!!.etPass.text.toString().isEmpty()){
                mBinding!!.etPass.error = "Enter password"
                mBinding!!.etPass.requestFocus()
            }else if (mBinding!!.etUsername.text.toString().equals("kk") && mBinding!!.etPass.text.toString().equals("123")){
                Toast.makeText(applicationContext, "Successful Login", Toast.LENGTH_SHORT).show()
                navigation()



            }else{
                Toast.makeText(applicationContext, "Invalid Login", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun navigation(){
        var intent = Intent(this,MainActivity::class.java)
        intent.putExtra("username",viewModel.EmailAddress.toString())
        intent.putExtra("pass",viewModel.Password.toString())
        startActivity(intent)
    }
}