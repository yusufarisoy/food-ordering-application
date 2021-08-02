package com.kodluyoruz.yahnifood.ui.profile

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kodluyoruz.yahnifood.ui.order_history.OrderHistoryFragment
import com.kodluyoruz.yahnifood.ui.address_list.AddressListFragment

private const val FRAGMENT_COUNT = 2

class ProfileViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = FRAGMENT_COUNT

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> OrderHistoryFragment()
            1 -> AddressListFragment()
            else -> AddressListFragment()
        }
    }

}