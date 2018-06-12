package com.twixt.pranav.infared.Controller

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Pranav on 11/15/2017.
 */
class SharedPreferenceHelper(val context: Context) {

    var USER_NAME = "user_name"
    var USER_IMAGE = "user_image"
    var USER_MAIL = "user_email"
    var USER_FB_ID = "user_fb_id"
    var USER_LOGIN = "user_login"

    var USER_CARD_TYPE_NO = "user_card_type_no"
    var USER_CARD_NUMBER = "user_card_number"
    var USER_CARD_PHONE_NUMBER = "user_phone_number"
    var USER_CARD_EXP_DATE = "user_card_exp_date"

    val sharedpreference: SharedPreferences = context.getSharedPreferences("sp_infaRed", Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = sharedpreference.edit()

    fun putString(key: String, data: String) {
        editor.putString(key, data)
        editor.commit()
    }

    fun getString(key: String, data: String): String? {
        return sharedpreference.getString(key, data)
    }

    fun putInt(key: String, data: Int) {
        editor.putInt(key, data)
        editor.commit()
    }

    fun getInt(key: String, data: Int): Int? {
        return sharedpreference.getInt(key, data)
    }

}