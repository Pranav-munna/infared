package com.twixt.pranav.infared.view.Activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.twixt.pranav.infared.R

class SplashScreen : Activity() {

    internal var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        handler.postDelayed({
            //Splash screen delay + finish action
            startActivity(Intent(this, LoginOptions::class.java))
            overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out)
            finish()
        },2500)
    }
}
