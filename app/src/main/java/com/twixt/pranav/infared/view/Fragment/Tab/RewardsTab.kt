package com.twixt.pranav.infared.view.Fragment.Tab

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.twixt.pranav.infared.view.Activity.EarnPoints
import com.twixt.pranav.infared.view.Activity.RewardsDetails
import com.twixt.pranav.infared.R

/**
 * Created by Pranav on 11/10/2017.
 */
class RewardsTab : Fragment() {
    lateinit var description: TextView
    lateinit var rules: TextView
    lateinit var redeem: Button


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mView = inflater!!.inflate(R.layout.rewards_tab, container, false)

        description = mView.findViewById(R.id.description)
        rules = mView.findViewById(R.id.rules)
        redeem = mView.findViewById(R.id.redeem)


        description.movementMethod = ScrollingMovementMethod()
        rules.movementMethod = ScrollingMovementMethod()

        redeem.setOnClickListener(View.OnClickListener {
//            Toast.makeText(activity,"Redeem 20 points..!!",Toast.LENGTH_SHORT).show()
            startActivity(Intent(activity, RewardsDetails::class.java))
        })

        return mView
    }
}