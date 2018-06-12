package com.twixt.pranav.infared.view.Fragment

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.AppCompatButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.twixt.pranav.infared.view.Activity.Login
import com.twixt.pranav.infared.view.Activity.Signup
import com.twixt.pranav.infared.R

/**
 * Created by Pranav on 11/8/2017.
 */
class FragmentLoginOptions : Fragment() {

    lateinit var btn_login: AppCompatButton
    lateinit var btn_signup: AppCompatButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val mView = inflater.inflate(R.layout.fragment_login_options, container, false)

        btn_login = mView.findViewById(R.id.btn_login)
        btn_signup = mView.findViewById(R.id.btn_signup)

        btn_login.setOnClickListener(View.OnClickListener {

            startActivity(Intent(activity, Login::class.java))
//            Toast.makeText(activity, "login button", Toast.LENGTH_SHORT).show()
        })

        btn_signup.setOnClickListener(View.OnClickListener {
            //            Toast.makeText(activity, "signup button", Toast.LENGTH_SHORT).show()
            startActivity(Intent(activity, Signup::class.java))
        })

        return mView
    }
}