package com.kodluyoruz.yahnifood.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.kodluyoruz.yahnifood.R
import com.kodluyoruz.yahnifood.databinding.FragmentMainOnBoardingBinding
import com.kodluyoruz.yahnifood.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainOnBoardingFragment : BaseFragment() {

    private lateinit var binding: FragmentMainOnBoardingBinding
    private lateinit var fragmentList: ArrayList<Fragment>
    private val layoutParamsActive = LinearLayout.LayoutParams(80, 15)
    private val layoutParamsInactive = LinearLayout.LayoutParams(55, 15)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initIndicators()
        initListeners()
    }

    private fun initViews() {
        fragmentList = arrayListOf(
            OnBoardingFragment1(),
            OnBoardingFragment2(),
            OnBoardingFragment3()
        )
        binding.viewPager.adapter = OnBoardingViewPagerAdapter(activity as AppCompatActivity, fragmentList)
        layoutParamsActive.marginEnd = 8
        layoutParamsInactive.marginEnd = 8
    }

    private fun initIndicators() {
        for (i in 0 until fragmentList.size) {
            val indicator = View(activity)
            when(i) {
                0 -> {
                    indicator.background = ResourcesCompat.getDrawable(resources, R.drawable.viewpager_indicator_active, null)
                    indicator.layoutParams = layoutParamsActive
                }; else -> {
                    indicator.background = ResourcesCompat.getDrawable(resources, R.drawable.viewpager_indicator_inactive, null)
                    indicator.layoutParams = layoutParamsInactive
                }
            }
            binding.viewPagerIndicator.addView(indicator)
        }
    }

    private fun initListeners() {
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                handlePageChange(position)
                super.onPageSelected(position)
            }
        })

        binding.nextButton.setOnClickListener {
            if (binding.viewPager.currentItem + 1 < fragmentList.size) {
                binding.viewPager.currentItem += 1
            } else {
                findNavController().navigate(MainOnBoardingFragmentDirections.actionMainOnBoardingFragmentToHomeFragment())
            }
        }
    }

    private fun handlePageChange(position: Int) {
        for (i in 0 until fragmentList.size) {
            if (i == position) {
                binding.viewPagerIndicator.getChildAt(i).layoutParams = layoutParamsActive
                binding.viewPagerIndicator.getChildAt(i).background = ResourcesCompat.getDrawable(resources, R.drawable.viewpager_indicator_active, null)
            } else {
                binding.viewPagerIndicator.getChildAt(i).layoutParams = layoutParamsInactive
                binding.viewPagerIndicator.getChildAt(i).background = ResourcesCompat.getDrawable(resources, R.drawable.viewpager_indicator_inactive, null)
            }
        }
        when (position) {
            fragmentList.size - 2 -> {
                binding.nextButton.text = getString(R.string.button_next)
                binding.nextButton.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.teal_300))
            }; fragmentList.size - 1 -> {
                binding.nextButton.text = getString(R.string.button_start)
            binding.nextButton.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.light_red))
            }
        }
    }
}