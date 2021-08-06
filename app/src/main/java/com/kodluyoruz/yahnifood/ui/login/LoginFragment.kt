package com.kodluyoruz.yahnifood.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kodluyoruz.yahnifood.R
import com.kodluyoruz.yahnifood.databinding.FragmentLoginBinding
import com.kodluyoruz.yahnifood.ui.base.BaseFragment
import com.kodluyoruz.yahnifood.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment() {

    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        binding.buttonLogin.setOnClickListener {
            val email = binding.textInputEditTextEmail.text.toString()
            val password = binding.textInputEditTextPassword.text.toString()

            if (viewModel.loginControl(email, password)) {
                viewModel.login(email, password).observe(viewLifecycleOwner, {
                    when (it.status) {
                        Resource.Status.LOADING -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }
                        Resource.Status.SUCCESS -> {
                            binding.progressBar.visibility = View.GONE
                            if(it.data?.size == 0) {
                                Toast.makeText(context, "Kullanici adi veya sifre yanlis", Toast.LENGTH_LONG).show()
                            } else {
                                it.data?.get(0)?.let { user ->
                                    viewModel.saveToken(user.id)
                                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSplashFragment())
                                }
                            }
                        }
                        Resource.Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Sunucu Hatasi: ${it.message}", Toast.LENGTH_LONG).show()
                        }
                    }
                })
            }
        }

        binding.buttonToRegister.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
    }
}