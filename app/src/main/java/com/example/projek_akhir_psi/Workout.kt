package com.example.projek_akhir_psi

data class Workout(
    val nama : String,
    val cover : Int,
    val gambarDetail : Int,
    val tahapan : ArrayList<StepWorkout>,
    val jumlahTahapan : Int
)
