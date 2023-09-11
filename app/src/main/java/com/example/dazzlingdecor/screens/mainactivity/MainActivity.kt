package com.example.dazzlingdecor.screens.mainactivity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.dazzlingdecor.R
import com.example.dazzlingdecor.databinding.ActivityMainBinding
import com.example.dazzlingdecor.fragment.DownloadFragment
import com.example.dazzlingdecor.fragment.ProfileFragment
import com.example.dazzlingdecor.fragment.mainfragment.MainFragment
import com.example.dazzlingdecor.model.ColorModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var fm:FragmentManager
    val check=false

    companion object{
        val colorList=ArrayList<ColorModel>().apply {
            add(ColorModel(1,R.color.black,"#FF000000"))
            add(ColorModel(1,R.color.white,"#FFFFFFFF"))
            add(ColorModel(1,R.color.grey,"#FF888484"))
            add(ColorModel(1,R.color.yellow,"#F9A825"))
            add(ColorModel(1,R.color.orange,"#EF6C00"))
            add(ColorModel(1,R.color.red,"#FD0202"))
            add(ColorModel(1,R.color.blue,"#07A2F6"))
            add(ColorModel(1,R.color.green,"#06EF10"))
            add(ColorModel(1,R.color.turquoise,"#03C8B1"))
            add(ColorModel(1,R.color.violet,"#4D09F1"))
            add(ColorModel(1,R.color.pink,"#F60A67"))
            add(ColorModel(1,R.color.peach,"#E39F5B"))
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fm=supportFragmentManager
       loadFrag(MainFragment())
        binding.downloadIndicator.visibility= View.INVISIBLE
        binding.profileIndicator.visibility= View.INVISIBLE
        binding.homeIcon.drawable.setTint(Color.RED)
        binding.downloadIcon.drawable.setTint(Color.BLACK)
        binding.profileIcon.drawable.setTint(Color.BLACK)
        binding.btnDownload.setOnClickListener {
            binding.homeIndicator.visibility= View.INVISIBLE
            binding.profileIndicator.visibility= View.INVISIBLE
            binding.homeIcon.drawable.setTint(Color.BLACK)
            binding.downloadIndicator.visibility=View.VISIBLE
            binding.downloadIcon.drawable.setTint(Color.RED)
            loadFrag(DownloadFragment())
        }
        binding.btnHome.setOnClickListener {
            loadFrag(MainFragment())
            binding.downloadIndicator.visibility= View.INVISIBLE
            binding.profileIndicator.visibility= View.INVISIBLE
            binding.homeIndicator.visibility=View.VISIBLE
            binding.downloadIcon.drawable.setTint(Color.BLACK)
            binding.profileIcon.drawable.setTint(Color.BLACK)
            binding.homeIcon.drawable.setTint(Color.RED)
        }
        binding.btnProfile.setOnClickListener {
            loadFrag(ProfileFragment())
            binding.downloadIndicator.visibility= View.INVISIBLE
            binding.homeIndicator.visibility= View.INVISIBLE
            binding.profileIndicator.visibility=View.VISIBLE
            binding.homeIcon.drawable.setTint(Color.BLACK)
            binding.downloadIcon.drawable.setTint(Color.BLACK)
            binding.profileIcon.drawable.setTint(Color.RED)
        }

    }
    fun loadFrag(fragment: Fragment){
        val ft=fm.beginTransaction()
        if (check){
            ft.add(R.id.container,fragment)
        }
        else{
            ft.replace(R.id.container,fragment)
        }
        ft.commit()
    }

}

