package com.example.projek_akhir_psi

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ArtikelActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artikel)

        supportActionBar?.hide()

        val listArtikel = ArrayList<Artikel>()

        listArtikel.add(Artikel(resources.getIdentifier("artikelsatu","drawable",getPackageName()) , this.resources.getString(R.string.judul1),this.resources.getString(R.string.isi1)))
        listArtikel.add(Artikel(resources.getIdentifier("artikelsatu","drawable",getPackageName()) , this.resources.getString(R.string.judul2),this.resources.getString(R.string.isi2)))
        listArtikel.add(Artikel(resources.getIdentifier("artikelsatu","drawable",getPackageName()) , this.resources.getString(R.string.judul3),this.resources.getString(R.string.isi3)))

        val rvArtikel: RecyclerView =  findViewById(R.id.recyclerViewArtikel)
        val listArtikelAdapter = ListArtikelAdapter(listArtikel)
        rvArtikel.adapter = listArtikelAdapter
        rvArtikel.layoutManager = LinearLayoutManager(this)

        var btnBack : Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            this.finish()
        }
    }
}