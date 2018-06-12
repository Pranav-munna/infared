package com.twixt.pranav.infared.view.Fragment


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.twixt.pranav.infared.view.Adapter.Tab.AdapterDetailsTab
import com.twixt.pranav.infared.R

/**
 * Created by Pranav on 11/10/2017.
 */
class FrgmentDetailsRewards : Fragment(), TabLayout.OnTabSelectedListener {


    lateinit var back: ImageView
    internal lateinit var tablayout: TabLayout
    internal lateinit var viewPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val mView = inflater!!.inflate(R.layout.frgment_details_rewards, container, false)
        back = mView.findViewById(R.id.back)
        tablayout = mView.findViewById(R.id.tablayout)
        viewPager = mView.findViewById(R.id.viewPager)

        tablayout.addTab(tablayout.newTab().setText("Info"))
        tablayout.addTab(tablayout.newTab().setText("Rewards"))
        tablayout.setSelectedTabIndicatorColor(ContextCompat.getColor(activity!!, R.color.colorPrimary))
        tablayout.setTabTextColors(ContextCompat.getColor(activity!!,R.color.text_white),ContextCompat.getColor(activity!!,R.color.colorPrimary))

        val  tabAdapterDetails = AdapterDetailsTab(fragmentManager!!, tablayout.tabCount)
        viewPager.adapter = tabAdapterDetails
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tablayout))

        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.setCurrentItem(tab!!.position)
            }
        })

        back.setOnClickListener(View.OnClickListener { activity!!.finish() })
        return mView
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {}
    override fun onTabUnselected(tab: TabLayout.Tab?) {}
    override fun onTabSelected(tab: TabLayout.Tab?) {}
}