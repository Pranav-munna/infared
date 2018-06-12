package com.twixt.pranav.infared.view.Fragment

import android.Manifest
import android.annotation.TargetApi
import android.app.Activity
import android.app.AlertDialog
import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import com.facebook.*
import com.twixt.pranav.infared.view.Activity.MainPage
import com.twixt.pranav.infared.view.Activity.SignUpEmail
import com.twixt.pranav.infared.R
import com.facebook.login.widget.LoginButton
import com.facebook.login.LoginResult
import com.twixt.pranav.infared.Controller.SharedPreferenceHelper
import java.util.*


/**
 * Created by Pranav on 11/8/2017.
 */
class FragmentSignup : Fragment() {

    lateinit var callbackManager: CallbackManager
    lateinit var btn_email: AppCompatButton
    lateinit var login_button: LoginButton
    lateinit var progress_bar: ProgressBar
    val MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val mView = inflater.inflate(R.layout.fragment_signup, container, false)

        callbackManager = CallbackManager.Factory.create()

        btn_email = mView.findViewById(R.id.btn_email)
        login_button = mView.findViewById(R.id.login_button)
        progress_bar = mView.findViewById(R.id.progress_bar)
        login_button.setReadPermissions(Arrays.asList("public_profile, email, user_birthday")/*"email"*/)

        val currentAPIVersion = Build.VERSION.SDK_INT
        if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity as Activity, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    val alertBuilder = AlertDialog.Builder(activity)
                    alertBuilder.setCancelable(false)
                    alertBuilder.setTitle("Permission necessary")
                    alertBuilder.setMessage("External storage permission is necessary")
                    alertBuilder.setPositiveButton(android.R.string.yes) { dialog, which -> ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE) }
                    val alert = alertBuilder.create()
                    alert.show()
                } else {
                    ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE)
                }
                Toast.makeText(activity,"External storage permission not granted",Toast.LENGTH_LONG).show()
            }
        }

        SharedPreferenceHelper(activity).editor.clear().commit()
        login_button.setFragment(this)



        login_button.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                progress_bar.visibility = View.VISIBLE
                btn_email.isClickable = false
                btn_email.isClickable = false
                val data_request = GraphRequest.newMeRequest(
                        loginResult.accessToken) { json_object, response ->
                    startActivity(Intent(activity, MainPage::class.java))


                    try {
                        /*Toast.makeText(activity,json_object.getString("gender")+"",Toast.LENGTH_SHORT).show()
                        println(json_object.getString("gender"))*/

                        SharedPreferenceHelper(activity).putString(SharedPreferenceHelper(activity).USER_LOGIN, "ok_login")
                        var a = json_object.getString("picture").replace("\\/", "/").replace("{\"data\":{\"height\":160,\"is_silhouette\":false,\"url\":\"", " ").replace("\",\"width\":160}}", "")
                        SharedPreferenceHelper(activity).putString(SharedPreferenceHelper(activity).USER_IMAGE, a.trim())
                        SharedPreferenceHelper(activity).putString(SharedPreferenceHelper(activity).USER_NAME, json_object.getString("name"))
                        try {
                            SharedPreferenceHelper(activity).putString(SharedPreferenceHelper(activity).USER_MAIL, json_object.getString("email"))
                        } catch (e: Exception) {
                            SharedPreferenceHelper(activity).putString(SharedPreferenceHelper(activity).USER_FB_ID, json_object.getString("id"))
                        }
                    } catch (e: Exception) {
                        println(e)
                    }
                }
                val permission_param = Bundle()
                permission_param.putString("fields", "id,name,email,gender, birthday,picture.width(150).height(150)")
                data_request.parameters = permission_param
                data_request.executeAsync()
            }

            override fun onCancel() {
                progress_bar.visibility = View.INVISIBLE
                btn_email.isClickable = true
                btn_email.isClickable = true
            }

            override fun onError(exception: FacebookException) {
                progress_bar.visibility = View.INVISIBLE
                Toast.makeText(activity, "something went wrong...!!!", Toast.LENGTH_SHORT).show()
                btn_email.isClickable = true
                btn_email.isClickable = true
            }
        })

        btn_email.setOnClickListener(View.OnClickListener {
            //            Toast.makeText(activity,"Signup using email",Toast.LENGTH_SHORT).show()
            startActivity(Intent(activity, SignUpEmail::class.java))
        })

        return mView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    fun checkPermissionread(context: Context): Boolean {
        val currentAPIVersion = Build.VERSION.SDK_INT
        if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(context as Activity, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    val alertBuilder = AlertDialog.Builder(context)
                    alertBuilder.setCancelable(true)
                    alertBuilder.setTitle("Permission necessary")
                    alertBuilder.setMessage("External storage permission is necessary")
                    alertBuilder.setPositiveButton(android.R.string.yes) { dialog, which -> ActivityCompat.requestPermissions(context, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE) }
                    val alert = alertBuilder.create()
                    alert.show()
                    return true
                } else {
                    ActivityCompat.requestPermissions(context, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE)
                    return false
                }
            } else
                return false
        } else
            return true
    }

}