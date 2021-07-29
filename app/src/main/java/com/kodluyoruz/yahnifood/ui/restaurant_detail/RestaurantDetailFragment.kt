package com.kodluyoruz.yahnifood.ui.restaurant_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodluyoruz.yahnifood.IMealOnClick
import com.kodluyoruz.yahnifood.R
import com.kodluyoruz.yahnifood.databinding.FragmentRestaurantDetailBinding
import com.kodluyoruz.yahnifood.models.Menu
import com.kodluyoruz.yahnifood.ui.base.BaseFragment

class RestaurantDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentRestaurantDetailBinding
    private val adapter = FoodAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRestaurantDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModelFactory = RestaurantDetailViewModelFactory()
        val viewModel = ViewModelProvider(this, viewModelFactory).get(RestaurantDetailViewModel::class.java)

        initViews()
        fetchData()
    }

    private fun initViews() {
        val restaurant = RestaurantDetailFragmentArgs.fromBundle(requireArguments()).restaurant
        binding.textViewRestaurantName.text = restaurant.name
        val score = restaurant.point.toString() + "/5"
        binding.textViewRestaurantScore.text = score
        val address = restaurant.address.district + " " + restaurant.address.address
        binding.textViewRestaurantAddress.text = address
        val minPrice = restaurant.min_order.toString() + " TL"
        binding.textViewRestaurantMinDeliveryPrice.text = minPrice
        val avgDelivery = restaurant.average_delivery_time.toString() + "dk"
        binding.textViewRestaurantDeliveryTime.text = avgDelivery

        binding.recyclerViewFoodList.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewFoodList.adapter = adapter

    }

    private fun fetchData() {
        //TODO: Change with GET request from API
        val foodList = ArrayList<Menu>()
        for(i in 1..3) {
            foodList.add(Menu(i, "Lorem ipsum dolor sit amet.", "Hamburger", "https://www.burgerking.com.tr/cmsfiles/products/big-king-jr-menu-1.png?v=173", i * 10.15))
        }
        adapter.setDataset(foodList)
        adapter.addListener(object : IMealOnClick{
            override fun onClick(menu: Menu) {
                val action = RestaurantDetailFragmentDirections.actionRestaurantDetailFragmentToMealDetailFragment(menu)
                findNavController().navigate(action)
            }

        })
    }
}