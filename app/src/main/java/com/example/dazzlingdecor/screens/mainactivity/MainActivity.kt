package com.example.dazzlingdecor.screens.mainactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.dazzlingdecor.R
import com.example.dazzlingdecor.adapter.RecyclerViewCategoriesWallpaper
import com.example.dazzlingdecor.apihelper.ApiHelper
import com.example.dazzlingdecor.databinding.ActivityMainBinding
import com.example.dazzlingdecor.fragment.DownloadFragment
import com.example.dazzlingdecor.fragment.ProfileFragment
import com.example.dazzlingdecor.fragment.mainfragment.MainFragment
import com.example.dazzlingdecor.model.ColorModel
import com.example.dazzlingdecor.model.DataModel
import com.example.dazzlingdecor.model.PhotosModel
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        binding.bottomNavBar.setOnItemSelectedListener(object :NavigationBarView.OnItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                if (item.itemId==R.id.menu_dashboard){
                    loadFrag(MainFragment())
           /*  val mainFrag=MainFragment()
                    val bundle=Bundle()
                    bundle.putInt("pos",coloIdVar)
                    mainFrag.arguments=bundle
                    loadFrag(mainFrag)*/
                }
                else if (item.itemId==R.id.menu_download){
                    loadFrag(DownloadFragment())
                }
                else if (item.itemId==R.id.menu_profile){
                    loadFrag(ProfileFragment())
                }
                return true
            }

        })
        binding.bottomNavBar.selectedItemId=R.id.menu_dashboard

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

