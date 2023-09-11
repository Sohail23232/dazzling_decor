package com.example.dazzlingdecor.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.dazzlingdecor.R
import com.example.dazzlingdecor.databinding.ActivityFullScreenWallpaperBinding

class FullScreenWallpaperActivity : AppCompatActivity() {
    lateinit var binding:ActivityFullScreenWallpaperBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFullScreenWallpaperBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val image=intent.getStringExtra("image")
        Glide.with(this).load(image).into(binding.mainImage)
    }
}