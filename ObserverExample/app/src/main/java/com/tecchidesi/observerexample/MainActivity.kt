package com.tecchidesi.observerexample

import android.database.Observable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.jakewharton.rxbinding4.view.clicks
import com.tecchidesi.observerexample.Model.ProductList
import com.tecchidesi.observerexample.Model.ProductListItem
import gov.chips.cgstate.cgrofra.api.ApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Objects
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private var TAG:String = "MainActivity"
    private var productList: MutableList<ProductList>?= mutableListOf()
    private var mProduct: ProductList?=null
    private var tvData : TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnThrottleFirst : Button = findViewById(R.id.btn_throttleFirst)
        var btnGetProduct : Button = findViewById(R.id.btn_getProduct)
        tvData  = findViewById(R.id.tv_data)

        btnThrottleFirst.clicks()
            .throttleFirst(15000,TimeUnit.MILLISECONDS)
            .subscribe {
                Log.d(TAG,"throttleFirst duration : 15000 MLS")
        }

        btnGetProduct.clicks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .throttleFirst(15000,TimeUnit.MILLISECONDS)
            .subscribe{
                Log.d(TAG,"throttleFirst duration api : 15000 MLS")

            }

        simpleObserver()
    }



    private fun simpleObserver(){
        var list  = listOf<String>("member 1","member 2","member 3")
        val observable = io.reactivex.rxjava3.core.Observable.fromIterable(list)

        observable.subscribe(object : io.reactivex.rxjava3.core.Observer<String>{
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG,"onSubscribe")
            }

            override fun onError(e: Throwable) {
                Log.d(TAG,"onError")
            }

            override fun onComplete() {
                Log.d(TAG,"onComplete")
            }

            override fun onNext(t: String) {
                Log.d(TAG,"onNext")
            }

        })

    }


    private fun fetchProducts(){
       var call: Call<ProductList> = ApiClient.getClient.getProducts()
        call.enqueue(object :Callback<ProductList>{
            override fun onResponse(call: Call<ProductList>, response: Response<ProductList>) {
                Log.d(TAG, "res : $response")

                mProduct = response.body()
                val occupation = mProduct!![0].category
                tvData?.setText(occupation)
            }

            override fun onFailure(call: Call<ProductList>, t: Throwable) {

            }
        })
    }
}

