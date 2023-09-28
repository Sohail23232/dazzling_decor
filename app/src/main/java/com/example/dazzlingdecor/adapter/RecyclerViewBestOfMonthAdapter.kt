package com.example.dazzlingdecor.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dazzlingdecor.ItemCliickListner
import com.example.dazzlingdecor.databinding.RowBestMonthRecViewBinding
import com.example.dazzlingdecor.model.PhotosModel
import com.example.dazzlingdecor.screens.FullScreenWallpaperActivity

class RecyclerViewBestOfMonthAdapter(val context:Context,val photoList:ArrayList<PhotosModel>):RecyclerView.Adapter<RecyclerViewBestOfMonthAdapter.ViewHolder>() {
    class ViewHolder(val binding:RowBestMonthRecViewBinding):RecyclerView.ViewHolder(binding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowBestMonthRecViewBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount(): Int {
 return photoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imgView.setOnClickListener {

            context.startActivity(Intent(context,FullScreenWallpaperActivity::class.java).putExtra("image",photoList[position].src.portrait))
        }
        if (photoList[position].src.portrait != "") {
            Glide.with(context).load(photoList[position].src.portrait).into(holder.binding.imgView)
        }
    }
}