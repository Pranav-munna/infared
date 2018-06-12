package com.twixt.pranav.infared.view.Adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.twixt.pranav.infared.view.Activity.Survevy
import com.twixt.pranav.infared.R

/**
 * Created by Pranav on 11/13/2017.
 */
class AdapterRvProfileAll(var context: Context) : RecyclerView.Adapter<AdapterRvProfileAll.ViewHolder>() {
    var CHECK = 0

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val layoutInflator = LayoutInflater.from(context)
        val view = layoutInflator.inflate(R.layout.rv_profile_all, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        when (CHECK) {
            1 -> {
                holder!!.detail.setText("Opera Night Club")
                holder!!.count.setText("Not Started ")
            }
            3 -> {
                holder!!.detail.setText("Mint Hookah Lounge")
                holder!!.count.setText("8/12@9:00pm")
            }
            4 -> {
                holder!!.detail.setText("8/12  The porter Beer Bar")
                holder!!.count.setText("+25pts")
            }
        }


    }

    override fun getItemCount(): Int {
        return 4
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        lateinit var detail: TextView
        lateinit var count: TextView
        lateinit var layout_: LinearLayout

        init {
            count = itemView!!.findViewById(R.id.count)
            detail = itemView!!.findViewById(R.id.detail)
            layout_ = itemView!!.findViewById(R.id.layout_)

            layout_.setOnClickListener(View.OnClickListener {

                when (CHECK) {
                    1 -> {
                        context.startActivity(Intent(context, Survevy::class.java))
                    }
                    3 -> {

                    }
                    4 -> {

                    }
                }

            })

        }
    }

    fun set(check: Int) {
        CHECK = check
    }
}