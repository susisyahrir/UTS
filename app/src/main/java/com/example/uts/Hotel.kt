package com.example.uts

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hotel (
    var pic : Int,
    var nama: String,
    var lokasi : String,
    var harga : Int,
    var tanggalMasuk : String,
    var tanggalKeluar : String,
    var merokok : Boolean,
    var bentuk : Boolean): Parcelable
