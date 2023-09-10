package com.example.dazzlingdecor.fragment.mainfragment.viewmodel

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dazzlingdecor.R
import com.example.dazzlingdecor.adapter.RecyclerViewCategoriesWallpaper
import com.example.dazzlingdecor.apihelper.ApiHelper
import com.example.dazzlingdecor.model.ColorModel
import com.example.dazzlingdecor.model.DataModel
import com.example.dazzlingdecor.model.PhotosModel
import com.example.dazzlingdecor.screens.mainactivity.MainActivity
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerFrameLayout

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel():ViewModel(){
 fun getCuratedImages(recyclerView: RecyclerView,context: Context,shimmer: ShimmerFrameLayout) {
     val apiHelper = ApiHelper.create()

     apiHelper.getCuratedImages(80).enqueue(object :Callback<DataModel> {
         override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
if (response.isSuccessful) {
    shimmer.stopShimmer()
shimmer.visibility= View.GONE
    recyclerView.visibility=View.VISIBLE
    recyclerView.layoutManager =
        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    recyclerView.adapter =
        RecyclerViewCategoriesWallpaper(context, response.body()!!.photos)
}
         }
         override fun onFailure(call: Call<DataModel>, t: Throwable) {
             Log.d("failure", t.message.toString())
             t.printStackTrace()
         }
     })

 }



}