package com.kodluyoruz.yahnifood.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kodluyoruz.yahnifood.databinding.FragmentProfileBinding
import com.kodluyoruz.yahnifood.ui.base.BaseFragment


class ProfileFragment : BaseFragment() {

    private lateinit var binding: FragmentProfileBinding


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
    }

    private fun initViews() {

        binding.buttonEditProfile.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragment2ToEditProfileFragment2())
        }
    }

}