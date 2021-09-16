package com.example.booking

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import com.example.booking.databinding.FragmentBookingBinding
import java.text.DateFormat
import java.util.*

class BookingFragment : Fragment() {
    lateinit var binding: FragmentBookingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBookingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBook.setVisibility(View.GONE)


        //calendar button
        val cal: Calendar = Calendar.getInstance()
        val currentDate = DateFormat.getDateInstance().format(cal.time)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        val month = cal.get(Calendar.MONTH)
        val year = cal.get(Calendar.YEAR)
        binding.btnCalendar.setOnClickListener {

            val dpd = DatePickerDialog(
                //context
                requireContext(),
                DatePickerDialog.OnDateSetListener { view: DatePicker, mYear: Int, mMonth: Int, mDay: Int ->
                    val mmMonth = mMonth + 1
                    binding.edtDate.setText("$mDay/$mmMonth/$mYear")

                },
                year,
                month,
                day
            )
            dpd.show()
        }


        //Date Validation
        fun validate(): Boolean {
            if (binding.edtDate.text.toString().isNullOrEmpty()) {
                binding.edtDate.requestFocus()
                binding.edtDate.error = "Date should not be blank"
                return false
            }
            if (binding.edtDate.text.toString() < "$day/" + month + 1 + "/$year") {
                binding.edtDate.requestFocus()
                binding.edtDate.error = "Can't book in previous date , Try again"
                Toast.makeText(context, "Current Date is $currentDate", Toast.LENGTH_LONG).show()
                return false
            }
            return true

        }


        //Morning time
        binding.btnMorning.setOnClickListener {
            var dialog1 = MorningDialog()
            dialog1.show(parentFragmentManager, "customDialog")
        }
        //Afternoon Time
        binding.btnAfternoon.setOnClickListener {
            var dialog2 = AfternoonDialog()
            dialog2.show(parentFragmentManager, "customDialog")
        }

        //Evening Time
        binding.btnEvening.setOnClickListener {
            var dialog3 = EveningDialog()
            dialog3.show(parentFragmentManager, "customDialog")        }


        //Booking button
        binding.btnBook.setOnClickListener {

            if (!validate()) {
                Toast.makeText(context, "Booking Failed", Toast.LENGTH_LONG).show()
            } else {
                val eBuilder = AlertDialog.Builder(context)
                eBuilder.setTitle("Complete!")
                eBuilder.setIcon(R.drawable.confirmation)
                eBuilder.setMessage("Your request has successfully been submitted , We'll see you soon!")
                eBuilder.setPositiveButton("Ok") { Dialog, which ->
                    finish()

                }
                val createBuild: AlertDialog = eBuilder.create()
                createBuild.show()
            }

        }

    }

    private fun finish() {
        finish()
    }
}

    //Exit button
/* binding.btnExit.setOnClickListener {
     val eBuilder = AlertDialog.Builder(context)
     eBuilder.setTitle("Exit")
     eBuilder.setIcon(R.drawable.ic_exit)
     eBuilder.setMessage("Are you sure you want to EXIT ?")
     eBuilder.setPositiveButton("Yes") { Dialog, which ->
         finish()

     }
     eBuilder.setNegativeButton("No") { Dialog, which ->
         Toast.makeText(
             context,
             "If you want to exit press this button again",
             Toast.LENGTH_LONG
         ).show()

     }
     val createBuild: AlertDialog = eBuilder.create()
     createBuild.show()
 }


}*/


