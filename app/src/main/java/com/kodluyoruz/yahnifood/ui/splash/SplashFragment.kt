package com.kodluyoruz.yahnifood.ui.splash

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kodluyoruz.yahnifood.databinding.FragmentSplashBinding
import com.kodluyoruz.yahnifood.ui.base.BaseFragment

class SplashFragment : BaseFragment() {

    private lateinit var viewModel: SplashViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModelFactory = SplashViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(SplashViewModel::class.java)

        viewModel.handleNavigation()
        setObservers()
    }

    private fun setObservers() {
        viewModel.isFirstLaunch().observe(viewLifecycleOwner, {
            if (it != null) {
                when(it) {
                    true -> {
                        //TODO: Navigate to OnBoarding
                        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
                        Log.v("SplashFragment", "First Launch")
                        viewModel.saveFirstLaunch()
                    }
                    false -> findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
                }
                viewModel.navigationDone()
            }
        })
    }
}