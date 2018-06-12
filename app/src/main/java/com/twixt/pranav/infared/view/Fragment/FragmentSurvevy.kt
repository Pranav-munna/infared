package com.twixt.pranav.infared.view.Fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.twixt.pranav.infared.R

/**
 * Created by Pranav on 11/14/2017.
 */
class FragmentSurvevy : Fragment() {

    lateinit var back: ImageView
    lateinit var select_dec: ImageView
    lateinit var select_inc: ImageView
    lateinit var count_text: TextView
    var i = 1

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val mView = inflater!!.inflate(R.layout.fragment_survevy, container, false)

        back = mView.findViewById(R.id.back)
        select_dec = mView.findViewById(R.id.select_dec)
        select_inc = mView.findViewById(R.id.select_inc)
        count_text = mView.findViewById(R.id.count_text)


        select_dec.setOnClickListener(View.OnClickListener {
            if (i >= 2)
                count_text.setText((--i).toString() + " of 5")
        })
        select_inc.setOnClickListener(View.OnClickListener {
            if (i <= 4)
                count_text.setText((++i).toString() + " of 5")
        })


        back.setOnClickListener(View.OnClickListener { activity.finish() })
        return mView
    }
}