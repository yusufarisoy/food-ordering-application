package com.kodluyoruz.yahnifood.ui.address_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodluyoruz.yahnifood.databinding.AddressListFragmentBinding
import com.kodluyoruz.yahnifood.service.RetrofitHelper
import com.kodluyoruz.yahnifood.ui.base.BaseFragment
import com.kodluyoruz.yahnifood.ui.restaurant_detail.RestaurantDetailFragmentDirections

class AddressListFragment : BaseFragment() {
    private lateinit var binding: AddressListFragmentBinding
    private val adapter = AddressListAdapter()
    private val viewModel: AddressListViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = AddressListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initViews()
        setData()
    }

    private fun initViews() {

        binding.addressListRV.layoutManager = LinearLayoutManager(context)
        binding.addressListRV.adapter = adapter

    }


    private fun setData() {
        viewModel.userAddressList.observe(viewLifecycleOwner, {
           adapter.setDataset(it)
        })


    }

}