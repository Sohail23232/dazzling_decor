package com.example.dazzlingdecor.apihelper

import com.example.dazzlingdecor.fragment.mainfragment.MainFragment
import com.example.dazzlingdecor.model.DataModel
import com.example.dazzlingdecor.model.PhotosModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiHelper {

    companion object{
        val BASE_URL ="https://api.pexels.com/v1/"
        fun create():ApiHelper{
            val retrofit=Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiHelper::class.java)
        }

    }


    @GET("search") @Headers("Authorization: yFrmo7ifGl0K0gliA3mA8ULyDP8nhqSZFzCm9UaRFW2wyHgrFVmRf9Fo")
    abstract fun getSearchImages(@Query("query")  search:String ,@Query("per_page") perPage:Int): Call<DataModel>

    @GET("curated") @Headers("Authorization: yFrmo7ifGl0K0gliA3mA8ULyDP8nhqSZFzCm9UaRFW2wyHgrFVmRf9Fo")
    abstract fun getCuratedImages(@Query("per_page") perPage:Int):Call<DataModel>
@GET("search") @Headers("Authorization: yFrmo7ifGl0K0gliA3mA8ULyDP8nhqSZFzCm9UaRFW2wyHgrFVmRf9Fo")
abstract fun getColorSearchImages(@Query("query") search: String,@Query("color") color:String):Call<DataModel>

}