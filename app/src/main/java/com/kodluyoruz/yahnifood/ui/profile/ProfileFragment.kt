package com.kodluyoruz.yahnifood.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.kodluyoruz.yahnifood.data.entity.UsersItem
import com.kodluyoruz.yahnifood.databinding.FragmentProfileBinding
import com.kodluyoruz.yahnifood.ui.base.BaseFragment
import com.kodluyoruz.yahnifood.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment() {

    private val viewModel: ProfileViewModel by viewModels()
    private lateinit var binding: FragmentProfileBinding
    private lateinit var viewPagerProfile: ViewPager2
    private lateinit var user: UsersItem
    private lateinit var nameTextView: TextView
    private lateinit var surnameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var buttonAddress: Button
    private lateinit var buttonOrderHistory: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initViewPager()
        fetchUserData()
    }

    private fun initViews() {
        //textviews
        nameTextView = binding.NameTextView
        surnameTextView = binding.SurnameTextView
        emailTextView = binding.EmailTextView

        //viewpager
        viewPagerProfile = binding.viewPagerProfile
        viewPagerProfile.adapter = ProfileViewPagerAdapter(activity as AppCompatActivity)

        //tab item
        buttonAddress = binding.buttonAddress
        buttonOrderHistory = binding.buttonOrderHistory
        buttonAddress.setOnClickListener{
            viewPagerProfile.setCurrentItem(0)
        }
        buttonOrderHistory.setOnClickListener{
            viewPagerProfile.setCurrentItem(1)
        }

        //profile button navigation
        binding.buttonEditProfile.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragment2ToEditProfileFragment2())
        }

        //logout button
        binding.buttonLogout.setOnClickListener {
            viewModel.logout()
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragment2ToHomeFragment())
        }
    }

    private fun fetchUserData() {
        val token = viewModel.getToken()
        viewModel.getUserWithId(token).observe(viewLifecycleOwner,{
            when(it.status){

                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    nameTextView.text = it.data?.get(0)?.name
                    surnameTextView.text = it.data?.get(0)?.surname
                    emailTextView.text = it.data?.get(0)?.email
                }
                Resource.Status.ERROR -> {

                }
            }
        })
    }

    private fun initViewPager() {
        val adapter = ProfileViewPagerAdapter(requireActivity())
        viewPagerProfile.adapter = adapter
    }

}
