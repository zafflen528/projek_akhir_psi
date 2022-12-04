package com.example.projek_akhir_psi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.sql.Date

class AddLogActivity : AppCompatActivity() {

    lateinit var btnBack : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_log)
        supportActionBar?.hide()
        val btnTambah = findViewById<Button>(R.id.btnTambah)
        val etNamaLatihan = findViewById<EditText>(R.id.etNamaLatihan)
        val etDate = findViewById<EditText>(R.id.etDate)
        val etName = findViewById<EditText>(R.id.etNamaGerakan)
        val etReps = findViewById<EditText>(R.id.etReps)
        val etSets = findViewById<EditText>(R.id.etSets)

        fun clearContents() {
            etNamaLatihan.setText("")
            etDate.setText("")
            etName.setText("")
            etReps.setText("")
            etSets.setText("")
        }

        fun addToList() {
            val logOb= WorkoutLog(
                etNamaLatihan.text.toString(),
                etName.text.toString(),
                Integer.parseInt(etSets.text.toString()),
                Integer.parseInt(etReps.text.toString()),
                etDate.text.toString()
            )
            WorkoutLogActivity.addLog(logOb)
            Toast.makeText(this, "Successfully added a workout log!", Toast.LENGTH_SHORT).show()
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
            clearContents()
        }
    }
}