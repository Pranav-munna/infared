package com.twixt.pranav.infared.view.Activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.twixt.pranav.infared.view.Fragment.FragmentSignup
import com.twixt.pranav.infared.R

/**
 * Created by Pranav on 11/8/2017.
 */
class Signup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
//        var callbackManager = CallbackManager.Factory.create()
//no need in latest versons
        FacebookSdk.sdkInitialize(applicationContext)
        AppEventsLogger.activateApp(application)



        fragmentManager.beginTransaction()
                .add(R.id.activity_login, FragmentSignup(), "Signup")
                .commit();
    }

   /* override fun onResume() {
        super.onResume()
        AppEventsLogger.activateApp(application)
    }

    override fun onPause() {
        super.onPause()
        AppEventsLogger.deactivateApp(this)
    }*/
}