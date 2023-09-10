package com.example.dazzlingdecor.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dazzlingdecor.ItemCliickListner
import com.example.dazzlingdecor.databinding.RowWallpaperCategoryRecViewBinding
import com.example.dazzlingdecor.model.PhotosModel

class RecyclerViewCategoriesWallpaper(val context:Context,val wallList:ArrayList<PhotosModel>):RecyclerView.Adapter<RecyclerViewCategoriesWallpaper.ViewHolder>() {
   var listner:ItemCliickListner?=null
    fun setOnItemClick(listner: ItemCliickListner){
        this.listner=listner
    }
    class ViewHolder(val binding:RowWallpaperCategoryRecViewBinding):RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowWallpaperCategoryRecViewBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount(): Int {
     return   wallList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imgView.setOnClickListener {
            listner?.OnItemClickListener(position)
        }
Glide.with(context).load(wallList[position].src.portrait).into(holder.binding.imgView)
    }
}