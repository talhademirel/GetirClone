package com.example.getirproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = (supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment).navController

        /*
        val appBarConfiguration = AppBarConfiguration(setOf(R.layout.category_list,R.layout.fragment_search,R.layout.fragment_settings))
        setupActionBarWithNavController(navController,appBarConfiguration)
        */

        bottomNavigationView.setupWithNavController(navController)



    }



}