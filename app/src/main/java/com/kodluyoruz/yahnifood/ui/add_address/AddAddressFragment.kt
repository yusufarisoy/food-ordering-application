package com.kodluyoruz.yahnifood.ui.add_address

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
    private lateinit var address: Address
    private lateinit var binding: FragmentAddAddressBinding
    private lateinit var buttonAddAddress: Button

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

        buttonAddAddress = binding.buttonAddAddress
        buttonAddAddress.setOnClickListener{
            //findNavController().navigate(AddAddressFragmentDirections.actionAddAddressFragmentToProfileFragment2())
            //addAddress()
            findNavController().popBackStack()
        }

    }
    private fun addAddress(){
        var title = binding.textInputEditTextAddressTitle
        var district = binding.textInputEditTextAddressDistrict
        var addressDetail = binding.textInputEditTextAddressDetail

        viewModel.postAddress(address).observe(viewLifecycleOwner,{
            when(it.status){

                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    it.data?.title = title.text.toString()
                }
                Resource.Status.ERROR -> {

                }
            }
        })
    }
}