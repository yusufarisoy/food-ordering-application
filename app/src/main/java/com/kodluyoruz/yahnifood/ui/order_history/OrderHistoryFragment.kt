package com.kodluyoruz.yahnifood.ui.order_history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodluyoruz.yahnifood.data.entity.OrderFood
import com.kodluyoruz.yahnifood.data.entity.OrdersItem
import com.kodluyoruz.yahnifood.data.entity.UsersItem
import com.kodluyoruz.yahnifood.databinding.AddressListFragmentBinding
import com.kodluyoruz.yahnifood.databinding.FragmentOrderHistoryBinding
import com.kodluyoruz.yahnifood.databinding.OrderHistoryItemBinding
import com.kodluyoruz.yahnifood.ui.base.BaseFragment
import com.kodluyoruz.yahnifood.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class OrderHistoryFragment: BaseFragment() {

    private lateinit var binding: FragmentOrderHistoryBinding
    private val adapter = OrderHistoryListAdapter()
    private val viewModel: OrderHistoryViewModel by viewModels()
    private lateinit var orders: OrdersItem

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.orderListRV.layoutManager = LinearLayoutManager(context)
        binding.orderListRV.adapter = adapter

        /*val token = viewModel.getToken()
        viewModel.getOrders(token).observe(viewLifecycleOwner,{

            when(it.status){

                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {

                    //it.data?.get(0)?.orders?.let { it1 -> adapter.setDataset(it1) }


                }
                Resource.Status.ERROR -> {

                }

            }

        })*/
    }
}