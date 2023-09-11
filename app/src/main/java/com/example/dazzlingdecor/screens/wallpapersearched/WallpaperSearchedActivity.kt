package com.example.dazzlingdecor.screens.wallpapersearched

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dazzlingdecor.adapter.RecyclerViewSearchedWallpaperAdapter
import com.example.dazzlingdecor.apihelper.ApiHelper
import com.example.dazzlingdecor.databinding.ActivityWallpaperCategoryBinding
import com.example.dazzlingdecor.model.DataModel
import com.facebook.shimmer.Shimmer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WallpaperSearchedActivity : AppCompatActivity() {
    lateinit var binding:ActivityWallpaperCategoryBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityWallpaperCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val shimmer=Shimmer.AlphaHighlightBuilder()
            .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
            .build()
        //
        binding.shimmer.setShimmer(shimmer)
        binding.shimmer.startShimmer()
val searchValue=intent.getStringExtra("search")
val color=intent.getStringExtra("colorCode")
        Toast.makeText(this@WallpaperSearchedActivity, "$color", Toast.LENGTH_SHORT).show()
   val apiHelper=ApiHelper.create()

        apiHelper.getColorSearchImages(searchValue!!,"$color").enqueue(object :Callback<DataModel>{
            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                if (response.isSuccessful){
            binding.shimmer.stopShimmer()
            binding.shimmer.visibility= View.GONE
            binding.recViewPerCategories.visibility=View.VISIBLE
                    binding.txtWallpaperCategory.visibility=View.VISIBLE
                    binding.txtWallpaperCount.visibility=View.VISIBLE

                val noOfWallpaper=response.body()!!.per_page.toString()
                binding.txtWallpaperCategory.text=searchValue
                binding.txtWallpaperCount.text= "$noOfWallpaper wallpaper available"
             binding.recViewPerCategories.layoutManager= GridLayoutManager(this@WallpaperSearchedActivity,2)
                binding.recViewPerCategories.adapter=RecyclerViewSearchedWallpaperAdapter(this@WallpaperSearchedActivity,response.body()!!.photos)

                }
                }
            override fun onFailure(call: Call<DataModel>, t: Throwable) {
               Log.d("failure",t.message.toString())
                t.printStackTrace()
            }
        })
    }
}