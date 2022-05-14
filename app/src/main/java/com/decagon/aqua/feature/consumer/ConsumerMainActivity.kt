package com.decagon.aqua.feature.consumer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.decagon.aqua.R
import com.decagon.aqua.databinding.ConsumerMainActivityBinding

class ConsumerMainActivity : AppCompatActivity() {

    private lateinit var binding: ConsumerMainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ConsumerMainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = binding.consumerActivityBtmNav
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.consumer_activity_fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}
