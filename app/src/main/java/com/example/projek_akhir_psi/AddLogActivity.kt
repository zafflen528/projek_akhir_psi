package com.example.projek_akhir_psi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import io.reactivex.rxjava3.core.Observable
import java.sql.Date

class AddLogActivity : AppCompatActivity() {

    lateinit var btnBack : Button
    lateinit var totalRepsTv: TextView
    lateinit var btnTambah: Button
    lateinit var etReps:EditText
    lateinit var  etSets:EditText

    private fun createTotalObservable(): Observable<Int> {
        return Observable.create { emitter ->
            btnTambah.setOnClickListener {
//                emitter.onNext(etReps.text.toString())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_log)
        supportActionBar?.hide()
        btnTambah = findViewById<Button>(R.id.btnTambah)
        val etNamaLatihan = findViewById<EditText>(R.id.etNamaLatihan)
        val etDate = findViewById<EditText>(R.id.etDate)
        val etName = findViewById<EditText>(R.id.etNamaGerakan)
        etReps = findViewById(R.id.etReps)
        etSets = findViewById(R.id.etSets)

        fun clearContents() {
            etNamaLatihan.setText("")
            etDate.setText("")
            etName.setText("")
            etReps.setText("")
            etSets.setText("")
        }

        fun addToList() {

            val namaLatihan = etNamaLatihan.text.toString()
            val namaGerakan = etName.text.toString()
            val sets = etSets.text.toString()
            val reps = etReps.text.toString()
            val date = etDate.text.toString()

            if(namaLatihan.equals("")){
                Toast.makeText(this, "Nama latihan tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else if (namaGerakan.equals("")){
                Toast.makeText(this, "Nama nama gerakan yang dilakukan tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else if(sets.equals("")){
                Toast.makeText(this, "Jumlah set tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else if (reps.equals("")){
                Toast.makeText(this, "Jumlah repitisi tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else if (date.equals("")){
                Toast.makeText(this, "Tanggal latihan tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                val logOb = WorkoutLog(
                    etNamaLatihan.text.toString(),
                    etName.text.toString(),
                    Integer.parseInt(etSets.text.toString()),
                    Integer.parseInt(etReps.text.toString()),
                    etDate.text.toString()
                )

                WorkoutLogActivity.addLog(logOb)
                Toast.makeText(this, "Berhasil menambahkan catatan workout", Toast.LENGTH_SHORT).show()
            }
        }

        btnBack = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            this.finish()
        }

        btnTambah.setOnClickListener {
            // ADD to list
            // Clear contents and/or
            // Go back
            addToList()
            recreate()
        }
    }
}