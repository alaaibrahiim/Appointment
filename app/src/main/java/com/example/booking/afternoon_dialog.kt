package com.example.booking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_booking.*

class AfternoonDialog : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView2: View = inflater.inflate(R.layout.afternoon_dialog_fragment, container, false)
        var btnCancel = rootView2.findViewById<Button>(R.id.btn_cancel)
        var btnDone = rootView2.findViewById<Button>(R.id.btn_done)
        var radioGroup2 = rootView2.findViewById<RadioGroup>(R.id.radioGroup2)

        btnCancel.setOnClickListener {
            btn_book.setVisibility(View.GONE)
            Toast.makeText(context, "Don't forget to choose time", Toast.LENGTH_LONG).show()
            dismiss()
        }
        btnDone.setOnClickListener {
            val selectedID = radioGroup2.checkedRadioButtonId
            val radio = rootView2.findViewById<RadioButton>(selectedID)
            var timeResult = radio.text.toString()
            Toast.makeText(context, "You choose $timeResult", Toast.LENGTH_LONG).show()
            dismiss()
            btn_book.setVisibility(View.VISIBLE)
            //Booking details text
            txt_bookingDetails.text =
                "You will book an appointment with Doctor/" + "The date you have chosen is : ${edt_date.text.toString()} at $timeResult"
        }

        return rootView2
    }
}