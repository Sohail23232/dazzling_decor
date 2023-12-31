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
import com.example.dazzlingdecor.model.CatWallModel
import com.example.dazzlingdecor.model.ColorModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var fm:FragmentManager
    val check=false

    companion object{
        val catNameList=ArrayList<CatWallModel>().apply {
            add(CatWallModel(1,"Abstract", R.drawable.abstracts))
            add(CatWallModel(2,"Anime", R.drawable.anime))
            add(CatWallModel(3,"Art", R.drawable.art))
            add(CatWallModel(4,"Amoled", R.drawable.amoled))
            add(CatWallModel(5,"Portrait", R.drawable.portrait))
            add(CatWallModel(6,"Space", R.drawable.space))
            add(CatWallModel(7,"Gradients", R.drawable.gradient))
            add(CatWallModel(8,"Illustration", R.drawable.illus))
            add(CatWallModel(9,"Cyber", R.drawable.cyber))
            add(CatWallModel(10,"Nature", R.drawable.nature))
        }
        //
        val colorList=ArrayList<ColorModel>().apply {
            add(ColorModel(1,R.color.black,"#FF000000"))
            add(ColorModel(2,R.color.white,"#FFFFFFFF"))
            add(ColorModel(3,R.color.grey,"#FF888484"))
            add(ColorModel(4,R.color.yellow,"#F9A825"))
            add(ColorModel(5,R.color.orange,"#EF6C00"))
            add(ColorModel(6,R.color.red,"#FD0202"))
            add(ColorModel(7,R.color.blue,"#07A2F6"))
            add(ColorModel(8,R.color.green,"#06EF10"))
            add(ColorModel(9,R.color.turquoise,"#03C8B1"))
            add(ColorModel(10,R.color.violet,"#4D09F1"))
            add(ColorModel(11,R.color.pink,"#F60A67"))
            add(ColorModel(12,R.color.peach,"#E39F5B"))
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fm=supportFragmentManager
       loadFrag(MainFragment(),true)
        binding.downloadIndicator.visibility= View.INVISIBLE
        binding.profileIndicator.visibility= View.INVISIBLE
        binding.homeIcon.drawable.setTint(Color.BLACK)
        binding.downloadIcon.drawable.setTint(Color.GRAY)
        binding.profileIcon.drawable.setTint(Color.GRAY)
        binding.btnDownload.setOnClickListener {
            binding.homeIndicator.visibility= View.INVISIBLE
            binding.profileIndicator.visibility= View.INVISIBLE
            binding.homeIcon.drawable.setTint(Color.GRAY)
            binding.profileIcon.drawable.setTint(Color.GRAY)
            binding.downloadIndicator.visibility=View.VISIBLE
            binding.downloadIcon.drawable.setTint(Color.BLACK)
            loadFrag(DownloadFragment(),false)
        }
        binding.btnHome.setOnClickListener {
            loadFrag(MainFragment(),true)
            binding.downloadIndicator.visibility= View.INVISIBLE
            binding.profileIndicator.visibility= View.INVISIBLE
            binding.homeIndicator.visibility=View.VISIBLE
            binding.downloadIcon.drawable.setTint(Color.GRAY)
            binding.profileIcon.drawable.setTint(Color.GRAY)
            binding.homeIcon.drawable.setTint(Color.BLACK)
        }
        binding.btnProfile.setOnClickListener {
            loadFrag(ProfileFragment(),false)
            binding.downloadIndicator.visibility= View.INVISIBLE
            binding.homeIndicator.visibility= View.INVISIBLE
            binding.profileIndicator.visibility=View.VISIBLE
            binding.homeIcon.drawable.setTint(Color.GRAY)
            binding.downloadIcon.drawable.setTint(Color.GRAY)
            binding.profileIcon.drawable.setTint(Color.BLACK)
        }

    }
    fun loadFrag(fragment: Fragment,isHome:Boolean){
        val ft=fm.beginTransaction()
        if (check){
            ft.add(R.id.container,fragment)
            ft.addToBackStack("home")
        }
        else {
            ft.replace(R.id.container, fragment)
            if (isHome) {
                fm.popBackStack("home", FragmentManager.POP_BACK_STACK_INCLUSIVE)
                ft.addToBackStack("home")
            } else {

                ft.addToBackStack(null)
            }
        }
        ft.commit()
    }

    override fun onBackPressed() {
        if (fm.backStackEntryCount==1){
          finish()
        }
        else{
            loadFrag(MainFragment(),true)
            binding.homeIndicator.visibility=View.VISIBLE
            binding.downloadIndicator.visibility= View.INVISIBLE
            binding.profileIndicator.visibility= View.INVISIBLE
            binding.homeIcon.drawable.setTint(Color.BLACK)
            binding.downloadIcon.drawable.setTint(Color.GRAY)
            binding.profileIcon.drawable.setTint(Color.GRAY)
        }
    }

}

