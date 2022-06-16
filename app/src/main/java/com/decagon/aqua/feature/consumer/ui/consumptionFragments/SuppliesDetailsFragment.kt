package com.decagon.aqua.feature.consumer.ui.consumptionFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.decagon.aqua.R
import com.decagon.aqua.commons.Resource
import com.decagon.aqua.databinding.FragmentSuppliesDetailsBinding
import com.decagon.aqua.feature.consumer.adapters.ConsumerSupplyDetailsAdapter
import com.decagon.aqua.models.SupplyDetailsItem
import com.decagon.aqua.models.companyProductmodel.CompanyProductResponse
import com.like.LikeButton
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Response

@AndroidEntryPoint
class SuppliesDetailsFragment : Fragment() {

    private val TAG = "SupplyDetailsFragment"
    private lateinit var binding: FragmentSuppliesDetailsBinding
    private lateinit var newArrayList: ArrayList<SupplyDetailsItem>
    private lateinit var consumerSuppliesDetailAdapter: ConsumerSupplyDetailsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var likebtn: LikeButton
//    private var companyIdViewModel: ProductByCompanyIDViewModel by viewModels()
    private var _products: MutableLiveData<Resource<Response<CompanyProductResponse>>> = MutableLiveData()

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
        initView2()
        getProfiles()
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
//        lifecycleScope.launchWhenCreated {
//            val response = try {
//                AppModule.provideAquaApi().getProductsByCompanyID()
//            } catch (e: IOException) {
//                Toast.makeText(context, "Error encountered while loading", Toast.LENGTH_SHORT).show()
//                return@launchWhenCreated
//            } catch (e: HttpException) {
//                Toast.makeText(context, "Error encountered while loading", Toast.LENGTH_SHORT).show()
//                return@launchWhenCreated
//            }
//            if(response.isSuccessful && response.body() != null){
//                consumerSuppliesDetailAdapter.
//            }
//        }
    }

    private fun initView2() {
        recyclerView = requireView().findViewById<RecyclerView>(R.id.consumer_supply_details_recyclerView)
        newArrayList = ArrayList()
        consumerSuppliesDetailAdapter = ConsumerSupplyDetailsAdapter(newArrayList)
        recyclerView.adapter = consumerSuppliesDetailAdapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
    }
    private fun getProfiles() {
        newArrayList.add(SupplyDetailsItem(R.drawable.water_circle, "Bottle Water Pack", "N900", "per/bottle", 9.0, "(9)", "in stock"))
        newArrayList.add(SupplyDetailsItem(R.drawable.water_circle, "Bottle Water", "N400", "per/bottle", 7.0, "(7.0)", "out of stock"))
        newArrayList.add(SupplyDetailsItem(R.drawable.water_circle, "Fountain Bottle Water", "N800", "per/bottle", 10.0, "10", "out of stock"))
        newArrayList.add(SupplyDetailsItem(R.drawable.water_circle, "Eva Bottle Water", "N750", "per/bottle", 6.5, "(6.5)", "in stock"))
        newArrayList.add(SupplyDetailsItem(R.drawable.water_circle, "Eva Bottle Water", "N750", "per/bottle", 6.5, "(6.5)", "in stock"))
        newArrayList.add(SupplyDetailsItem(R.drawable.water_circle, "Eva Bottle Water", "N750", "per/bottle", 6.5, "(6.5)", "in stock"))
        newArrayList.add(SupplyDetailsItem(R.drawable.water_circle, "Eva Bottle Water", "N750", "per/bottle", 6.5, "(6.5)", "in stock"))
        newArrayList.add(SupplyDetailsItem(R.drawable.water_circle, "Eva Bottle Water", "N750", "per/bottle", 6.5, "(6.5)", "out of stock"))
    }

    fun observeCompanyIdResponse() {
//        companyIdViewModel.products.observe(
//            viewLifecycleOwner
//        )
        //        {
//            when (it) {
//                is Resource.Success -> {
//                    Log.d("Login-succeed", it.message.toString())
// //                    binding.consumerLoginProgressBar.visibility = View.GONE
// //                    findNavController().navigate(R.id.action_loginFragment_to_consumer_mainActivity)
// //                    binding.consumerLoginLayoutLoginButton.text = "Login"
//                }
//                is Resource.Error -> {
// //                    binding.consumerLoginProgressBar.visibility = View.GONE
// //                    Toast.makeText(requireContext(), it.message.toString(), Toast.LENGTH_SHORT).show()
// ////                    errorMsg.text = it.message.toString()
// //                    Log.d("Login400: ", it.data?.errors.toString())
//                    Log.d("Login400: ", it.message.toString())
// //                    binding.consumerLoginLayoutLoginButton.text = "Login"
//                }
//                is Resource.Loading -> {
// //                    binding.consumerLoginProgressBar.visibility = View.VISIBLE
//                }
    }
}
//    }
// }
