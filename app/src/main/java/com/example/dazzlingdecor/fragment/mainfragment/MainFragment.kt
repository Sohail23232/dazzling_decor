package com.example.dazzlingdecor.fragment.mainfragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.dazzlingdecor.ItemCliickListner
import com.example.dazzlingdecor.R
import com.example.dazzlingdecor.adapter.RecyclerViewBestOfMonthAdapter

import com.example.dazzlingdecor.adapter.RecyclerViewCategoriesAdapters
import com.example.dazzlingdecor.adapter.RecyclerViewColorPalleteAdapter
import com.example.dazzlingdecor.apihelper.ApiHelper
import com.example.dazzlingdecor.databinding.FragmentMainBinding
import com.example.dazzlingdecor.fragment.mainfragment.viewmodel.MainFragmentViewModel
import com.example.dazzlingdecor.model.CatWallModel
import com.example.dazzlingdecor.model.DataModel
import com.example.dazzlingdecor.screens.mainactivity.MainActivity
import com.example.dazzlingdecor.screens.wallpapersearched.WallpaperSearchedActivity
import com.facebook.shimmer.Shimmer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragment : Fragment(), ItemCliickListner {
    lateinit var binding: FragmentMainBinding
    lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]
            /*
            viewModel.getCuratedImages(
              binding.recViewBestOfMonth,
                this.requireContext(),
                binding.mainShimmer)
            */
        val apiHelper=ApiHelper.create()
        val shimmer=Shimmer.AlphaHighlightBuilder().setDirection(Shimmer.Direction.LEFT_TO_RIGHT).build()
        binding.mainShimmer.setShimmer(shimmer)
        binding.mainShimmer.startShimmer()
        apiHelper.getCuratedImages(40).enqueue(object : Callback<DataModel> {
            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                if (response.isSuccessful) {
                    binding.mainShimmer.stopShimmer()
                    binding.mainShimmer.visibility=View.GONE
                    binding.recViewBestOfMonth.visibility=View.VISIBLE
                        binding.recViewBestOfMonth.layoutManager =
                        LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                    binding.recViewBestOfMonth.adapter =
                        RecyclerViewBestOfMonthAdapter(requireContext(), response.body()!!.photos)
                }
            }
            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                Log.d("failure", t.message.toString())
                t.printStackTrace()
            }
        })
        binding.recViewColor.layoutManager =
            LinearLayoutManager(this.requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recViewColor.adapter =
            RecyclerViewColorPalleteAdapter(this, this.requireContext(), MainActivity.colorList)
        val catNameList=ArrayList<CatWallModel>().apply {
            add(CatWallModel(1,"Abstract",R.drawable.abstracts))
            add(CatWallModel(2,"Anime",R.drawable.anime))
            add(CatWallModel(3,"Art",R.drawable.artss))
            add(CatWallModel(4,"Amoled",R.drawable.amoled))
            add(CatWallModel(5,"Portrait",R.drawable.portrait))
            add(CatWallModel(6,"Space",R.drawable.space))
            add(CatWallModel(7,"Gradients",R.drawable.gradient))
            add(CatWallModel(8,"Illustration",R.drawable.illustration))
            add(CatWallModel(9,"Cyber",R.drawable.cyber))
            add(CatWallModel(10,"Nature",R.drawable.nature))

        }
        binding.recViewCategories.layoutManager = LinearLayoutManager(this.requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.recViewCategories.adapter =
            RecyclerViewCategoriesAdapters(this.requireContext(), catNameList)

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