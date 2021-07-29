package com.kodluyoruz.yahnifood.ui.restaurant_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodluyoruz.yahnifood.IMealOnClick
import com.kodluyoruz.yahnifood.databinding.FragmentRestaurantDetailBinding
import com.kodluyoruz.yahnifood.models.Menu
import com.kodluyoruz.yahnifood.ui.base.BaseFragment

class RestaurantDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentRestaurantDetailBinding
    private lateinit var viewModel: RestaurantDetailViewModel
    private val adapter = FoodAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRestaurantDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModelFactory = RestaurantDetailViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(RestaurantDetailViewModel::class.java)

        initViews()
        setObservers()
    }

    private fun initViews() {
        viewModel.setRestaurant(RestaurantDetailFragmentArgs.fromBundle(requireArguments()).restaurant)

        binding.recyclerViewFoodList.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewFoodList.adapter = adapter

        adapter.addListener(object : IMealOnClick{
            override fun onClick(menu: Menu) {
                viewModel.onMealClicked(menu)
            }
        })
    }

    private fun setObservers() {
        viewModel.getRestaurant().observe(viewLifecycleOwner, {
            binding.textViewRestaurantName.text = it.name
            val score = it.point.toString() + "/5"
            binding.textViewRestaurantScore.text = score
            val address = it.address.district + " " + it.address.address
            binding.textViewRestaurantAddress.text = address
            val minPrice = it.min_order.toString() + " TL"
            binding.textViewRestaurantMinDeliveryPrice.text = minPrice
            val avgDelivery = it.average_delivery_time.toString() + "dk"
            binding.textViewRestaurantDeliveryTime.text = avgDelivery

            viewModel.setFoodList(ArrayList(it.menu))
        })

        viewModel.getFoodList().observe(viewLifecycleOwner, {
            adapter.setDataset(it)
        })

        viewModel.getNavigateToMealDetail().observe(viewLifecycleOwner, {
            if (it != null) {
                val action = RestaurantDetailFragmentDirections.actionRestaurantDetailFragmentToMealDetailFragment(it)
                findNavController().navigate(action)
                viewModel.navigationToMealDetailDone()
            }
        })
    }
}