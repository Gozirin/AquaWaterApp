package com.decagon.aqua.feature.onboarding.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentFirstOnboardingScreenBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstOnboardingScreenFragment : Fragment() {

    private var _binding: FragmentFirstOnboardingScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFirstOnboardingScreenBinding.inflate(inflater, container, false)
        val view = binding.root
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager2)
        binding.btnNextOne.setOnClickListener {
            viewPager?.currentItem = 1
        }
        if (viewPager != null) {
            TabLayoutMediator(binding.pageIndicator, viewPager) { _, _ -> }.attach()
        }
        binding.tvSkip1.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_loggingFragment)
        }
        return view
    }
}
