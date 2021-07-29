package com.kodluyoruz.yahnifood.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kodluyoruz.yahnifood.databinding.FragmentHomeBinding
import com.kodluyoruz.yahnifood.models.Address
import com.kodluyoruz.yahnifood.models.Menu
import com.kodluyoruz.yahnifood.models.Owner
import com.kodluyoruz.yahnifood.models.RestaurantsItem
import com.kodluyoruz.yahnifood.ui.base.BaseFragment

class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        val list = emptyList<Menu>()

        binding.btnDetail.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToRestaurantDetailFragment(
                RestaurantsItem(Address("", "Sureyyaplaji", "Istanbul", "Maltepe", ""), 45, 1, "",
                    list, 25, "Burger King",
                    Owner("", "", "", "", ""), "4441423", 4, "")
            ))
        }
    }
}