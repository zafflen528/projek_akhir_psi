package com.example.projek_akhir_psi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class WorkoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)
        supportActionBar?.hide()
        val tvgerakan = findViewById<TextView>(R.id.tv_gerakan)
        val tvnomor = findViewById<TextView>(R.id.tv_nomortahap)
        val tvrep = findViewById<TextView>(R.id.tv_rep)
        val tvjudul = findViewById<TextView>(R.id.tv_namalatihan)
        val imgtahap = findViewById<ImageView>(R.id.imagetahap)
        val jenislatihan = intent.getParcelableExtra<JenisLatihan>(HomePage.INTENT_PARCELABLE)

        val count = 0
        val tahap = 1
        println(jenislatihan)
        if (jenislatihan !=null){
            tvgerakan.text = jenislatihan.tahapan?.get(count)?.namaTahap
            tvnomor.text= tahap.toString()
            tvrep.text=jenislatihan.tahapan?.get(count)?.repetisi
            tvjudul.text=jenislatihan.nama
            imgtahap.setImageResource(jenislatihan.tahapan.get(count).gambarTahapan)
        }
        for (i in 0..4){
            println(jenislatihan?.tahapan?.get(i)?.namaTahap)
        }

    }
}