package com.example.grachi

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import com.google.android.material.navigation.NavigationView
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.*
import com.example.grachi.databinding.ActivityMenuBinding
import com.google.firebase.database.*


class MenuActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMenuBinding
    lateinit var db: FirebaseDatabase
    lateinit var table: DatabaseReference
    private val navController by lazy { findNavController(R.id.nav_host_fragment) }
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMenu.toolbar)
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val userID = intent.extras?.getString("userID")
       val monday = intent.extras?.getStringArrayList("monday")
        val tuesday = intent.extras?.getStringArrayList("tuesday")
        val wednesday = intent.extras?.getStringArrayList("wednesday")
        val thursday = intent.extras?.getStringArrayList("thursday")
        val friday = intent.extras?.getStringArrayList("friday")
        val saturday = intent.extras?.getStringArrayList("saturday")
        val teachersthings = intent.extras?.getStringArrayList("teachersthings")
        val teachersname = intent.extras?.getStringArrayList("teachersname")
        val marks = intent.extras?.getStringArrayList("marks")
        val nameArgmonday = NavArgument.Builder().setDefaultValue(monday).build()
        val nameArgtuesday = NavArgument.Builder().setDefaultValue(tuesday).build()
        val nameArgwednesday = NavArgument.Builder().setDefaultValue(wednesday).build()
        val nameArgthursday = NavArgument.Builder().setDefaultValue(thursday).build()
        val nameArgfriday = NavArgument.Builder().setDefaultValue(friday).build()
        val nameArgsaturday = NavArgument.Builder().setDefaultValue(saturday).build()
        val navInflater = navController.navInflater
        val navGraph = navInflater.inflate(R.navigation.mobile_navigation)
        navGraph.addArgument("monday", nameArgmonday);
        navGraph.addArgument("tuesday", nameArgtuesday);
        navGraph.addArgument("wednesday", nameArgwednesday);
        navGraph.addArgument("thursday", nameArgthursday);
        navGraph.addArgument("friday", nameArgfriday);
        navGraph.addArgument("saturday", nameArgsaturday);
        println(navGraph.arguments.values)
        navController.graph = navGraph;

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_timetable, R.id.nav_mark, R.id.nav_teacher
            ), drawerLayout
        )

navController.addOnDestinationChangedListener { controller, destination, arguments ->

    navController.graph.findNode(R.id.nav_timetable)?.addArgument(
        "monday", NavArgument.Builder()
            .setDefaultValue(monday)
            .build()
    )
    navController.graph.findNode(R.id.nav_timetable)?.addArgument(
        "tuesday", NavArgument.Builder()
            .setDefaultValue(tuesday)
            .build()
    )
    navController.graph.findNode(R.id.nav_timetable)?.addArgument(
        "wednesday", NavArgument.Builder()
            .setDefaultValue(wednesday)
            .build()
    )
    navController.graph.findNode(R.id.nav_timetable)?.addArgument(
        "thursday", NavArgument.Builder()
            .setDefaultValue(thursday)
            .build()
    )
    navController.graph.findNode(R.id.nav_timetable)?.addArgument(
        "friday", NavArgument.Builder()
            .setDefaultValue(friday)
            .build()
    )
    navController.graph.findNode(R.id.nav_timetable)?.addArgument(
        "saturday", NavArgument.Builder()
            .setDefaultValue(saturday)
            .build()
    )
    navController.graph.findNode(R.id.nav_teacher)?.addArgument(
        "teachersthings", NavArgument.Builder()
            .setDefaultValue(teachersthings)
            .build()
    )
    navController.graph.findNode(R.id.nav_teacher)?.addArgument(
        "teachersname", NavArgument.Builder()
            .setDefaultValue(teachersname)
            .build()
    )
    navController.graph.findNode(R.id.nav_mark)?.addArgument(
        "teachersthings", NavArgument.Builder()
            .setDefaultValue(teachersthings)
            .build()
    )
    navController.graph.findNode(R.id.nav_mark)?.addArgument(
        "marks", NavArgument.Builder()
            .setDefaultValue(marks)
            .build()
    )

}

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }





    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }




}