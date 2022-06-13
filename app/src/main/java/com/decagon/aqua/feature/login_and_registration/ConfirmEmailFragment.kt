package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.decagon.aqua.commons.Resource
import com.decagon.aqua.databinding.FragmentConfirmEmailBinding
import com.decagon.aqua.feature.login_and_registration.viewmodels.AuthenticationViewModel
import com.decagon.aqua.models.supplierAuthModule.ConfirmEmailModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConfirmEmailFragment : Fragment() {

//    private val args: ConfirmEmailFragmentArgs by navArgs()
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

//        val email = args.email.toString()
//        val token = args.token.toString()
//        userInfo = ConfirmEmailModel(emailAddress = email, token = token)

        binding.confirmEmailFragmentConfirmEmailButton.setOnClickListener {
            viewModel.confirmEmail(userInfo)
            viewModel.registerResponse.observe(requireActivity()) {
                when (it) {
                    is Resource.Success -> {
                        Snackbar.make(view, it.message.toString(), Snackbar.LENGTH_LONG).setAnchorView(binding.confirmEmailFragmentConfirmEmailButton).show()
//                        findNavController().navigate(ConfirmEmailFragmentDirections.actionConfirmEmailFragmentToSupplierLoginFragment())
                    }

                    is Resource.Error -> {
                        Snackbar.make(view, it.message.toString(), Snackbar.LENGTH_LONG).setAnchorView(binding.confirmEmailFragmentConfirmEmailButton).show()
                    }
                }
            }
        }
    }
}
