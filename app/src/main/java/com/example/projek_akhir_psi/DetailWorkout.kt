package com.example.projek_akhir_psi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailWorkout : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "EXTRA_NAME"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_workout)
        supportActionBar?.hide()

        val ind = findViewById<TextView>(R.id.tvNamaWorkout)
        ind.text = intent.getStringExtra(EXTRA_NAME)
    }
}