package com.example.dazzlingdecor.fragment.mainfragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dazzlingdecor.ItemCliickListner
import com.example.dazzlingdecor.adapter.RecyclerViewColorAdapter
import com.example.dazzlingdecor.databinding.FragmentMainBinding
import com.example.dazzlingdecor.fragment.mainfragment.viewmodel.MainActivityViewModel
import com.example.dazzlingdecor.screens.mainactivity.MainActivity
import com.example.dazzlingdecor.screens.wallpapercategory.WallpaperCategoryActivity
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerFrameLayout


class MainFragment : Fragment()/*,ItemCliickListner */{
lateinit var binding:FragmentMainBinding
lateinit var viewModel: MainActivityViewModel
var colorPos=0
/*
    override fun OnItemClickListener(position: Int) {
     colorPos=position
           Toast.makeText(this.requireContext(), "$position", Toast.LENGTH_SHORT).show()
    }*/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentMainBinding.inflate(inflater,container,false)


    val shimmer=Shimmer.AlphaHighlightBuilder()
        .setDuration(1500)
        .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
        .build()
    binding.shimmer.setShimmer(shimmer)
    binding.shimmer.startShimmer()
viewModel=ViewModelProvider(this)[MainActivityViewModel::class.java]
viewModel.getCuratedImages(binding.recViewCurated,this.requireContext(),binding.shimmer)
binding.recViewColor.layoutManager=LinearLayoutManager(this.requireContext(),LinearLayoutManager.HORIZONTAL,false)
val adapter=RecyclerViewColorAdapter(this.requireContext(),MainActivity.colorList,object :RecyclerViewColorAdapter.OnItemSelectedList{
    override fun onItemClick(position: Int) {
        colorPos=position
        Toast.makeText(requireContext(), "$position", Toast.LENGTH_SHORT).show()
    }

})
/*adapter.setonItemClickListener(this)*/
        binding.recViewColor.adapter= adapter
        binding.btnSearchWallpaper.setOnClickListener{
            val searchValue=binding.edtSearchWallpaper.text.toString()
            if (searchValue!=""){
            startActivity(Intent(this.requireContext(),WallpaperCategoryActivity::class.java)
                .putExtra("search",searchValue)
                .putExtra("colorCode",MainActivity.colorList[colorPos].color))
        }else{
                Toast.makeText(requireContext(), "Please Enter Name", Toast.LENGTH_SHORT).show()
            }
            }

        return binding.root
    }


}