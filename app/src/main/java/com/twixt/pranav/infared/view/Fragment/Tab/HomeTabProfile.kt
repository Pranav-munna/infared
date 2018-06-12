package com.twixt.pranav.infared.view.Fragment.Tab

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.twixt.pranav.infared.Controller.SharedPreferenceHelper
import com.twixt.pranav.infared.view.Activity.EarnPoints
import com.twixt.pranav.infared.view.Activity.RewardQRCode
import com.twixt.pranav.infared.view.Adapter.AdapterRvProfileAll
import com.twixt.pranav.infared.R
import de.hdodenhof.circleimageview.CircleImageView


/**
 * Created by Pranav on 11/13/2017.
 */
class HomeTabProfile : Fragment() {

    lateinit var back: ImageView
    lateinit var edit: ImageView

    lateinit var surveys: Button
    lateinit var earn_points: Button
    lateinit var checkin: Button
    lateinit var points: Button
    lateinit var scroll_details: ScrollView
    lateinit var relative_details: RelativeLayout
    lateinit var heading: TextView
    lateinit var rv_view_for_details: RecyclerView
    lateinit var dp: CircleImageView
    lateinit var f_name: TextView
    lateinit var l_name: TextView
    lateinit var email: TextView
    lateinit var name: TextView
    lateinit var card_number: TextView
    lateinit var exp_date: TextView

    var SURVEYS = 1
    var E_POINTS = 2
    var CHECKIN = 3
    var POINTS = 4

    var mRequestOptions = RequestOptions.overrideOf(100, 100)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mView = inflater.inflate(R.layout.home_tab_profile, container, false)
        var fullName = SharedPreferenceHelper(activity!!).getString(SharedPreferenceHelper(activity!!).USER_NAME, "name")!!.split(" ")
        back = mView.findViewById(R.id.back)
        edit = mView.findViewById(R.id.edit)
        scroll_details = mView.findViewById(R.id.scroll_details)
        relative_details = mView.findViewById(R.id.relative_details)
        heading = mView.findViewById(R.id.heading)
        rv_view_for_details = mView.findViewById(R.id.rv_view_for_details)
        dp = mView.findViewById(R.id.dp)
        f_name = mView.findViewById(R.id.f_name)
        l_name = mView.findViewById(R.id.l_name)
        email = mView.findViewById(R.id.email)
        name = mView.findViewById(R.id.name)
        card_number = mView.findViewById(R.id.card_number)
        exp_date = mView.findViewById(R.id.exp_date)

        val adapterRvProfileAll = AdapterRvProfileAll(activity!!)
        rv_view_for_details.adapter = adapterRvProfileAll

        surveys = mView.findViewById(R.id.surveys)
        earn_points = mView.findViewById(R.id.earn_points)
        checkin = mView.findViewById(R.id.checkin)
        points = mView.findViewById(R.id.points)


//        Toast.makeText(activity,SharedPreferenceHelper(activity).getString(SharedPreferenceHelper(activity).USER_LOGIN, "login"),Toast.LENGTH_SHORT).show()
        if ((SharedPreferenceHelper(activity!!).getString(SharedPreferenceHelper(activity!!).USER_LOGIN, "login")).equals("ok_login")) {
            Glide.with(activity)
                    .asBitmap()
                    .apply(mRequestOptions)
                    .load(SharedPreferenceHelper(activity!!).getString(SharedPreferenceHelper(activity!!).USER_IMAGE, "https://tst.net/assets/themes/tsttheme/images/dummy_user.png"))
                    .into(dp)

            f_name.setText("First name: " + fullName[0])
            l_name.setText("Last name: " + fullName[1])
            name.setText(fullName[0] + " " + fullName[1])


            try {
                email.setText("Email: " + SharedPreferenceHelper(activity!!).getString(SharedPreferenceHelper(activity!!).USER_MAIL, ""))
                card_number.setText("Card Number: ****-****-****-" + SharedPreferenceHelper(activity!!)
                        .getString(SharedPreferenceHelper(activity!!).USER_CARD_NUMBER, "****  ****  ****  XXXX")!!
                        .substring(18))
                exp_date.setText("Expiration Date: " + SharedPreferenceHelper(activity!!)
                        .getString(SharedPreferenceHelper(activity!!).USER_CARD_EXP_DATE, ""))
            } catch (e: Exception) {
            }
        }



        surveys.setOnClickListener(View.OnClickListener {
            surveys.setTextColor(ContextCompat.getColor(activity!!, R.color.textColorPrimary))
            earn_points.setTextColor(ContextCompat.getColor(activity!!, R.color.text_white))
            checkin.setTextColor(ContextCompat.getColor(activity!!, R.color.text_white))
            points.setTextColor(ContextCompat.getColor(activity!!, R.color.text_white))
            heading.setText("Surveys")
            scroll_details.visibility = View.GONE
            relative_details.visibility = View.VISIBLE
            adapterRvProfileAll.set(SURVEYS)
            rv_view_for_details.layoutManager = LinearLayoutManager(activity)
        })
        earn_points.setOnClickListener(View.OnClickListener {
            surveys.setTextColor(ContextCompat.getColor(activity!!, R.color.text_white))
            checkin.setTextColor(ContextCompat.getColor(activity!!, R.color.text_white))
            points.setTextColor(ContextCompat.getColor(activity!!, R.color.text_white))
            scroll_details.visibility = View.VISIBLE
            relative_details.visibility = View.GONE

            startActivity(Intent(activity, EarnPoints::class.java))
        })
        checkin.setOnClickListener(View.OnClickListener {
            surveys.setTextColor(ContextCompat.getColor(activity!!, R.color.text_white))
            earn_points.setTextColor(ContextCompat.getColor(activity!!, R.color.text_white))
            checkin.setTextColor(ContextCompat.getColor(activity!!, R.color.textColorPrimary))
            points.setTextColor(ContextCompat.getColor(activity!!, R.color.text_white))
            heading.setText(" Checkins")
            scroll_details.visibility = View.GONE
            relative_details.visibility = View.VISIBLE
            adapterRvProfileAll.set(CHECKIN)
            rv_view_for_details.layoutManager = LinearLayoutManager(activity)
        })
        points.setOnClickListener(View.OnClickListener {
            surveys.setTextColor(ContextCompat.getColor(activity!!, R.color.text_white))
            earn_points.setTextColor(ContextCompat.getColor(activity!!, R.color.text_white))
            checkin.setTextColor(ContextCompat.getColor(activity!!, R.color.text_white))
            points.setTextColor(ContextCompat.getColor(activity!!, R.color.textColorPrimary))
            heading.setText("Points")
            scroll_details.visibility = View.GONE
            relative_details.visibility = View.VISIBLE
            adapterRvProfileAll.set(POINTS)
            rv_view_for_details.layoutManager = LinearLayoutManager(activity)
        })


        back.setOnClickListener(View.OnClickListener {
            activity!!.onBackPressed()
        })
        edit.setOnClickListener(View.OnClickListener {
            //            Toast.makeText(activity, "Edit design missing...!!!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(activity, RewardQRCode::class.java))
        })
        return mView
    }
}