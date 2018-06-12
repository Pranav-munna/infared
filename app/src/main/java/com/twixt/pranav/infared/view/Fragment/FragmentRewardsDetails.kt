package com.twixt.pranav.infared.view.Fragment

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.twixt.pranav.infared.view.Activity.Payment
import com.twixt.pranav.infared.R

/**
 * Created by Pranav on 11/13/2017.
 */
class FragmentRewardsDetails : Fragment() {
    lateinit var description: TextView
    lateinit var rules: TextView
    lateinit var back: ImageView
    lateinit var purchase: Button

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val mView = inflater!!.inflate(R.layout.fragment_rewards_details, container, false)
        description = mView.findViewById(R.id.description)
        rules = mView.findViewById(R.id.rules)
        back = mView.findViewById(R.id.back)
        purchase = mView.findViewById(R.id.purchase)

        description.movementMethod = ScrollingMovementMethod()
        rules.movementMethod = ScrollingMovementMethod()


        back.setOnClickListener(View.OnClickListener {
            activity.finish()
        })
        purchase.setOnClickListener(View.OnClickListener {
            startActivity(Intent(activity, Payment::class.java))
        })
        return mView
    }
}