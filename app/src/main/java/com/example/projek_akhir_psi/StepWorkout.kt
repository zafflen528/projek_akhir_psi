package com.example.projek_akhir_psi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class StepWorkout (
    val namaTahap : String,
    val gambarTahapan : Int,
    val repetisi : String,
    val panduan: String
    ):Parcelable
