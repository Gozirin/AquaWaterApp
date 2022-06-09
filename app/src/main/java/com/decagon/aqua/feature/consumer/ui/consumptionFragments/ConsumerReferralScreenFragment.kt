package com.decagon.aqua.feature.consumer.ui.consumptionFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentConsumerReferralScreenBinding

class ConsumerReferralScreenFragment : Fragment() {

    private lateinit var binding: FragmentConsumerReferralScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_consumer_referral_screen, container, false)
        return binding.rootView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // initializing view binding
        binding = FragmentConsumerReferralScreenBinding.bind(view)

        // Back button to return to Change Password page
        binding.consumerReferralScreenImageButton1.setOnClickListener {
            findNavController().navigate(R.id.action_consumer_Referral_Screen_Fragment_to_consumer_Change_Password_Screen_Fragment)
        }
    }
}
