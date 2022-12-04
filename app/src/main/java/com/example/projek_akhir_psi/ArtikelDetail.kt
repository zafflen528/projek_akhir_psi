package com.example.projek_akhir_psi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ArtikelDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artikel_detail)

        supportActionBar?.hide()
        val artikel = intent.getParcelableExtra<Artikel>(ArtikelActivity.INTENT_PARCELABLE)

        val image = findViewById<ImageView>(R.id.cover_artikel)
        val judul = findViewById<TextView>(R.id.tv_juduldetail)
        val isi = findViewById<TextView>(R.id.tv_isidetail)

        image.setImageResource(artikel?.image!!)
        judul.text = artikel.judul
        isi.text = artikel.isi

        val btnBack : Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            this.finish()
        }
    }
}