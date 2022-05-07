package com.decagon.aqua

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.decagon.aqua.databinding.ActivityMainBinding
import com.decagon.aqua.features.consumer.authentication.CustomerLoginFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // initializing support fragment manager
        supportFragmentManager.beginTransaction().replace(R.id.nav_Container, CustomerLoginFragment())
            .commit()
    }
}
