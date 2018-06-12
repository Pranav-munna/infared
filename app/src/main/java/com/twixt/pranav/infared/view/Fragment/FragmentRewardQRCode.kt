package com.twixt.pranav.infared.view.Fragment

import android.app.Fragment
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.twixt.pranav.infared.R

/**
 * Created by Pranav on 11/14/2017.
 */
class FragmentRewardQRCode : Fragment() {
    lateinit var ready_txt: TextView
    lateinit var back: ImageView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val mView = inflater!!.inflate(R.layout.fragment_reward_q_r_code, container, false)

        ready_txt = mView.findViewById(R.id.ready_txt)
        back = mView.findViewById(R.id.back)
        ready_txt.movementMethod = ScrollingMovementMethod()

        back.setOnClickListener(View.OnClickListener { activity.finish() })
        return mView
    }

}