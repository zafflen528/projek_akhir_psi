package com.example.projek_akhir_psi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomePage : AppCompatActivity() {
    companion object{
        val logList = mutableListOf<WorkoutLog>()
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    private fun goToLog() {
        val logBox:View = findViewById(R.id.layoutPencatatan)
        logBox.setOnClickListener{
//            Toast.makeText(this, "logbox",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, WorkoutLogActivity::class.java)
            startActivity(intent)
        }
    }
    private fun goToArtikel() {
        val artikelBox:View = findViewById(R.id.layoutArtikel)
        artikelBox.setOnClickListener{
            val intent = Intent(this, ArtikelActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        supportActionBar?.hide()

        val list = ArrayList<JenisLatihan>()
        val listbisep = ArrayList<StepWorkout>()
        val listdada = ArrayList<StepWorkout>()
        val listkaki = ArrayList<StepWorkout>()

        list.add(JenisLatihan(resources.getIdentifier("gambar_latihan_bisep","drawable",getPackageName()),resources.getIdentifier("cover_latihan_bisep","drawable",getPackageName()), "Latihan Bisep",this.resources.getString(R.string.isibisep), listbisep, 5))
        list.add(JenisLatihan(resources.getIdentifier("gambar_latihan_dada","drawable",getPackageName()),resources.getIdentifier("cover_latihan_dada","drawable",getPackageName()), "Latihan Dada",this.resources.getString(R.string.isidada), listdada, 5))
        list.add(JenisLatihan(resources.getIdentifier("gambar_latihan_kaki_","drawable",getPackageName()),resources.getIdentifier("cover_latihan_kaki_","drawable",getPackageName()), "Latihan Kaki",this.resources.getString(R.string.isikaki), listkaki, 5))
        for (i in 0 until list.get(0).jumlahTahapan){
            list[0].tahapan.add(StepWorkout(this.resources.getStringArray(R.array.gerakan_bisep)[i], resources.getIdentifier(this.resources.getStringArray(R.array.gambar_bisep)[i],"drawable",getPackageName()), this.resources.getStringArray(R.array.repetisi_bisep)[i], this.resources.getStringArray(R.array.panduan_bisep)[i]))
        }
        for (i in 0 until list.get(1).jumlahTahapan){
            list[1].tahapan.add(StepWorkout(this.resources.getStringArray(R.array.gerakan_dada)[i], resources.getIdentifier(this.resources.getStringArray(R.array.gambar_dada)[i],"drawable",getPackageName()), this.resources.getStringArray(R.array.repetisi_dada)[i], this.resources.getStringArray(R.array.panduan_dada)[i]))
        }
        for (i in 0 until list.get(2).jumlahTahapan){
            list[2].tahapan.add(StepWorkout(this.resources.getStringArray(R.array.gerakan_kaki)[i], resources.getIdentifier(this.resources.getStringArray(R.array.gambar_kaki)[i],"drawable",getPackageName()), this.resources.getStringArray(R.array.repetisi_kaki)[i], this.resources.getStringArray(R.array.panduan_kaki)[i]))
        }

        val rvJenisLatihan: RecyclerView =  findViewById(R.id.rv_jenis_latihan)
        val listJenisLatihanAdapter = ListJenisLatihanAdapter(list)
        rvJenisLatihan.adapter = listJenisLatihanAdapter
        rvJenisLatihan.layoutManager = LinearLayoutManager(this)

        goToLog()
        goToArtikel()
    }
}