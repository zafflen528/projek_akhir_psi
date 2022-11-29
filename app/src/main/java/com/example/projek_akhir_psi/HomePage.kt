package com.example.projek_akhir_psi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomePage : AppCompatActivity() {
    fun goToLog() {
        val logBox:View = findViewById(R.id.layoutPencatatan)
        logBox.setOnClickListener{
            Toast.makeText(this, "logbox",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, WorkoutLogActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        supportActionBar?.hide()

        val list = ArrayList<JenisLatihan>()

        list.add(JenisLatihan(resources.getIdentifier("gambar_latihan_bisep","drawable",getPackageName()), "Latihan Dada"))
        list.add(JenisLatihan(resources.getIdentifier("gambar_latihan_dada","drawable",getPackageName()), "Latihan Bisep"))
        list.add(JenisLatihan(resources.getIdentifier("gambar_latihan_kaki_","drawable",getPackageName()), "Latihan Kaki"))
        val rvJenisLatihan: RecyclerView =  findViewById(R.id.rv_jenis_latihan)
        val listJenisLatihanAdapter = ListJenisLatihanAdapter(list)
        rvJenisLatihan.adapter = listJenisLatihanAdapter
        rvJenisLatihan.layoutManager = LinearLayoutManager(this)

        goToLog()
    }
}