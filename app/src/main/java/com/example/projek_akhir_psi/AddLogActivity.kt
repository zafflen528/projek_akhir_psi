package com.example.projek_akhir_psi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.sql.Date

class AddLogActivity : AppCompatActivity() {
    private val btnTambah: Button = findViewById(R.id.btnTambah)
    private val etNamaLatihan = findViewById<EditText>(R.id.etNamaLatihan)
    private val etDate = findViewById<EditText>(R.id.etDate)
    private val etName = findViewById<EditText>(R.id.etNamaGerakan)
    private val etReps = findViewById<EditText>(R.id.etReps)
    private val etSets = findViewById<EditText>(R.id.etSets)

    private fun addToList() {
        val logOb:WorkoutLog = WorkoutLog(
            etNamaLatihan.text.toString(),
            etName.text.toString(),
            Integer.parseInt(etSets.text.toString()),
            Integer.parseInt(etReps.text.toString()),
            Date.valueOf(etDate.text.toString())
        )
        WorkoutLogActivity.addLog(logOb)
        Toast.makeText(this, "Successfully added a workout log!", Toast.LENGTH_SHORT).show()
    }

    private fun clearContents() {
        etNamaLatihan.setText("")
        etDate.setText("")
        etName.setText("")
        etReps.setText("")
        etSets.setText("")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_log)
        btnTambah.setOnClickListener {
            // ADD to list
            // Clear contents and/or
            // Go back
            addToList()
            clearContents()
            finish()
        }

    }
}