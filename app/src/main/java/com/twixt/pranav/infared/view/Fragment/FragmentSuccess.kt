package com.twixt.pranav.infared.view.Fragment

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.AppCompatButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.twixt.pranav.infared.view.Activity.MainPage
import com.twixt.pranav.infared.R

/**
 * Created by Pranav on 11/9/2017.
 */
class FragmentSuccess : Fragment() {
    lateinit var navigate_your_night: AppCompatButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mView = inflater.inflate(R.layout.fragment_success, container, false)

        navigate_your_night=mView.findViewById(R.id.navigate_your_night)

        navigate_your_night.setOnClickListener(View.OnClickListener {

            startActivity(Intent(activity, MainPage::class.java))
//            Toast.makeText(activity,"ready to go..!!",Toast.LENGTH_SHORT).show()
        })

        return mView
    }
}