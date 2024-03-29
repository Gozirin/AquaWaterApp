package com.decagon.aqua.feature.login_and_registration

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentConsumerCheckMailBinding

class ConsumerCheckMailFragment : Fragment() {
    private lateinit var binding: FragmentConsumerCheckMailBinding
    private val args by navArgs<ConsumerCheckMailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_consumer_check_mail, container, false)
        return binding.rootView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // initializing view binding
        binding = FragmentConsumerCheckMailBinding.bind(view)

        // Try another email if message not received or check spam filter.

        // navigate to consumer create new password page
        binding.consumerCheckMailButton.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_MAIN)
                intent.addCategory(Intent.CATEGORY_APP_EMAIL)
                this.startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(
                    requireContext(),
                    "There is no email client installed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
