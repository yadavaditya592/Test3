package com.example.test3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navigationbutton=findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val drawer=findViewById<DrawerLayout>(R.id.drawermain)

        navigationbutton.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home->Changefragment(Home())
                R.id.profile->Changefragment(Profile())
                R.id.settigs->Changefragment(Setting())

            }
            drawer.close()
            true

        }


        Changefragment(Profile())

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home->{
                    Changefragment(Home())
                    drawer.close()
                }
                R.id.profile->Changefragment(Profile())
                R.id.settigs-> Changefragment(Setting())
            }
            true
        }
    }
    fun Changefragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.Frame_Layout,fragment).commit()
    }
}