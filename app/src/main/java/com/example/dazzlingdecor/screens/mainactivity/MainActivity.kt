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

