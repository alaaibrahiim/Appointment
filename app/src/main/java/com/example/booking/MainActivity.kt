package com.example.booking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.booking.databinding.ActivityMainBinding


//Global references
lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {

//Back button
  //  private lateinit var appBarConfiguration: AppBarConfiguration
    //override fun onSupportNavigateUp(): Boolean {
      //  val navController =findNavController(R.id.nav_host_fragment_container)
        //return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    //}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//Back button
      //  val navController =findNavController(R.id.nav_host_fragment_container)
        //appBarConfiguration= AppBarConfiguration(navController.graph)
        //setupActionBarWithNavController(navController , appBarConfiguration)

    }
}