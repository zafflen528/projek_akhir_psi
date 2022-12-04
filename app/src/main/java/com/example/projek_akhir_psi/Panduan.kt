package com.example.projek_akhir_psi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import org.w3c.dom.Text

class Panduan : AppCompatActivity() {

    private var popupNamaWorkout = ""
    private var popupImage = ""
    private var popupLangkah = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        overridePendingTransition(0,0)
        setContentView(R.layout.layout_panduan_gerakan)

        val arr = arrayOf("Berdirilah di tengah-tengah pintu yang terbuka.\n" +
                "Peganglah kedua sisi kosen pintu.\n" +
                "Condongkan tubuh ke depan pintu dengan melangkahkan salah satu kaki kedepan hingga melewati dada dan bahu.\n" +
                "Tahan selama 30 detik kemudian ulangi\n")
        val tvLangkah:TextView = findViewById(R.id.tvLangkahWorkout)
        val index = getIntent().getIntExtra("index",-1);
        tvLangkah.setText(arr[index]);





//        val bundle = intent.extras
//        popupNamaWorkout = bundle?.getString("popupNamaWorkout","namaWorkout") ?: ""
//        popupImage = bundle?.getString("popupImage","imageWorkout") ?: ""
//        popupLangkah = bundle?.getString("popupLangkah","langkahWorkout") ?: ""

//        findViewById<ImageView>(R.id.ivPanduanGerakan).
//        findViewById<TextView>(R.id.tvNamaWorkoutPanduanGerakan).text = popupNamaWorkout
//        findViewById<TextView>(R.id.tvLangkahWorkout).text = popupLangkah
    }
}