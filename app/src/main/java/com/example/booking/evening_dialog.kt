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

class EveningDialog : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView3: View = inflater.inflate(R.layout.evening_dialog_fragment, container, false)
        var btnCancel = rootView3.findViewById<Button>(R.id.btn_cancel)
        var btnDone = rootView3.findViewById<Button>(R.id.btn_done)
        var radioGroup3 = rootView3.findViewById<RadioGroup>(R.id.radioGroup3)

        btnCancel.setOnClickListener {
            binding.btnBook.setVisibility(View.GONE)
            Toast.makeText(context, "Don't forget to choose time", Toast.LENGTH_LONG).show()
            dismiss()
        }
        btnDone.setOnClickListener {
            val selectedID = radioGroup3.checkedRadioButtonId
            val radio = rootView3.findViewById<RadioButton>(selectedID)
            var timeResult = radio.text.toString()
            Toast.makeText(context, "You choose $timeResult", Toast.LENGTH_LONG).show()
            dismiss()
            binding.btnBook.setVisibility(View.VISIBLE)
            //Booking details text
            binding.txtBookingDetails.text =
                "You will book an appointment with Doctor/" + "The date you have chosen is : ${binding.edtDate.text.toString()} at $timeResult"
        }

        return rootView3
    }
}