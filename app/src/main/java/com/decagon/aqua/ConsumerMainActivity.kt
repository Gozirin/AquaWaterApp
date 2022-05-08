package com.decagon.aqua

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.decagon.aqua.databinding.ActivityConsumerMainBinding

class ConsumerMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConsumerMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsumerMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = binding.consumerActivityBtmNav
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.consumer_activity_fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}
