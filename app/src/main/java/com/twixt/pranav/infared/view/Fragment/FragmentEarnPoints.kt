package com.twixt.pranav.infared.view.Fragment

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import com.twixt.pranav.infared.view.Activity.Search
import com.twixt.pranav.infared.view.Activity.Survevy
import com.twixt.pranav.infared.view.Adapter.AdapterEarnPoints
import com.twixt.pranav.infared.R

/**
 * Created by Pranav on 11/14/2017.
 */
class FragmentEarnPoints : Fragment() {
    lateinit var back: ImageView
    lateinit var search: ImageView
    lateinit var survay: Button
    lateinit var rv_home: RecyclerView


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val mView = inflater!!.inflate(R.layout.fagment_earn_points, container, false)
        back = mView.findViewById(R.id.back)
        search = mView.findViewById(R.id.search)
        survay = mView.findViewById(R.id.survay)
        rv_home = mView.findViewById(R.id.rv_home)
        val adapterEarnPoints = AdapterEarnPoints(activity)
        val snapHelper = PagerSnapHelper()


        rv_home.adapter=adapterEarnPoints
        snapHelper.attachToRecyclerView(rv_home)
        rv_home.layoutManager= LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)

        survay.setOnClickListener(View.OnClickListener { startActivity(Intent(activity, Survevy::class.java)) })
        search.setOnClickListener(View.OnClickListener { startActivity(Intent(activity, Search::class.java)) })

        back.setOnClickListener(View.OnClickListener { activity.finish() })
        return mView
    }
}