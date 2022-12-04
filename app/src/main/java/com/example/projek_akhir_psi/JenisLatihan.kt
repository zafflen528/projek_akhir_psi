package com.example.projek_akhir_psi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class JenisLatihan(
    var image: Int,
    var cover: Int,
    var nama: String,
    var manfaat: String,
    val tahapan : ArrayList<StepWorkout>,
    val jumlahTahapan : Int
):Parcelable
