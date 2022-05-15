package com.decagon.aqua.feature.supplier

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.decagon.aqua.R
import com.decagon.aqua.databinding.ActivitySupplierMainBinding

class SupplierMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySupplierMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySupplierMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = binding.supplierActivityBtmNav
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.supplier_activity_fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}
