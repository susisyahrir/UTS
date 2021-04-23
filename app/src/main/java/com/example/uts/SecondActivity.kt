package com.example.uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //h akan menampung data dri MainActivity
        var h = intent.getParcelableExtra<Hotel>(EXTRA_HOTEL)

        namaHotel2.text=h?.nama
        lokasiHotel2.text = h?.lokasi
        payment.text = h?.harga.toString()
        tanggalIn2.text = h?.tanggalMasuk
        tanggalOut2.text = h?.tanggalKeluar

        var rokok =""
        var bed =""
        if (h?.merokok!!)
            rokok = "Smoking Area"
        else
            rokok = "Non-Smoking Area"

        if (h?.bentuk!!)
            bed = "Single Bed"
        else
            bed = "Double Bed"

        ket.text = "${bed} ${rokok}"
    }
}