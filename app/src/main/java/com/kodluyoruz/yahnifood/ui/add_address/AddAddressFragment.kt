package com.kodluyoruz.yahnifood.ui.add_address

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kodluyoruz.yahnifood.data.entity.Address
import com.kodluyoruz.yahnifood.data.entity.UsersItem
import com.kodluyoruz.yahnifood.databinding.AddressListFragmentBinding
import com.kodluyoruz.yahnifood.databinding.FragmentAddAddressBinding
import com.kodluyoruz.yahnifood.databinding.FragmentEditProfileBinding
import com.kodluyoruz.yahnifood.ui.base.BaseFragment
import com.kodluyoruz.yahnifood.ui.edit_profile.EditProfileViewModel
import com.kodluyoruz.yahnifood.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddAddressFragment : BaseFragment() {

    private val viewModel: AddAddressViewModel by viewModels()
    private  var token = -1
    private lateinit var binding: FragmentAddAddressBinding
    private lateinit var buttonAddAddress: Button
    private lateinit var user: UsersItem

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddAddressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getCurrentUser()
        buttonAddAddress = binding.buttonAddAddress
        buttonAddAddress.setOnClickListener{
            addAddress()
        }

    }
    fun getCurrentUser(){
        token = viewModel.getToken()
        viewModel.getUserWithId(token).observe(viewLifecycleOwner,{
            when(it.status){

                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    user = it.data!![0]
                }
                Resource.Status.ERROR -> {

                }
            }
        })
    }
    private fun addAddress(){
        var title = binding.textInputEditTextAddressTitle.text.toString()
        var district = binding.textInputEditTextAddressDistrict.text.toString()
        var addressDetail = binding.textInputEditTextAddressDetail.text.toString()
        user.address?.add(Address(title,"",addressDetail,district,"",""))
        viewModel.postAddress(token.toString(),user).observe(viewLifecycleOwner,{
            when(it.status){
                Resource.Status.SUCCESS ->{
                    Toast.makeText(requireContext(),"You added the address succesfully",Toast.LENGTH_SHORT).show()
                    findNavController().navigateUp()
                }
            }
        })
    }
}