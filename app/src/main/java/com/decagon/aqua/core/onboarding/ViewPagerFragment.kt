package com.decagon.aqua.core.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.decagon.aqua.R
import com.decagon.aqua.core.onboarding.screens.FirstOnboardingScreenFragment
import com.decagon.aqua.core.onboarding.screens.SecondOnboardingScreenFragment
import com.decagon.aqua.core.onboarding.screens.ThirdOnboardingScreenFragment
import com.decagon.aqua.databinding.FragmentViewPagerBinding

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
