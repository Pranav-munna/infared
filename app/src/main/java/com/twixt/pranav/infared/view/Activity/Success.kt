package com.twixt.pranav.infared.view.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.twixt.pranav.infared.view.Fragment.FragmentSuccess
import com.twixt.pranav.infared.R

class Success : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        fragmentManager.beginTransaction()
                .add(R.id.activity_login, FragmentSuccess(),"SignUpEmail")
                .commit()
    }
}
