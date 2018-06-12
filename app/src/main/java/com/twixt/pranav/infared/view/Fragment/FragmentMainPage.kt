package com.twixt.pranav.infared.view.Fragment

import android.content.Context
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.twixt.pranav.infared.view.Adapter.Tab.AdapterMainPageTab
import com.twixt.pranav.infared.R

/**
 * Created by Pranav on 11/9/2017.
 */
class FragmentMainPage : Fragment(), TabLayout.OnTabSelectedListener {

    internal lateinit var tablayout: TabLayout
    internal lateinit var viewPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val mView = inflater.inflate(R.layout.fragment_main_page, container, false)

        tablayout = mView.findViewById(R.id.tablayout)
        viewPager = mView.findViewById(R.id.viewPager)

        tablayout.addTab(tablayout.newTab().setIcon(R.drawable.ic_home))
        tablayout.addTab(tablayout.newTab().setIcon(R.drawable.ic_points))
        tablayout.addTab(tablayout.newTab().setIcon(R.drawable.ic_profile))
        tablayout.setSelectedTabIndicatorColor(ContextCompat.getColor(activity!!,R.color.colorPrimary))

        when (tablayout.selectedTabPosition) {
            0 -> tablayout.getTabAt(0)!!.setIcon(R.drawable.ic_home_selected)
            1 -> tablayout.getTabAt(1)!!.setIcon(R.drawable.ic_points_selected)
            2 -> tablayout.getTabAt(2)!!.setIcon(R.drawable.ic_profile_selected)
        }


        val tabPagerAdapter = AdapterMainPageTab(fragmentManager!!, tablayout.tabCount)
        viewPager.adapter = tabPagerAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tablayout))

        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                when (tab!!.position) {
                    0 -> tablayout.getTabAt(0)!!.setIcon(R.drawable.ic_home_selected)
                    1 -> tablayout.getTabAt(1)!!.setIcon(R.drawable.ic_points_selected)
                    2 -> tablayout.getTabAt(2)!!.setIcon(R.drawable.ic_profile_selected)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                when (tab!!.position) {
                    0 -> tablayout.getTabAt(0)!!.setIcon(R.drawable.ic_home)
                    1 -> tablayout.getTabAt(1)!!.setIcon(R.drawable.ic_points)
                    2 -> tablayout.getTabAt(2)!!.setIcon(R.drawable.ic_profile)
                }
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.setCurrentItem(tab!!.position)
                when (tab!!.position) {
                    0 -> tablayout.getTabAt(0)!!.setIcon(R.drawable.ic_home_selected)
                    1 -> tablayout.getTabAt(1)!!.setIcon(R.drawable.ic_points_selected)
                    2 -> tablayout.getTabAt(2)!!.setIcon(R.drawable.ic_profile_selected)
                }
            }
        })

        return mView
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {}
    override fun onTabUnselected(tab: TabLayout.Tab?) {}
    override fun onTabSelected(tab: TabLayout.Tab?) {}
}