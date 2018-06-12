package com.twixt.pranav.infared.view.Fragment.Tab

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.twixt.pranav.infared.view.Activity.Search
import com.twixt.pranav.infared.view.Adapter.AdapterRvHomeRewards
import com.twixt.pranav.infared.R

/**
 * Created by Pranav on 11/9/2017.
 */
class HomeTabRewards : Fragment() {

    internal lateinit var tablayout: TabLayout
    lateinit var filter: ImageView
    lateinit var search: ImageView
    lateinit var drawer: DrawerLayout
    lateinit var rv_home_rewards: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mView = inflater.inflate(R.layout.home_tab_rewards, container, false)

        filter = mView.findViewById(R.id.filter)
        search = mView.findViewById(R.id.search)
        drawer = mView.findViewById(R.id.drawer)
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        rv_home_rewards = mView.findViewById(R.id.rv_home_rewards)
        tablayout = mView.findViewById(R.id.button_bar)

        tablayout.addTab(tablayout.newTab().setText("All"))
        tablayout.addTab(tablayout.newTab().setText("BOGO"))
        tablayout.addTab(tablayout.newTab().setText("iR Drink"))
        tablayout.addTab(tablayout.newTab().setText("Hookahs"))
        tablayout.addTab(tablayout.newTab().setText("My Reasf"))
        tablayout.addTab(tablayout.newTab().setText("Test"))
        tablayout.addTab(tablayout.newTab().setText("Test"))
        tablayout.setSelectedTabIndicatorColor(ContextCompat.getColor(activity!!, R.color.background_black))
        tablayout.setTabTextColors(ContextCompat.getColor(activity!!, R.color.text_white), ContextCompat.getColor(activity!!, R.color.colorPrimary))

        val adapterRvHomeRewards = AdapterRvHomeRewards(activity!!)
        val snapHelper = PagerSnapHelper()
        rv_home_rewards.adapter = adapterRvHomeRewards
        snapHelper.attachToRecyclerView(rv_home_rewards)
        rv_home_rewards.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        filter.setOnClickListener(View.OnClickListener {
            drawer.openDrawer(Gravity.LEFT)
        })
        search.setOnClickListener(View.OnClickListener {
            startActivity(Intent(activity, Search::class.java))
        })
        return mView
    }
}