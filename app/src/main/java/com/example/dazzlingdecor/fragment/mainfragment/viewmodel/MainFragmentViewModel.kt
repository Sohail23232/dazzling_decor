package com.example.dazzlingdecor.fragment.mainfragment.viewmodel

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dazzlingdecor.adapter.RecyclerViewBestOfMonthAdapter
import com.example.dazzlingdecor.adapter.RecyclerViewCategoriesAdapters
import com.example.dazzlingdecor.adapter.RecyclerViewColorPalleteAdapter

import com.example.dazzlingdecor.apihelper.ApiHelper
import com.example.dazzlingdecor.model.DataModel
import com.example.dazzlingdecor.screens.mainactivity.MainActivity
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerFrameLayout

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragmentViewModel:ViewModel(){
    val apiHelper = ApiHelper.create()






 fun getCuratedImages(recyclerView: RecyclerView, context: Context, shimmerLayout:ShimmerFrameLayout) {
     val shimmerData= Shimmer.AlphaHighlightBuilder().setDirection(Shimmer.Direction.LEFT_TO_RIGHT).build()
     shimmerLayout.setShimmer(shimmerData)
     shimmerLayout.startShimmer()
     apiHelper.getCuratedImages(40).enqueue(object :Callback<DataModel> {
         override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
if (response.isSuccessful) {
    shimmerLayout.stopShimmer()
    shimmerLayout.visibility=View.GONE
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
     })

 }
    fun getCategoriesImagesRec(recyclerView: RecyclerView,context: Context){
        recyclerView.layoutManager = GridLayoutManager(context,2)
        recyclerView.adapter =
            RecyclerViewCategoriesAdapters(context, MainActivity.catNameList)
    }



}