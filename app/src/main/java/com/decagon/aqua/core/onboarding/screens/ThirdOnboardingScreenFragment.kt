package com.decagon.aqua.core.onboarding.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentThirdOnboardingScreenBinding
import com.google.android.material.tabs.TabLayoutMediator

class ThirdOnboardingScreenFragment : Fragment() {
    private var _binding: FragmentThirdOnboardingScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThirdOnboardingScreenBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnNextThree.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_loggingFragment)
            onBoardingFinished()
        }
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager2)
        if (viewPager != null) {
            TabLayoutMediator(binding.pageIndicator, viewPager) { _, _ -> }.attach()
        }
        return view
    }

    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }
}
