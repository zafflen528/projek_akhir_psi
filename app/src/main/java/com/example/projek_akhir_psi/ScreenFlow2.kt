package com.example.projek_akhir_psi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ScreenFlow2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_flow2)

        supportActionBar?.hide()

        val btnMulai = findViewById<Button>(R.id.btnMulai)

        btnMulai.setOnClickListener {
            val intent = Intent(this,HomePage::class.java)
            startActivity(intent)
            finish()
        }
    }
}