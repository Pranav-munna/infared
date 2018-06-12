package com.twixt.pranav.infared.view.Fragment

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.app.Fragment
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
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.twixt.pranav.infared.view.Activity.MainPage
import com.twixt.pranav.infared.R

/**
 * Created by Pranav on 11/8/2017.
 */
class FragmentLogin : Fragment() {

    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var login: AppCompatButton
    lateinit var f_username: Button
    lateinit var f_password: Button
    val MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val mView = inflater.inflate(R.layout.fragment_login, container, false)

        username = mView.findViewById(R.id.username)
        password = mView.findViewById(R.id.password)
        login = mView.findViewById(R.id.login)
        f_username = mView.findViewById(R.id.f_username)
        f_password = mView.findViewById(R.id.f_password)

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

        login.setOnClickListener(View.OnClickListener {
            if (!(username.text.trim().length <= 0 || password.text.trim().length <= 0)) {
//                Toast.makeText(activity, "Welcome " + username.text, Toast.LENGTH_SHORT).show()
                startActivity(Intent(activity, MainPage::class.java))
            } else {
                Toast.makeText(activity, "Enter all Fields", Toast.LENGTH_SHORT).show()
            }
        })

        f_username.setOnClickListener(View.OnClickListener {
            Toast.makeText(activity, "Forgot username?", Toast.LENGTH_SHORT).show()
        })
        f_password.setOnClickListener(View.OnClickListener {
            Toast.makeText(activity, "Forgot password?", Toast.LENGTH_SHORT).show()
        })

        return mView
    }
}