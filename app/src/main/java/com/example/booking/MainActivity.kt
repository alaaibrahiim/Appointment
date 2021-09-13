package com.example.booking

import android.app.AlertDialog
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import com.example.booking.databinding.ActivityMainBinding
import java.text.DateFormat
import java.util.*

//Global references
lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBook.setVisibility(View.GONE)


        //calendar button
        val cal: Calendar = Calendar.getInstance()
        val currentDate = DateFormat.getDateInstance().format(cal.time)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        val month = cal.get(Calendar.MONTH)
        val year = cal.get(Calendar.YEAR)
        binding.btnCalendar.setOnClickListener {

            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view: DatePicker, mYear: Int, mMonth: Int, mDay: Int ->
                    val mmMonth = mMonth + 1
                    binding.edtDate.setText("" + mDay + "/" + mmMonth + "/" + mYear)

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
                Toast.makeText(this, "Current Date is $currentDate", Toast.LENGTH_LONG).show()
                return false
            }
            return true

        }


        //Morning time
        binding.btnMorning.setOnClickListener {
            var dialog1 = MorningDialog()
            dialog1.show(supportFragmentManager, "customDialog")
        }
        //Afternoon Time
        binding.btnAfternoon.setOnClickListener {
            var dialog2 = AfternoonDialog()
            dialog2.show(supportFragmentManager, "customDialog")
        }

        //Evening Time
        binding.btnEvening.setOnClickListener {
            var dialog3 = EveningDialog()
            dialog3.show(supportFragmentManager, "customDialog")
        }


        //Booking button
        binding.btnBook.setOnClickListener {

            if (!validate()) {
                Toast.makeText(this, "Booking Failed", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Booking successful", Toast.LENGTH_LONG).show()

            }

        }

        //Exit button
        binding.btnExit.setOnClickListener {
            val eBuilder = AlertDialog.Builder(this)
            eBuilder.setTitle("Exit")
            eBuilder.setIcon(R.drawable.ic_exit)
            eBuilder.setMessage("Are you sure you want to EXIT ?")
            eBuilder.setPositiveButton("Yes") { Dialog, which ->
                finish()

            }
            eBuilder.setNegativeButton("No") { Dialog, which ->
                Toast.makeText(
                    this,
                    "If you want to exit press this button again",
                    Toast.LENGTH_LONG
                ).show()

            }
            val createBuild: AlertDialog = eBuilder.create()
            createBuild.show()
        }

    }


}