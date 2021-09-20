package com.example.booking
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.booking.databinding.ActivityMainBinding


//Global references
lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var backPressedTime=0L


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
            finish()
        } else{
            super.onBackPressed()
            Toast.makeText(this, "Press back again to exit app", Toast.LENGTH_SHORT).show()
        }
        backPressedTime=System.currentTimeMillis()
    }
}
