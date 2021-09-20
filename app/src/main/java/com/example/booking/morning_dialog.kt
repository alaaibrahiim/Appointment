package com.example.booking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_booking.*
import kotlinx.android.synthetic.main.fragment_booking.view.*


class MorningDialog : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.morning_dialog_fragment, container, false)
        val btnCancel = rootView.findViewById<Button>(R.id.btn_cancel)
        val btnDone = rootView.findViewById<Button>(R.id.btn_done)
        val radioGroup1 = rootView.findViewById<RadioGroup>(R.id.radioGroup1)


        btnCancel.setOnClickListener {
            //btn_book.setVisibility(View.GONE)
            Toast.makeText(context, "Don't forget to choose time", Toast.LENGTH_LONG).show()
            dismiss()

        }
        btnDone.setOnClickListener {
            val selectedID = radioGroup1.checkedRadioButtonId
            val radio = rootView.findViewById<RadioButton>(selectedID)
            val timeResult = radio.text.toString()
            Toast.makeText(context, "You choose $timeResult", Toast.LENGTH_LONG).show()
            dismiss()
            //btn_book.setVisibility(View.VISIBLE)
            //Booking details text
            //txt_bookingDetails.text =
              //  "You will book an appointment with Doctor/" + "The date you have chosen is : ${edt_date.text.toString()} at $timeResult"

        }

        return rootView

    }
}