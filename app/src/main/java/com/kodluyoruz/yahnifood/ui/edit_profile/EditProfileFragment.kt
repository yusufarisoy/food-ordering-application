package com.kodluyoruz.yahnifood.ui.edit_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kodluyoruz.yahnifood.databinding.FragmentEditProfileBinding
import com.kodluyoruz.yahnifood.ui.base.BaseFragment

class EditProfileFragment : BaseFragment() {

    private lateinit var binding: FragmentEditProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }
    private fun initViews() {

        binding.buttonChangePasswordNavigation.setOnClickListener {
            findNavController().navigate(EditProfileFragmentDirections.actionEditProfileFragment2ToChangePasswordFragment())
        }
        binding.buttonUpdateProfile.setOnClickListener {
            findNavController().navigate(EditProfileFragmentDirections.actionEditProfileFragment2ToProfileFragment2())
        }
    }
}