package com.example.uts

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Integer.parseInt
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
        var harga = parseInt(hargaHotel.text.toString())
        tanggalIn.setOnClickListener{
            val datePickerDialog = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener {
                        view, year, monthOfYear, dayOfMonth ->
                    // Display Selected date in TextView
                    tanggalIn.setText("$dayOfMonth / ${monthOfYear+1} / $year")
                }, year, month, day)
            tanggalMasuk = tanggalIn.text.toString()

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
            tanggalKeluar = tanggalOut.text.toString()

            datePickerDialog.datePicker.minDate = Calendar.getInstance().timeInMillis
            datePickerDialog.show()
        }

        var intentSecondActivity = Intent(this, SecondActivity::class.java)

        var smoking = true
        var bed = true
        btn_Book.setOnClickListener {
            if(rdn_smoking.isChecked())
                smoking = true
            else
                smoking = false
            if(rdn_single.isChecked())
                bed = true
            else
                bed = false
            var h = Hotel(R.drawable.ic_action_date,
                "Banamas Hotel",
                "Location : Amabd No. 123",
                harga,
                tanggalMasuk,
                tanggalKeluar,
                smoking,
                bed )
            //kirim data dgn parcelable
            intentSecondActivity.putExtra(EXTRA_HOTEL, h)
            startActivity(intentSecondActivity)
        }




    }
}