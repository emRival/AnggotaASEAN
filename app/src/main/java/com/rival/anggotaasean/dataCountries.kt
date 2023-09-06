package com.rival.anggotaasean

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class dataCountries(
    val name: String,
    val description: String,
    val namaNegara: String,
    val kepalaNegara: String,
    val kepalaPemerintahan: String,
    val ibukota: String,
    val hariKemerdekaan: String,
    val bahasa: String,
    val mataUang: String,
    val populasi: String,
    val gdp: String,
    val gdpKapita: String,
    val luasWilayah: String,
    val image: Int
) : Parcelable
