package com.example.dazzlingdecor.fragment.mainfragment.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dazzlingdecor.adapter.RecyclerViewBestOfMonthAdapter
import com.example.dazzlingdecor.apihelper.ApiHelper
import com.example.dazzlingdecor.model.DataModel

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragmentViewModel():ViewModel(){
 fun getCuratedImages(recyclerView: RecyclerView,context: Context) {
     val apiHelper = ApiHelper.create()
     apiHelper.getCuratedImages(40).enqueue(object :Callback<DataModel> {
         override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
if (response.isSuccessful) {
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



}