package com.twixt.pranav.infared.view.Adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.twixt.pranav.infared.view.Activity.DetailsRewards
import com.twixt.pranav.infared.R

/**
 * Created by Pranav on 11/10/2017.
 */
class AdapterRvSearch(var context: Context) : RecyclerView.Adapter<AdapterRvSearch.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val layoutInflator = LayoutInflater.from(context)
        val view = layoutInflator.inflate(R.layout.rv_search_results, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.image.setBackgroundResource(R.drawable.image2)

    }

    override fun getItemCount(): Int {
        return 10
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var image: ImageView
        lateinit var title: TextView
        lateinit var address: TextView
        lateinit var rating: TextView
        lateinit var time: TextView
        lateinit var distance: TextView
        lateinit var details: TextView
        lateinit var r_layout: RelativeLayout

        init {

            image = view.findViewById(R.id.image)
            title = view.findViewById(R.id.title)
            address = view.findViewById(R.id.address)
            rating = view.findViewById(R.id.rating)
            time = view.findViewById(R.id.time)
            distance = view.findViewById(R.id.distance)
            details = view.findViewById(R.id.details)
            r_layout = view.findViewById(R.id.r_layout)

            r_layout.setOnClickListener(View.OnClickListener {
                context.startActivity(Intent(context, DetailsRewards::class.java))
            })

        }

    }
}