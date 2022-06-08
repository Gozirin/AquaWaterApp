package com.decagon.aqua.feature.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.decagon.aqua.databinding.FragmentViewPagerBinding
import com.decagon.aqua.feature.onboarding.adapters.ViewPagerAdapter
import com.decagon.aqua.feature.onboarding.screens.FirstOnboardingScreenFragment
import com.decagon.aqua.feature.onboarding.screens.SecondOnboardingScreenFragment
import com.decagon.aqua.feature.onboarding.screens.ThirdOnboardingScreenFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewPagerFragment : Fragment() {

    private var _binding: FragmentViewPagerBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        val view = binding.root
        val fragmentList = arrayListOf<Fragment>(
            FirstOnboardingScreenFragment(),
            SecondOnboardingScreenFragment(),
            ThirdOnboardingScreenFragment()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        binding.viewPager2.adapter = adapter
        return view
    }
}
