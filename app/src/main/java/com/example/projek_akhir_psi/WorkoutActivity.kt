package com.example.projek_akhir_psi

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class WorkoutActivity : AppCompatActivity() {
    companion object{
        val INTENT_PANDUAN = "OBJECT_INTENT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)
        supportActionBar?.hide()
        val tvgerakan = findViewById<TextView>(R.id.tv_gerakan)
        val tvnomor = findViewById<TextView>(R.id.tv_nomortahap)
        val tvrep = findViewById<TextView>(R.id.tv_rep)
        val tvjudul = findViewById<TextView>(R.id.tv_namalatihan)
        val imgtahap = findViewById<ImageView>(R.id.imagetahap)
        val btnlanjut = findViewById<Button>(R.id.btn_lanjut)
        val btnkembali = findViewById<Button>(R.id.btn_kembali)
        val buttonback = findViewById<Button>(R.id.button)
        val btnpanduan = findViewById<Button>(R.id.btn_panduan)
        val jenislatihan = intent.getParcelableExtra<JenisLatihan>(HomePage.INTENT_PARCELABLE)


        var count = 0
        var tahap = 1
        println(jenislatihan)

        fun update(){
            if (jenislatihan !=null){
                tvgerakan.text = jenislatihan.tahapan?.get(count)?.namaTahap
                tvnomor.text= "${tahap.toString()}/${jenislatihan.jumlahTahapan} Gerakan"
                tvrep.text=jenislatihan.tahapan?.get(count)?.repetisi
                tvjudul.text=jenislatihan.nama
                imgtahap.setImageResource(jenislatihan.tahapan.get(count).gambarTahapan)
                btnkembali.isEnabled = count != 0
                if (tahap==jenislatihan.jumlahTahapan){
                    btnlanjut.text = "Selesai"
                    btnlanjut.setOnClickListener{
                        this.finish()
                    }
                }

            }
        }
        update()

        for (i in 0..4){
            println(jenislatihan?.tahapan?.get(i)?.namaTahap)
        }

        btnkembali.setOnClickListener{
            count--
            tahap--
            update()
            btnlanjut.isEnabled=true
        }
        btnlanjut.setOnClickListener{
            count++
            tahap++
            update()
            btnkembali.isEnabled=true
        }
        buttonback.setOnClickListener {
            this.finish()
        }


//        val tvPanduan= findViewById<TextView>(R.id.btn_panduan)
//        tvPanduan.setOnClickListener{
////            Toast.makeText(this,"panduan", Toast.LENGTH_SHORT)
//            val intent = Intent(this, Panduan::class.java)
//            intent.putExtra("index", count)
//            intent.putExtra(HomePage.INTENT_PARCELABLE,jenislatihan)
//            startActivity(intent)
//        }

        btnpanduan.setOnClickListener {
            val intent = Intent(this, Panduan::class.java)
            intent.putExtra("index", count)
            intent.putExtra(HomePage.INTENT_PARCELABLE,jenislatihan)
            startActivity(intent)
        }


    }
}