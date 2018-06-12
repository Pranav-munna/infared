package com.twixt.pranav.infared.view.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.twixt.pranav.infared.R
import android.net.Uri
import android.util.Log
import android.widget.*
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


/**
 * Created by Pranav on 11/14/2017.
 */
class AdapterEarnPoints(val context: Context) : RecyclerView.Adapter<AdapterEarnPoints.ViewHolder>() {

    val mediacontroller = MediaController(context)
//    lateinit var mTmpFile:File

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val layoutInflator = LayoutInflater.from(context)
        val view = layoutInflator.inflate(R.layout.rv_earn_points, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
//        holder!!.VideoURL  = "http://www.androidbegin.com/tutorial/AndroidCommercial.3gp"

        try {
            mediacontroller.setAnchorView(holder!!.video)
            val video = Uri.parse("http://www.androidbegin.com/tutorial/AndroidCommercial.3gp")
            holder.video.setMediaController(mediacontroller)
            holder.video.setVideoURI(video)

        } catch (e: Exception) {
            Log.e("Error", e.message)
            e.printStackTrace()
        }

        holder!!.video.requestFocus()
//        holder!!.video.start()
//        holder!!.video.setOnClickListener(View.OnClickListener {  })
        holder.video.setOnPreparedListener({
            holder.video.start()
        })
    }

    override fun getItemCount(): Int {
        return 3
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var VideoURL = ""
        var title: TextView
        var points: TextView
        var video: VideoView

        init {
            title = itemView!!.findViewById(R.id.title)
            points = itemView.findViewById(R.id.points)
            video = itemView.findViewById(R.id.video)
            video.requestFocus()

            video.setOnClickListener(View.OnClickListener { video.start() })
            title.setOnClickListener(View.OnClickListener { video.pause() })
            points.setOnClickListener(View.OnClickListener { video.resume() })

        }
    }


    /*private fun copyToTmpFile(url: String) {
        val f = File(url)
        try {
            mTmpFile = File.createTempFile("video", null)
            mTmpFile.deleteOnExit()

            val `is` = FileInputStream(f)
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()

            val fos = FileOutputStream(mTmpFile)
            fos.write(buffer)
            fos.close()
        } catch (e: Exception) {
        mVideoView.setVideoURI(Uri.parse(url))
        }

    }*/

}

