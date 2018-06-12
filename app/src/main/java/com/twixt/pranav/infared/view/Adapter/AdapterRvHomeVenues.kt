package com.twixt.pranav.infared.view.Adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.twixt.pranav.infared.view.Activity.DetailsRewards
import com.twixt.pranav.infared.R

/**
 * Created by Pranav on 11/10/2017.
 */
class AdapterRvHomeVenues(var context: Context) : RecyclerView.Adapter<AdapterRvHomeVenues.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {

        val layoutInflator = LayoutInflater.from(context)
        val view = layoutInflator.inflate(R.layout.rv_home, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.image.setBackgroundResource(R.drawable.image4)
    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        lateinit var image: ImageView
        lateinit var title: TextView
        lateinit var address: TextView
        lateinit var rating: TextView
        lateinit var time: TextView
        lateinit var distance: TextView
        lateinit var description: TextView

        init {

            image = itemView!!.findViewById(R.id.image)
            title = itemView!!.findViewById(R.id.title)
            address = itemView!!.findViewById(R.id.address)
            rating = itemView!!.findViewById(R.id.rating)
            time = itemView!!.findViewById(R.id.time)
            distance = itemView!!.findViewById(R.id.distance)
            description = itemView!!.findViewById(R.id.description)

            image.setOnClickListener(View.OnClickListener {
                context.startActivity(Intent(context, DetailsRewards::class.java))
//                Toast.makeText(context,"ok you are in..!! "+adapterPosition,Toast.LENGTH_SHORT).show()
            })

        }

    }

}