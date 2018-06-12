package com.twixt.pranav.infared.view.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.twixt.pranav.infared.view.Fragment.FragmentRewardQRCode
import com.twixt.pranav.infared.R

class RewardQRCode : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        fragmentManager.beginTransaction()
                .add(R.id.activity_login, FragmentRewardQRCode(),"RewardQRCode")
                .commit()
    }
}
