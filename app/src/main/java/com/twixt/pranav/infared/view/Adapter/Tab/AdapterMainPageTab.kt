package com.twixt.pranav.infared.view.Adapter.Tab


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.twixt.pranav.infared.view.Fragment.Tab.HomeTabProfile
import com.twixt.pranav.infared.view.Fragment.Tab.HomeTabRewards
import com.twixt.pranav.infared.view.Fragment.Tab.HomeTabVenues

/**
 * Created by Pranav on 11/9/2017.
 */
class AdapterMainPageTab(fm: FragmentManager, internal var a: Int) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {
                val onetab = HomeTabVenues()
                return onetab
            }
        1 -> {
            val twotab = HomeTabRewards()
            return twotab
        }
        2 -> {
            val threetab = HomeTabProfile()
            return threetab
        }
        }
        return null
    }

    override fun getCount(): Int {
        return a
    }

}