package com.decagon.aqua.feature.supplier

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.decagon.aqua.R
import com.decagon.aqua.databinding.ActivitySupplierMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SupplierMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySupplierMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Aqua)
        binding = ActivitySupplierMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = binding.supplierActivityBtmNav
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.supplier_activity_fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        navController.addOnDestinationChangedListener { _, nd: NavDestination, _ ->
            if (nd.id == R.id.supplierAccountPage || nd.id == R.id.supplierHomePage || nd.id == R.id.supplierOrdersPage) {
                bottomNavigationView.visibility = View.VISIBLE
            } else {
                bottomNavigationView.visibility = View.GONE
            }
        }
    }
}
