package com.example.projek_akhir_psi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        val list = ArrayList<JenisLatihan>()

        supportActionBar?.hide()

        list.add(JenisLatihan(resources.getIdentifier("gambar_latihan_dada","drawable",getPackageName()), "Latihan Dada"))
        list.add(JenisLatihan(resources.getIdentifier("gambar_latihan_bisep","drawable",getPackageName()), "Latihan Bisep"))
        list.add(JenisLatihan(resources.getIdentifier("gambar_latihan_kaki_","drawable",getPackageName()), "Latihan Kaki"))

        val rvHeroes: RecyclerView =  findViewById(R.id.rv_jenis_latihan)
        val listJenisLatihanAdapter = ListJenisLatihanAdapter(list)
        rvHeroes.adapter = listJenisLatihanAdapter
        rvHeroes.layoutManager = LinearLayoutManager(this)
    }
}