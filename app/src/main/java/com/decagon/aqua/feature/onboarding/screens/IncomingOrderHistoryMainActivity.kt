package com.decagon.aqua.feature.onboarding.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.decagon.aqua.R
import com.decagon.aqua.databinding.IncomingOrderHistoryMainActivityBinding
import com.example.tablayout.Adapter
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayoutMediator

class IncomingOrderHistoryMainActivity : AppCompatActivity() {

    private lateinit var binding: IncomingOrderHistoryMainActivityBinding

    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController
    lateinit var navHostFragment: NavHostFragment

    var count = 8
    val Tab = arrayOf("Incoming order", "Order history")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = IncomingOrderHistoryMainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pager = binding.consumerIncomingOderViewPager
        val t1 = binding.consumerIncomingOrderTabLayout

        pager.adapter = Adapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(t1, pager) { tab, position ->
            if (position < 1) {
                val badgeDrawable: BadgeDrawable = tab.orCreateBadge
                badgeDrawable.backgroundColor = ContextCompat.getColor(applicationContext, R.color.all_text_color)
                badgeDrawable.isVisible = true
                badgeDrawable.number = count
            }
            tab.text = Tab[position]
        }.attach()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
