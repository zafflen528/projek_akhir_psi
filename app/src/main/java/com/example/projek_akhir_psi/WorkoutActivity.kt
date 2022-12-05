package com.example.projek_akhir_psi

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.SyncStateContract.Helpers.update
import android.view.View
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
                if (count == 0){
                    btnkembali.visibility = View.GONE
                    btnkembali.isEnabled = false
                }else{
                    btnkembali.visibility=View.VISIBLE
                    btnkembali.isEnabled = true
                }

                if (tahap==jenislatihan.jumlahTahapan){
                    btnlanjut.text = "Selesai"
                    btnlanjut.setOnClickListener{
                        this.finish()
                    }
                }else{
                    btnlanjut.text = "Lanjut"
                    btnlanjut.setOnClickListener {
                        count++
                        tahap++
                        update()
                        btnkembali.isEnabled=true
                    }
                }

            }
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

        update()

        for (i in 0..4){
            println(jenislatihan?.tahapan?.get(i)?.namaTahap)
        }





        btnpanduan.setOnClickListener {
            val intent = Intent(this, Panduan::class.java)
            intent.putExtra(INTENT_PANDUAN, jenislatihan?.tahapan?.get(count))
            startActivity(intent)
        }

        var btnBack : Button= findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            this.finish()
        }


    }
}