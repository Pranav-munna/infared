package com.twixt.pranav.infared.view.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.twixt.pranav.infared.view.Fragment.FragmentEarnPoints
import com.twixt.pranav.infared.R

class EarnPoints : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        fragmentManager.beginTransaction()
                .add(R.id.activity_login, FragmentEarnPoints(),"EarnPoints")
                .commit()
    }
}
