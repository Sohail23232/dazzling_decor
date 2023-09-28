package com.example.dazzlingdecor.adapter

import android.content.ClipData.Item
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dazzlingdecor.ItemCliickListner
import com.example.dazzlingdecor.databinding.RowSearchedWallpaperBinding

import com.example.dazzlingdecor.model.PhotosModel
import com.example.dazzlingdecor.screens.FullScreenWallpaperActivity

class RecyclerViewSearchedWallpaperAdapter(val context:Context, val wallList:ArrayList<PhotosModel>):RecyclerView.Adapter<RecyclerViewSearchedWallpaperAdapter.ViewHolder>() {

    class ViewHolder(val binding:RowSearchedWallpaperBinding):RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowSearchedWallpaperBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount(): Int {
     return   wallList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imgView.setOnClickListener {

        }
        holder.binding.imgView.setOnClickListener {
            context.startActivity(Intent(context,FullScreenWallpaperActivity::class.java).putExtra("image",wallList[position].src.portrait))
        }
Glide.with(context).load(wallList[position].src.portrait).into(holder.binding.imgView)
    }
}