package com.example.dazzlingdecor.fragment.mainfragment.viewmodel

import android.content.Context
import android.graphics.drawable.Drawable
import android.media.Image
import android.text.Layout
import android.util.Log
import android.view.View
import android.widget.ScrollView
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dazzlingdecor.adapter.RecyclerViewBestOfMonthAdapter

import com.example.dazzlingdecor.apihelper.ApiHelper
import com.example.dazzlingdecor.model.CatWallModel
import com.example.dazzlingdecor.model.DataModel
import com.example.dazzlingdecor.model.ImageSourceModel
import com.example.dazzlingdecor.screens.mainactivity.MainActivity
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerFrameLayout

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragmentViewModel:ViewModel(){
    val apiHelper = ApiHelper.create()






 fun getCuratedImages(recyclerView: RecyclerView, context: Context, shimmer:ShimmerFrameLayout) {
/*     apiHelper.getCuratedImages(40).enqueue(object :Callback<DataModel> {
         override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
if (response.isSuccessful) {
    shimmer.stopShimmer()
    shimmer.visibility=View.GONE
    recyclerView.visibility=View.VISIBLE

    recyclerView.layoutManager =
        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    recyclerView.adapter =
        RecyclerViewBestOfMonthAdapter(context, response.body()!!.photos)
}
         }
         override fun onFailure(call: Call<DataModel>, t: Throwable) {
             Log.d("failure", t.message.toString())
             t.printStackTrace()
         }
     })*/

 }



}