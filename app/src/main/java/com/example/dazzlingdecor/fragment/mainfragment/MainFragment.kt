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
import com.example.dazzlingdecor.ItemCliickListner
import com.example.dazzlingdecor.adapter.RecyclerViewColorPalleteAdapter

import com.example.dazzlingdecor.apihelper.ApiHelper
import com.example.dazzlingdecor.databinding.FragmentMainBinding
import com.example.dazzlingdecor.fragment.mainfragment.viewmodel.MainFragmentViewModel
import com.example.dazzlingdecor.screens.mainactivity.MainActivity
import com.example.dazzlingdecor.screens.wallpapersearched.WallpaperSearchedActivity
import com.facebook.shimmer.Shimmer


class MainFragment : Fragment(), ItemCliickListner {
    lateinit var binding: FragmentMainBinding
    lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]
        binding.recViewColor.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recViewColor.adapter = RecyclerViewColorPalleteAdapter(this, this.requireContext(), MainActivity.colorList)
      viewModel.getCuratedImages(binding.recViewBestOfMonth,this.requireContext(),binding.mainShimmer)
// hello
        viewModel.getCategoriesImagesRec(binding.recViewCategories,this.requireContext())

        binding.btnSearchWallpaper.setOnClickListener {
            val searchValue = binding.edtSearchWallpaper.text.toString()
            if (searchValue != "") {
                startActivity(
                    Intent(this.requireContext(), WallpaperSearchedActivity::class.java)
                        .putExtra("search", searchValue)
                        .putExtra("colorCode", "#FF000000")
                )
            } else {
                Toast.makeText(requireContext(), "Please Enter Name", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

    override fun OnItemClickListeners(position: Int) {
        val intent = Intent(this.requireContext(), WallpaperSearchedActivity::class.java)
        if (binding.edtSearchWallpaper.text.toString() != "") {
            intent.putExtra("search", binding.edtSearchWallpaper.text.toString())
        } else {
            intent.putExtra("search", "Nature")
        }
        intent.putExtra("colorCode", MainActivity.colorList[position].color)
        startActivity(intent)

    }
}