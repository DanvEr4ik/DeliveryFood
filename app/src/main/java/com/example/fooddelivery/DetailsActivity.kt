package com.example.fooddelivery

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fooddelivery.databinding.ActivityDetailsBinding
import com.example.fooddelivery.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodImage = intent.getIntExtra("foodImage",0)
        val foodName = intent.getStringExtra("foodName")

        binding.menuDFoodImage.setImageResource(foodImage)
        binding.menuDFoodName.text = foodName

        binding.backHome.setOnClickListener {
            finish()
        }

    }
}