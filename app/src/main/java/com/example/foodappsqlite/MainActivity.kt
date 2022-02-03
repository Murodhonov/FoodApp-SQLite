package com.example.foodappsqlite

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Color.TRANSPARENT
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import com.example.foodappsqlite.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    @SuppressLint("RtlHardcoded")
    fun open() {
        drawer_layout.openDrawer(Gravity.LEFT, true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            drawer_layout.setStatusBarBackgroundColor(getColor(android.R.color.transparent))
        }
    }

    fun setStatusBarColor(color: Int) {
        val w: Window = this.window
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            w.statusBarColor = color
        }
    }
}