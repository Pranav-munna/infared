package com.twixt.pranav.infared.view.Fragment

import android.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.twixt.pranav.infared.R
import com.twixt.pranav.infared.Controller.SharedPreferenceHelper


/**
 * Created by Pranav on 11/13/2017.
 */
class FragmentPayment : Fragment() {

    lateinit var paymenty_button: Button
    lateinit var back: ImageView
    lateinit var card_no: EditText
    lateinit var expiry_date: EditText
    lateinit var phone_no: EditText
    lateinit var security_code: EditText
    lateinit var card_type: Spinner
    var cardtype_count = 0
    var cards = arrayOf("-- Select Card Type --", "Credit card", "Debit card", "Charge card", "ATM card", "Stored-value card", "Fleet card")

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val mView = inflater!!.inflate(R.layout.fragment_payment, container, false)
        paymenty_button = mView.findViewById(R.id.paymenty_button)
        back = mView.findViewById(R.id.back)
        card_no = mView.findViewById(R.id.card_no)
        expiry_date = mView.findViewById(R.id.expiry_date)
        card_type = mView.findViewById(R.id.card_type)
        phone_no = mView.findViewById(R.id.phone_no)
        security_code = mView.findViewById(R.id.security_code)


        val adapterCardName = ArrayAdapter<String>(activity, R.layout.spinner, cards)
        card_type!!.adapter = adapterCardName
        adapterCardName.notifyDataSetChanged()

        card_type!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {}
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                cardtype_count = p2
            }
        }

        card_no.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString().length > 18) {
                    return
                }
                var i = 4
                while (i < p0.toString().length) {
                    if (p0?.get(i) !== ' ') {
                        p0!!.insert(i, " ")
                        p0!!.insert(i, " ")
                    }
                    i += 6
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })

        expiry_date.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                var i = 2
                while (i < p0.toString().length) {
                    if (p0?.get(i) !== '/') {
                        p0!!.insert(i, "/")
                    }
                    i += 3
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })

        paymenty_button.setOnClickListener(View.OnClickListener {
            if (cardtype_count != 0 && card_no.text.trim().length == 22 && phone_no.text.trim().length == 10 && expiry_date.text.trim().length == 5 && security_code.text.trim().length >= 0) {
                SharedPreferenceHelper(activity).putInt(SharedPreferenceHelper(activity).USER_CARD_TYPE_NO, cardtype_count)
                SharedPreferenceHelper(activity).putString(SharedPreferenceHelper(activity).USER_CARD_NUMBER, card_no.text.toString())
                SharedPreferenceHelper(activity).putString(SharedPreferenceHelper(activity).USER_CARD_PHONE_NUMBER, phone_no.text.toString())
                SharedPreferenceHelper(activity).putString(SharedPreferenceHelper(activity).USER_CARD_EXP_DATE, expiry_date.text.toString())
                Toast.makeText(activity, " saved ", Toast.LENGTH_SHORT).show()

            } else
                Toast.makeText(activity, "Verify All Fields", Toast.LENGTH_SHORT).show()
        })
        back.setOnClickListener(View.OnClickListener {
            activity.finish()
        })
        return mView
    }


    class CreditCardNumberFormattingTextWatcher : TextWatcher {

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun afterTextChanged(s: Editable) {
            if (s.toString().length > 18) {
                return
            }
            var i = 4
            while (i < s.toString().length) {
                if (s[i] !== ' ') {
                    s.insert(i, " ")
                    s.insert(i, " ")
                }
                i += 6
            }
        }
    }


}