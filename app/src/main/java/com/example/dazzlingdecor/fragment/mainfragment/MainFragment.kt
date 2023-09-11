package com.example.dazzlingdecor.fragment.mainfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dazzlingdecor.adapter.RecyclerViewColorPalleteAdapter
import com.example.dazzlingdecor.databinding.FragmentMainBinding
import com.example.dazzlingdecor.fragment.mainfragment.viewmodel.MainFragmentViewModel
import com.example.dazzlingdecor.screens.mainactivity.MainActivity
import com.example.dazzlingdecor.screens.wallpapersearched.WallpaperSearchedActivity


class MainFragment : Fragment()/*,ItemCliickListner */{
lateinit var binding:FragmentMainBinding
lateinit var viewModel: MainFragmentViewModel
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


viewModel=ViewModelProvider(this)[MainFragmentViewModel::class.java]
viewModel.getCuratedImages(binding.recViewBestOfMonth,this.requireContext())
binding.recViewColor.layoutManager=LinearLayoutManager(this.requireContext(),LinearLayoutManager.HORIZONTAL,false)
val adapter=RecyclerViewColorPalleteAdapter(this.requireContext(),MainActivity.colorList,object :RecyclerViewColorPalleteAdapter.OnItemSelectedList{
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
            startActivity(Intent(this.requireContext(),WallpaperSearchedActivity::class.java)
                .putExtra("search",searchValue)
                .putExtra("colorCode",MainActivity.colorList[colorPos].color))
        }else{
                Toast.makeText(requireContext(), "Please Enter Name", Toast.LENGTH_SHORT).show()
            }
            }

        return binding.root
    }


}