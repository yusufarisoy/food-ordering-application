package com.kodluyoruz.yahnifood.ui.add_address

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.kodluyoruz.yahnifood.databinding.AddressListFragmentBinding
import com.kodluyoruz.yahnifood.databinding.FragmentAddAddressBinding
import com.kodluyoruz.yahnifood.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddAddressFragment : BaseFragment() {

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
            findNavController().navigate(AddAddressFragmentDirections.actionAddAddressFragmentToProfileFragment2())
        }

    }
}