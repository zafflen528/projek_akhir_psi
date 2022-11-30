package com.example.projek_akhir_psi

import java.util.Date

data class WorkoutLog(
    var workoutName: String,
    var exerciseName:String,
    var sets: Int,
    var reps: Int,
    var date: Date,
)
