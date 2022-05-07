package com.decagon.aqua

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.decagon.aqua.databinding.ActivitySupplierMainBinding
import com.decagon.aqua.feature.supplier.dashboard.account_screen.SupplierAccountPage
import com.decagon.aqua.feature.supplier.dashboard.home_screen.SupplierHomePage
import com.decagon.aqua.feature.supplier.dashboard.order_screen.SupplierOrdersPage

class SupplierMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySupplierMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySupplierMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * to declare and initialise all fragments for the homepage bottom menu
         */
        val supplierHomePageFragment = SupplierHomePage()
        val supplierOrdersFragment = SupplierOrdersPage()
        val supplierAccountFragment = SupplierAccountPage()

        /**
         * to set default fragment
         */
        setCurrentFragment(supplierHomePageFragment)

        /**
         * to switch between fragments
         */
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.supplier_homepage_bottom_nav_menu_home -> setCurrentFragment(supplierHomePageFragment)
                R.id.supplier_homepage_bottom_nav_menu_order -> setCurrentFragment(supplierOrdersFragment)
                R.id.supplier_homepage_bottom_nav_menu_account -> setCurrentFragment(supplierAccountFragment)
            }
            true
        }
    }

    /**
     * to set the selected fragment
     */
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.supplier_homepage_frame_layout, fragment)
            addToBackStack("null")
            commit()
        }
}
