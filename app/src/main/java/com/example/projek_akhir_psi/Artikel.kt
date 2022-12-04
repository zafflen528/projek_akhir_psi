package com.example.projek_akhir_psi


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artikel(
    var image: Int,
    var judul: String,
    var isi:String
):Parcelable

