package com.twixt.pranav.infared.view.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.twixt.pranav.infared.view.Fragment.FragmentLoginOptions
import com.twixt.pranav.infared.R

/**
 * Created by Pranav on 11/8/2017.
 */
class LoginOptions : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        fragmentManager.beginTransaction()
                .add(R.id.activity_login, FragmentLoginOptions(),"activity_login_options")
                .commit()
    }

}