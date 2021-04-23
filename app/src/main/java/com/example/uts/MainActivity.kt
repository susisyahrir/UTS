package com.example.uts

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        var tanggalMasuk =""
        var tanggalKeluar=""
        tanggalIn.setOnClickListener{
            val datePickerDialog = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener {
                        view, year, monthOfYear, dayOfMonth ->
                    // Display Selected date in TextView
                    tanggalIn.setText("$dayOfMonth / ${monthOfYear+1} / $year")
                }, year, month, day)
            tanggalMasuk = tanggalIn.toString()

            datePickerDialog.datePicker.minDate = Calendar.getInstance().timeInMillis
            datePickerDialog.show()
        }

        tanggalOut.setOnClickListener{
            val datePickerDialog = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener {
                        view, year, monthOfYear, dayOfMonth ->
                    // Display Selected date in TextView
                    tanggalOut.setText("$dayOfMonth / ${monthOfYear+1} / $year")
                }, year, month, day)
            tanggalKeluar = tanggalOut.toString()

            datePickerDialog.datePicker.minDate = Calendar.getInstance().timeInMillis
            datePickerDialog.show()
        }



        var h = Hotel(R.drawable.ic_action_date, "Banamas Hotel", "Location : Amabd No. 123", 30, tanggalMasuk, tanggalKeluar, true, true )

    }
}