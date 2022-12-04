package com.example.projek_akhir_psi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import org.w3c.dom.Text

class Panduan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_panduan_gerakan)
        val tvLangkah = findViewById<TextView>(R.id.tvLangkahWorkout)
        val tvNama= findViewById<TextView>(R.id.tvNamaWorkoutPanduanGerakan)
        val imgtahap = findViewById<ImageView>(R.id.imagePanduan)
        val step = intent.getParcelableExtra<StepWorkout>(WorkoutActivity.INTENT_PANDUAN)

        if (step !=null){
            imgtahap.setImageResource(step.gambarTahapan)
            tvNama.text = step.namaTahap
            tvLangkah.text = step.panduan
        }

        findViewById<Button>(R.id.btnTutupPanduan).setOnClickListener {
            finish()
        }
    }
}