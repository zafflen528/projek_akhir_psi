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
        val jenislatihan = intent.getParcelableExtra<JenisLatihan>(HomePage.INTENT_PARCELABLE)

        val index = getIntent().getIntExtra("index",-1);

        if (jenislatihan !=null){
            imgtahap.setImageResource(jenislatihan.tahapan.get(index).gambarTahapan)
//            tvNama.text = jenislatihan.tahapan?.get(index)?.namaTahap
            tvNama.text = index.toString()
            tvLangkah.text = jenislatihan.tahapan?.get(index)?.panduan
        }

        findViewById<Button>(R.id.btnTutupPanduan).setOnClickListener {
            val intent = Intent(this, WorkoutActivity::class.java)
            intent.putExtra("index", index)
            intent.putExtra(HomePage.INTENT_PARCELABLE,jenislatihan)
            startActivity(intent)
        }
//        tvLangkah.setText(arr[index]);
    }
}