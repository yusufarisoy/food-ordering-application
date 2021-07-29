package com.kodluyoruz.yahnifood.ui.address_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodluyoruz.yahnifood.databinding.AddressListFragmentBinding
import com.kodluyoruz.yahnifood.service.RetrofitHelper
import com.kodluyoruz.yahnifood.ui.base.BaseFragment

class AddressListFragment : BaseFragment() {
    private var retrofitHelper: RetrofitHelper? = null
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
        fetchData()
    }

    private fun initViews() {


        binding.addressListRV.layoutManager = LinearLayoutManager(context)
        binding.addressListRV.adapter = adapter

    }

    private fun fetchData() {

        //Addres listin çekilmesi

//        retrofitHelper?.getUsers(object : UsersResponseHandler {
//            override fun onError() {
//                Log.v("MainActivity", "Error :(")
//
//            }
//
//            override fun onResponse(response: RickAndMortyBaseResponse) {
//                Log.v("ListFragment", "onResponse")
//                adapter.setRickMortyData(response.characters)
//            }
//        })
    }

}