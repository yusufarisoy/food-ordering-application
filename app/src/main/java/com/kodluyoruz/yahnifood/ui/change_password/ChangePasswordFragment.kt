package com.kodluyoruz.yahnifood.ui.change_password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kodluyoruz.yahnifood.databinding.FragmentChangePasswordBinding
import com.kodluyoruz.yahnifood.ui.base.BaseFragment


class ChangePasswordFragment : BaseFragment() {

    private lateinit var binding: FragmentChangePasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChangePasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }
    private fun initViews() {

        binding.buttonChangePassword.setOnClickListener {
            findNavController().navigate(ChangePasswordFragmentDirections.actionChangePasswordFragmentToEditProfileFragment2())
        }
    }
}