package com.tecchidesi.mvvmpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.tecchidesi.mvvmpattern.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding:ActivityMainBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        var uid = intent.getStringExtra("username")
        var pass = intent.getStringExtra("pass")

        mBinding!!.tvData.setText("username :"+ uid +"password :"+pass)
    }
}