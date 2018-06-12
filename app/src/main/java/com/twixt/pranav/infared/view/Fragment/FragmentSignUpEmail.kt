package com.twixt.pranav.infared.view.Fragment

import android.app.Fragment
import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.widget.AppCompatButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.bumptech.glide.Glide
import com.twixt.pranav.infared.Controller.SharedPreferenceHelper
import com.twixt.pranav.infared.view.Activity.Success
import com.twixt.pranav.infared.R
import de.hdodenhof.circleimageview.CircleImageView
import org.json.JSONObject
import java.io.File

/**
 * Created by Pranav on 11/8/2017.
 */
class FragmentSignUpEmail : Fragment() {

    lateinit var user_image: CircleImageView
    lateinit var first_name: EditText
    lateinit var last_name: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var c_password: EditText
    lateinit var create_account: AppCompatButton
    val TAKE_IMAGE = 1
    lateinit var imagefile: File

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val mView = inflater.inflate(R.layout.fragment_signup_email, container, false)

        /*var intent = Intent().extras
        var jsondata = intent.getString("userProfile")*/
        user_image = mView.findViewById(R.id.user_image)
        first_name = mView.findViewById(R.id.first_name)
        last_name = mView.findViewById(R.id.last_name)
        email = mView.findViewById(R.id.email)
        password = mView.findViewById(R.id.password)
        c_password = mView.findViewById(R.id.c_password)
        create_account = mView.findViewById(R.id.create_account)

        SharedPreferenceHelper(activity).editor.clear().commit()

        /*try {
            first_name.setText("" + JSONObject(jsondata).get("name").toString())
        } catch (e: Exception) {
        }*/


        user_image.setOnClickListener(View.OnClickListener {

            /* startActivityForResult(Intent(Intent.ACTION_CHOOSER,
                     android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI), TAKE_IMAGE)*/
            val intent1 = Intent()
            intent1.type = "image/*"
            intent1.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent1, "Select Picture"), TAKE_IMAGE)
        })

        create_account.setOnClickListener(View.OnClickListener {
            if (first_name.text.toString().trim().length <= 0 || last_name.text.toString().trim().length <= 0 || email.text.toString().trim().length <= 0 || password.text.toString().trim().length <= 0 || c_password.text.toString().trim().length <= 0)
                Toast.makeText(activity, "Enter all Fields", Toast.LENGTH_SHORT).show()
            else {
                if (!(password.text.toString().trim().equals(c_password.text.toString().trim())))
                    Toast.makeText(activity, "Password do not match", Toast.LENGTH_SHORT).show()
                else {
                    if (!(isValidEmail(email.text.trim().toString())))
                        Toast.makeText(activity, "Invalid email address", Toast.LENGTH_SHORT).show()
                    else {

                        SharedPreferenceHelper(activity).putString(SharedPreferenceHelper(activity).USER_LOGIN, "ok_login")
                        SharedPreferenceHelper(activity).putString(SharedPreferenceHelper(activity).USER_MAIL, email.text.toString())
                        SharedPreferenceHelper(activity).putString(SharedPreferenceHelper(activity).USER_NAME, first_name.text.toString() + " " + last_name.text.toString())

                        startActivity(Intent(activity, Success::class.java))
                    }
                }
            }
        })

        return mView
    }

    fun isValidEmail(e_mail: String): Boolean {
        return e_mail.matches("^[0-9a-zA-Z!#$%&;'*+\\-/\\=\\?\\^_`\\.{|}~]{1,64}@[0-9a-zA-Z]{1,255}\\.[a-zA-Z]{1,10}".toRegex()) && e_mail.length <= 320
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TAKE_IMAGE) {
            val ImageURI = data!!.data

            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
            val cursor = activity.contentResolver.query(ImageURI!!, filePathColumn, null, null, null)
            cursor!!.moveToFirst()

            val columnIndex = cursor.getColumnIndex(filePathColumn[0])
            val imgDecodableString = cursor.getString(columnIndex)

            imagefile = File(imgDecodableString)
            Glide.with(activity)
                    .load(ImageURI)
                    .into(user_image)
        }
    }

}