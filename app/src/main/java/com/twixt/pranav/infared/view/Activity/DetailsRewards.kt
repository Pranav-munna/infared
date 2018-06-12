package com.twixt.pranav.infared.view.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.twixt.pranav.infared.view.Fragment.FrgmentDetailsRewards
import com.twixt.pranav.infared.R

class DetailsRewards : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportFragmentManager.beginTransaction()
                .add(R.id.activity_login, FrgmentDetailsRewards(),"DetailsRewards")
                .commit()
    }
}
