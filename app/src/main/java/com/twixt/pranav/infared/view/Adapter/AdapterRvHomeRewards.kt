package com.twixt.pranav.infared.view.Adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.twixt.pranav.infared.view.Activity.DetailsRewards
import com.twixt.pranav.infared.view.Activity.RewardsDetails
import com.twixt.pranav.infared.R

/**
 * Created by Pranav on 11/10/2017.
 */
class AdapterRvHomeRewards(var context: Context) : RecyclerView.Adapter<AdapterRvHomeRewards.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {

        val layoutInflator = LayoutInflater.from(context)
        val view = layoutInflator.inflate(R.layout.rv_rewards_home, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.image.setBackgroundResource(R.drawable.image2)
    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        lateinit var image: ImageView
        lateinit var points: TextView
        lateinit var title: TextView
        lateinit var expires: TextView
        lateinit var valid: TextView

        init {

            image = itemView!!.findViewById(R.id.image)
            points = itemView!!.findViewById(R.id.points)
            title = itemView!!.findViewById(R.id.title)
            expires = itemView!!.findViewById(R.id.expires)
            valid = itemView!!.findViewById(R.id.valid)

            image.setOnClickListener(View.OnClickListener {
                context.startActivity(Intent(context, RewardsDetails::class.java))
//                Toast.makeText(context,"ok you are in..!! "+adapterPosition, Toast.LENGTH_SHORT).show()
            })

        }

    }

}