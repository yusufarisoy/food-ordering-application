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
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class AddAddressFragment : BaseFragment() {

    private val viewModel: AddAddressViewModel by viewModels()
    private lateinit var binding: FragmentAddAddressBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddAddressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getCurrentUser()
        binding.buttonAddAddress.setOnClickListener{
            addAddress()
        }

    }

    private fun getCurrentUser(){
        viewModel.getUserWithId(viewModel.getToken()).observe(viewLifecycleOwner,{
            when(it.status){

                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    viewModel.setUser(it.data!![0])
                }
                Resource.Status.ERROR -> {

                }
            }
        })
    }

    private fun addAddress(){
        val title = binding.textInputEditTextAddressTitle.text.toString()
        val city = binding.textInputEditTextAddressCity.text.toString()
        val district = binding.textInputEditTextAddressDistrict.text.toString()
        val addressDetail = binding.textInputEditTextAddressDetail.text.toString()
        val dateFormat = SimpleDateFormat("dd/M/yyyy")
        val currentDate = dateFormat.format(Date())

        viewModel.getUser().observe(viewLifecycleOwner, { user ->
            user.address?.add(Address(title,currentDate, addressDetail, city, district, currentDate))

            viewModel.postAddress(viewModel.getToken().toString(), user).observe(viewLifecycleOwner,{
                when(it.status){
                    Resource.Status.LOADING -> {

                    }
                    Resource.Status.SUCCESS ->{
                        Toast.makeText(requireContext(),"You added the address succesfully",Toast.LENGTH_SHORT).show()
                        findNavController().popBackStack()
                    }
                    Resource.Status.ERROR -> {
                        Toast.makeText(context, "Error: ${it.message}", Toast.LENGTH_LONG).show()
                    }
                }
            })
        })
    }
}