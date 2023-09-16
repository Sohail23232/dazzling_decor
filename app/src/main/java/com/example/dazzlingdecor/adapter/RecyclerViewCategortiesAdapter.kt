package com.example.dazzlingdecor.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dazzlingdecor.databinding.RowCatWallRecBinding
import com.example.dazzlingdecor.model.CatWallModel

class RecyclerViewCategortiesAdapter(val context: Context,val wallList:ArrayList<CatWallModel>):RecyclerView.Adapter<RecyclerViewCategortiesAdapter.ViewHolder>() {
    class ViewHolder(val binding:RowCatWallRecBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowCatWallRecBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount(): Int {
        return wallList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
}