package com.decagon.aqua.feature.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.decagon.aqua.R
import com.decagon.aqua.databinding.ActivityOnboardingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Aqua)
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
    }
}
