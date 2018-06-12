package com.twixt.pranav.infared.view.Fragment.Tab

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.twixt.pranav.infared.view.Activity.Search
import com.twixt.pranav.infared.view.Adapter.AdapterRvHomeVenues
import com.twixt.pranav.infared.R
import android.support.v7.widget.PagerSnapHelper


/**
 * Created by Pranav on 11/9/2017.
 */
class HomeTabVenues : Fragment() {

    internal lateinit var tablayout: TabLayout
    lateinit var filter: ImageView
    lateinit var search: ImageView
    lateinit var drawer: DrawerLayout
    lateinit var rv_home: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mView = inflater.inflate(R.layout.home_tab_venues, container, false)

        filter = mView.findViewById(R.id.filter)
        search = mView.findViewById(R.id.search)
        drawer = mView.findViewById(R.id.drawer)
        rv_home = mView.findViewById(R.id.rv_home)
        tablayout = mView.findViewById(R.id.button_bar)

        tablayout.addTab(tablayout.newTab().setText("All"))
        tablayout.addTab(tablayout.newTab().setText("Bars"))
        tablayout.addTab(tablayout.newTab().setText("clubs"))
        tablayout.addTab(tablayout.newTab().setText("Hookahs"))
        tablayout.addTab(tablayout.newTab().setText("Lounges"))
        tablayout.setSelectedTabIndicatorColor(ContextCompat.getColor(activity!!, R.color.background_black))
        tablayout.setTabTextColors(ContextCompat.getColor(activity!!, R.color.text_white), ContextCompat.getColor(activity!!, R.color.colorPrimary))

        val adapterRvHome = AdapterRvHomeVenues(activity!!)
        val snapHelper = PagerSnapHelper()
        rv_home.adapter = adapterRvHome
        snapHelper.attachToRecyclerView(rv_home)
        rv_home.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        filter.setOnClickListener(View.OnClickListener {
            drawer.openDrawer(Gravity.LEFT)
        })
        search.setOnClickListener(View.OnClickListener {
            startActivity(Intent(activity, Search::class.java))
        })
        return mView
    }
}