package com.example.dazzlingdecor.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.dazzlingdecor.databinding.RowCatWallRecBinding
import com.example.dazzlingdecor.model.CatWallModel
import com.example.dazzlingdecor.screens.wallpapersearched.WallpaperSearchedActivity

class RecyclerViewCategoriesAdapters(val context: Context,val wallList:ArrayList<CatWallModel>):RecyclerView.Adapter<RecyclerViewCategoriesAdapters.ViewHolder>() {
    class ViewHolder(val binding:RowCatWallRecBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            RowCatWallRecBinding.inflate(
                LayoutInflater.from(
                    context
                ), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
       return wallList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, WallpaperSearchedActivity::class.java).putExtra("search",wallList[position].catName).putExtra("colorCode","#FF000000"))
        }
        holder.binding.txtCatName.text=wallList[position].catName
        holder.binding.imgViewCat.setImageResource(wallList[position].catImg)
    }
}