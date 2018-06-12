package com.twixt.pranav.infared.view.Fragment.Tab

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.twixt.pranav.infared.R
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.twixt.pranav.infared.view.Adapter.Stopwatch


/**
 * Created by Pranav on 11/10/2017.
 */
class InfoTab : Fragment() {
    lateinit var description: TextView
    lateinit var timer_count: TextView
    lateinit var detail_layout: RelativeLayout
    lateinit var timer_layout: LinearLayout
    lateinit var navigate: Button
    lateinit var start_timer: Button
    lateinit var end_timer: Button

    var MSG_START_TIMER = 0
    var MSG_STOP_TIMER = 1
    var MSG_UPDATE_TIMER = 2

    var timer = Stopwatch()
    var REFRESH_RATE = 100


    var mHandler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when (msg.what) {
                MSG_START_TIMER -> {
                    timer.start() //start timer
                    this.sendEmptyMessage(MSG_UPDATE_TIMER)
                }

                MSG_UPDATE_TIMER -> {
                    timer_count.setText((timer.getElapsedTime() / 1000 / 60).toString() + ":" + ((timer.getElapsedTime() / 1000)%60).toString()+" min")
                    this.sendEmptyMessageDelayed(MSG_UPDATE_TIMER, REFRESH_RATE.toLong()) //text view is updated every second,
                }
                MSG_STOP_TIMER -> {
                    this.removeMessages(MSG_UPDATE_TIMER) // no more updates.
                    timer.stop()//stop timer
                    timer_count.setText((timer.getElapsedTime() / 1000 / 60).toString() + ":" + ((timer.getElapsedTime() / 1000)%60).toString()+" min")
                }

                else -> {
                }
            }//though the timer is still running
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mView = inflater!!.inflate(R.layout.info_tab, container, false)

        description = mView.findViewById(R.id.description)
        detail_layout = mView.findViewById(R.id.detail_layout)
        timer_layout = mView.findViewById(R.id.timer_layout)
        navigate = mView.findViewById(R.id.navigate)
        timer_count = mView.findViewById(R.id.timer_count)
        start_timer = mView.findViewById(R.id.start_timer)
        end_timer = mView.findViewById(R.id.end_timer)

        description.movementMethod = ScrollingMovementMethod()

        navigate.setOnClickListener(View.OnClickListener {
            detail_layout.visibility = View.GONE
            timer_layout.visibility = View.VISIBLE
        })

        start_timer.setOnClickListener(View.OnClickListener {
            start_timer.visibility = View.GONE
            end_timer.visibility= View.VISIBLE
            mHandler.sendEmptyMessage(MSG_START_TIMER)
        })
        end_timer.setOnClickListener(View.OnClickListener {
            start_timer.visibility = View.VISIBLE
            end_timer.visibility= View.GONE
            mHandler.sendEmptyMessage(MSG_STOP_TIMER)
        })

        return mView
    }

}