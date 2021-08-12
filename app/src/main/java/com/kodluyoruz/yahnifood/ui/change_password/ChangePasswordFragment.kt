package com.kodluyoruz.yahnifood.ui.change_password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kodluyoruz.yahnifood.databinding.FragmentChangePasswordBinding
import com.kodluyoruz.yahnifood.ui.base.BaseFragment
import com.kodluyoruz.yahnifood.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChangePasswordFragment : BaseFragment() {

    private lateinit var binding: FragmentChangePasswordBinding
    private val viewModel: ChangePasswordViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChangePasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        fetchData()
    }

    private fun fetchData() {
        viewModel.setUser(ChangePasswordFragmentArgs.fromBundle(requireArguments()).user)
    }

    private fun initViews() {

        binding.buttonUpdatePassword.setOnClickListener {
            viewModel.getUser().observe(viewLifecycleOwner, { user ->

                if (binding.textInputEditCurrentPassword.text.toString() == user.password &&
                    binding.textInputEditTextNewPassword.text.toString() == binding.textInputEditTextConfirmNewPassword.text.toString()) {

                    viewModel.changePassword(user, binding.textInputEditTextNewPassword.text.toString()).observe(viewLifecycleOwner, {
                        when (it.status) {
                            Resource.Status.LOADING -> {

                            }
                            Resource.Status.SUCCESS -> {
                                Toast.makeText(context, "Password changed successfully", Toast.LENGTH_LONG).show()
                                findNavController().popBackStack()
                            }
                            Resource.Status.ERROR -> {

                            }
                        }
                    })
                } else {
                    Toast.makeText(context, "Wrong password", Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}