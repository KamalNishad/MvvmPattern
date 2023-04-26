package gov.chips.cgstate.cgrofra.api

import android.widget.ImageView
import com.tecchidesi.observerexample.Model.ProductList

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.*


interface ApiInterface {

    @GET("products")
    fun getProducts():Call<ProductList>

}