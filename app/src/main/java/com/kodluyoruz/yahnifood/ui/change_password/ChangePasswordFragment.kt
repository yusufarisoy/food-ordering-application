package com.kodluyoruz.yahnifood.ui.change_password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kodluyoruz.yahnifood.databinding.FragmentChangePasswordBinding
import com.kodluyoruz.yahnifood.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChangePasswordFragment : BaseFragment() {

    private lateinit var binding: FragmentChangePasswordBinding
    private val viewModel: ChangePasswordViewModel by viewModels()

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

        binding.buttonUpdatePassword.setOnClickListener {
            //findNavController().navigate(ChangePasswordFragmentDirections.actionChangePasswordFragmentToEditProfileFragment2())
            findNavController().popBackStack()
        }
    }
}