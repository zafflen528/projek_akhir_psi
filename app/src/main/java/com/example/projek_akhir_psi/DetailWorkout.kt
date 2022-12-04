package com.example.projek_akhir_psi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailWorkout : AppCompatActivity() {

    lateinit var btnBack : Button
    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_workout)
        supportActionBar?.hide()

        val namalatihan = findViewById<TextView>(R.id.tv_namalatihan)
        val judullatihan = findViewById<TextView>(R.id.tv_judullatihan)
        val coverlatihan = findViewById<ImageView>(R.id.cover_latihan)
        val isilatihan = findViewById<TextView>(R.id.tv_isilatihan)
        val buttonlatihan = findViewById<Button>(R.id.buttonlatihan)
        val jenislatihan = intent.getParcelableExtra<JenisLatihan>(HomePage.INTENT_PARCELABLE)



        if (jenislatihan != null) {
            namalatihan.text = jenislatihan.nama
            judullatihan.text = "Manfaat ${jenislatihan.nama}"
            coverlatihan.setImageResource(jenislatihan.cover)
            isilatihan.text = jenislatihan.manfaat
        }


        buttonlatihan.setOnClickListener {
            val intent = Intent(buttonlatihan.context,WorkoutActivity::class.java)
            intent.putExtra(HomePage.INTENT_PARCELABLE,jenislatihan)
            startActivity(intent)
        }

        btnBack = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            this.finish()
        }



    }
}