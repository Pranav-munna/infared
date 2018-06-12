package com.twixt.pranav.infared.view.Fragment

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.twixt.pranav.infared.view.Adapter.AdapterRvSearch
import com.twixt.pranav.infared.R

/**
 * Created by Pranav on 11/10/2017.
 */
class FragmentSearch : Fragment() {
    lateinit var back: ImageView
    lateinit var rv_search_view: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val mView = inflater.inflate(R.layout.fragment_search, container, false)
        back = mView.findViewById(R.id.back)
        rv_search_view = mView.findViewById(R.id.rv_search_view)

        val adapterRvSearch = AdapterRvSearch(activity)
        rv_search_view.adapter = adapterRvSearch
        rv_search_view.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)

        back.setOnClickListener(View.OnClickListener {
            activity.finish()
        })
        return mView
    }
}