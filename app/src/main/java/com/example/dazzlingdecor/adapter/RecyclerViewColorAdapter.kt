package com.example.dazzlingdecor.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.dazzlingdecor.ItemCliickListner
import com.example.dazzlingdecor.databinding.RowColorPalleteBinding
import com.example.dazzlingdecor.fragment.mainfragment.MainFragment
import com.example.dazzlingdecor.fragment.mainfragment.viewmodel.MainActivityViewModel
import com.example.dazzlingdecor.model.ColorModel
import com.example.dazzlingdecor.screens.mainactivity.MainActivity

class RecyclerViewColorAdapter(val context:Context,val colorList:ArrayList<ColorModel>,val onClickEvent:OnItemSelectedList):RecyclerView.Adapter<RecyclerViewColorAdapter.ViewHolder>() {
    interface OnItemSelectedList{
        fun onItemClick(position: Int)
    }
   /* var listner:ItemCliickListner?=null

    fun setonItemClickListener(listners: ItemCliickListner?){
        this.listner=listners
    }*/
    class ViewHolder(val binding:RowColorPalleteBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowColorPalleteBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount(): Int {
        return colorList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.llLayout.setOnClickListener {

onClickEvent.onItemClick(position)
    /*   listner?.OnItemClickListener(position)*/



        }
        holder.binding.llLayout.setBackgroundResource(colorList[position].colorResource)
    }
}