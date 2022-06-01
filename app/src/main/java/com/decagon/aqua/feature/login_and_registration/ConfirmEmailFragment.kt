package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.decagon.aqua.databinding.FragmentConfirmEmailBinding
import com.decagon.aqua.feature.login_and_registration.viewmodels.AuthenticationViewModel
import com.decagon.aqua.models.supplierAuthModule.ConfirmEmailModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConfirmEmailFragment : Fragment() {

    private val args: ConfirmEmailFragmentArgs by navArgs()
    private lateinit var binding: FragmentConfirmEmailBinding
    private val viewModel: AuthenticationViewModel by viewModels()
    private lateinit var userInfo: ConfirmEmailModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentConfirmEmailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val email = args.email.toString()
        val token = args.token.toString()
        userInfo = ConfirmEmailModel(emailAddress = email, token = token)

        binding.confirmEmailFragmentConfirmEmailButton.setOnClickListener {
            viewModel.confirmEmail(userInfo)
            viewModel.registerResponse.observe(
                viewLifecycleOwner,
                Observer {
                    if (it.success) {
                        Log.d("VVV", "onViewCreated: ${it.data}, $userInfo")
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                        findNavController().navigate(ConfirmEmailFragmentDirections.actionConfirmEmailFragmentToSupplierLoginFragment())
                    }
                }
            )
        }
    }
}
