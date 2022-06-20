package com.decagon.aqua.feature.consumer.ui.consumptionFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.decagon.aqua.R
import com.decagon.aqua.commons.Resource
import com.decagon.aqua.core.data.sharedpreference.Preference
import com.decagon.aqua.databinding.FragmentSuppliesDetailsBinding
import com.decagon.aqua.feature.consumer.adapters.ConsumerSupplyDetailsAdapter
import com.decagon.aqua.feature.login_and_registration.viewmodels.AuthenticationViewModel
import com.decagon.aqua.feature.login_and_registration.viewmodels.ProductByCompanyIDViewModel
import com.decagon.aqua.models.companyProductmodel.CompanyProductResponse
import com.decagon.aqua.models.companyProductmodel.ProductData
import com.decagon.aqua.models.supplierAuthModule.Data
import com.google.android.material.snackbar.Snackbar
import com.like.LikeButton
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class SuppliesDetailsFragment : Fragment() {

    private val TAG = "SupplyDetailsFragment"
    @Inject
    lateinit var preference: Preference
    private lateinit var binding: FragmentSuppliesDetailsBinding
    private lateinit var consumerSuppliesDetailAdapter: ConsumerSupplyDetailsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var likebtn: LikeButton
    private val companyIdViewModel: ProductByCompanyIDViewModel by viewModels()
    private val authViewModel: AuthenticationViewModel by viewModels()
    private var _products: MutableLiveData<Resource<Response<CompanyProductResponse>>> =
        MutableLiveData()
    private val args: SuppliesDetailsFragmentArgs by navArgs()
    private val companies = hashMapOf<String, String>()
    private var companyList: List<Data> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSuppliesDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        makeCompanyListCall()
        initView2()
//        getProfiles()
        binding.supplyDetailsContactSellerBtn.setOnClickListener {
            Toast.makeText(this.requireContext(), "Contact Seller", Toast.LENGTH_SHORT).show()
        }
        binding.supplyDetailsCartIcon.setOnClickListener {
            Toast.makeText(this.requireContext(), "Check Cart", Toast.LENGTH_SHORT).show()
        }
        binding.supplyDetailsBellIcon.setOnClickListener {
            Toast.makeText(this.requireContext(), "Check Notification", Toast.LENGTH_SHORT).show()
        }
        binding.supplyDetailsBackBtn.setOnClickListener {
            findNavController().navigate(R.id.action_suppliesDetailsFragment_to_consumerHomeFragment)
        }
        val products: LiveData<Resource<Response<CompanyProductResponse>>> = _products
    }

    private fun initView2() {
        recyclerView =
            requireView().findViewById<RecyclerView>(R.id.consumer_supply_details_recyclerView)
        consumerSuppliesDetailAdapter = ConsumerSupplyDetailsAdapter()
        recyclerView.adapter = consumerSuppliesDetailAdapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
    }

//    private fun getProfiles() {
//        newArrayList.add(
//            SupplyDetailsItem(
//                R.drawable.water_circle,
//                "Bottle Water Pack",
//                "N900",
//                "per/bottle",
//                9.0,
//                "(9)",
//                "in stock"
//            )
//        )
//        newArrayList.add(
//            SupplyDetailsItem(
//                R.drawable.water_circle,
//                "Bottle Water",
//                "N400",
//                "per/bottle",
//                7.0,
//                "(7.0)",
//                "out of stock"
//            )
//        )
//        newArrayList.add(
//            SupplyDetailsItem(
//                R.drawable.water_circle,
//                "Fountain Bottle Water",
//                "N800",
//                "per/bottle",
//                10.0,
//                "10",
//                "out of stock"
//            )
//        )
//        newArrayList.add(
//            SupplyDetailsItem(
//                R.drawable.water_circle,
//                "Eva Bottle Water",
//                "N750",
//                "per/bottle",
//                6.5,
//                "(6.5)",
//                "in stock"
//            )
//        )
//        newArrayList.add(
//            SupplyDetailsItem(
//                R.drawable.water_circle,
//                "Eva Bottle Water",
//                "N750",
//                "per/bottle",
//                6.5,
//                "(6.5)",
//                "in stock"
//            )
//        )
//        newArrayList.add(
//            SupplyDetailsItem(
//                R.drawable.water_circle,
//                "Eva Bottle Water",
//                "N750",
//                "per/bottle",
//                6.5,
//                "(6.5)",
//                "in stock"
//            )
//        )
//        newArrayList.add(
//            SupplyDetailsItem(
//                R.drawable.water_circle,
//                "Eva Bottle Water",
//                "N750",
//                "per/bottle",
//                6.5,
//                "(6.5)",
//                "in stock"
//            )
//        )
//        newArrayList.add(
//            SupplyDetailsItem(
//                R.drawable.water_circle,
//                "Eva Bottle Water",
//                "N750",
//                "per/bottle",
//                6.5,
//                "(6.5)",
//                "out of stock"
//            )
//        )
//    }

    fun renderListOfProducts(data: ArrayList<ProductData>) {
        consumerSuppliesDetailAdapter.setProducts(data)
    }

    fun observeCompanyIdResponse() {
        val compName = args.companyName
        Log.d(TAG, "args.companyName = ${args.companyName}")
        var compId = ""
        for (entry in companies) {
            if (entry.key == compName) {
                compId = entry.value
            }
        }
        // "2e714c3a-06c8-46b5-ba8e-06c9c66e223"
        companyIdViewModel.getCompaniesWithProducts(compId, "Bearer ${preference.getToken()}")
        companyIdViewModel.products.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    response.data.let { products ->
                        Log.d("TAG", "getAllCompaniesWithProducts: ${products?.pageItems} ")
                        renderListOfProducts(products?.pageItems as ArrayList<ProductData>)
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
                }
                is Resource.Error -> {
                    response.message.let {
                        Snackbar.make(
                            requireView(),
                            response.message.toString(),
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                }
                is Resource.Loading -> {
                    Snackbar.make(requireView(), "Loading!!!!", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun makeCompanyListCall() {
        authViewModel.getCompanies()
        authViewModel.companyList.observe(requireActivity()) {
            when (it) {
                is Resource.Success -> {
                    companyList = it.data?.data!!
                }
            }
            companyList.map {
                companies.put(it.companyName, it.id)
            }
            Log.d("TAG", "hash map of companies is: $companies")
            observeCompanyIdResponse()
        }
    }
}
