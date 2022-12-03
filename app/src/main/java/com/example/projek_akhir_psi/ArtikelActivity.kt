package com.example.projek_akhir_psi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ArtikelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artikel)

        supportActionBar?.hide()

        val listArtikel = ArrayList<Artikel>()

        listArtikel.add(Artikel(resources.getIdentifier("artikelsatu","drawable",getPackageName()), "Latihan Dada"))
        listArtikel.add(Artikel(resources.getIdentifier("gambar_latihan_dada","drawable",getPackageName()), "Latihan Bisep"))
        listArtikel.add(Artikel(resources.getIdentifier("gambar_latihan_kaki_","drawable",getPackageName()), "Latihan Kaki"))
        val rvArtikel: RecyclerView =  findViewById(R.id.recyclerViewArtikel)
        val listArtikelAdapter = ListArtikelAdapter(listArtikel)
        rvArtikel.adapter = listArtikelAdapter
        rvArtikel.layoutManager = LinearLayoutManager(this)
    }
}