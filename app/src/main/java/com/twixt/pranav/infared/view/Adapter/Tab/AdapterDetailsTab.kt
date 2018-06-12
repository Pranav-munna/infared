package com.twixt.pranav.infared.view.Adapter.Tab

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.twixt.pranav.infared.view.Fragment.Tab.InfoTab
import com.twixt.pranav.infared.view.Fragment.Tab.RewardsTab

/**
 * Created by Pranav on 11/10/2017.
 */
class AdapterDetailsTab(fm: FragmentManager, var a:Int): FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {
                val info = InfoTab()
                return info
            }
            1 -> {
                val reward = RewardsTab()
                return reward
            }
        }
        return null
    }

    override fun getCount(): Int {
       return a
    }
}