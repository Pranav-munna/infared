package com.twixt.pranav.infared.view.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.twixt.pranav.infared.view.Fragment.FragmentMainPage
import com.twixt.pranav.infared.R

class MainPage : AppCompatActivity() {

    var exit: Boolean = false
    val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportFragmentManager.beginTransaction()
                .add(R.id.activity_login, FragmentMainPage(), "MainPage")
                .commit()
    }

    override fun onBackPressed() {
        if (exit) {
            super.onBackPressed()
            this.finishAffinity()
        }
        Toast.makeText(this, "Press BACK again to exit", Toast.LENGTH_SHORT).show()
        exit = true
        handler.postDelayed(Runnable { exit = false }, 2000)
    }
}
