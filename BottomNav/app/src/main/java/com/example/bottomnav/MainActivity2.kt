package com.example.bottomnav

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bottomnav.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var bottomNavView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        bottomNavView =
            findViewById(R.id.bottom_nav) //val BottomNavview: bottmNavView = findviewbyId(R.id....)//val bottmNavView = findviewbyId<BottomNavView>(R.id....)
        //val frameMain = findViewByID<FrameLayout>(R.id.frame_main);
        //xử lý sk
        bottomNavView.setOnItemSelectedListener(
            R.id.menu_item_running
        )
        run {
            Toast.makeText(this, "running", Toast.LENGTH_SHORT.show())
            true
        }
        R.id.menu_item_cycling
        run {
            Toast.makeText(this, "running", Toast.LENGTH_SHORT.show())
            true
        }
    }
}