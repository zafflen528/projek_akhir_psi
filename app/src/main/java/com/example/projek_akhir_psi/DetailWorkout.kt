package com.example.projek_akhir_psi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import android.view.MotionEvent
import androidx.core.graphics.drawable.DrawableCompat.inflate
import org.w3c.dom.Text


class DetailWorkout : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "EXTRA_NAME"
    }


    private fun goToPanduan() {
        val tvPanduan:View = findViewById<TextView>(R.id.tvPanduanGerakan)
        tvPanduan.setOnClickListener{
//            val window = PopupWindow(this)
//            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
//            val popupView = inflater.inflate(R.layout.layout_panduan_gerakan, null)
//            val wid = LinearLayout.LayoutParams.WRAP_CONTENT
//            val high = LinearLayout.LayoutParams.WRAP_CONTENT
//            val focus= true
//            val popupWindow = PopupWindow(popupView, wid, high, focus)
//
//            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
//
//            findViewById<Button>(R.id.btnTutupPanduan).setOnTouchListener { v, event ->
//                popupWindow.dismiss()     // It will dismiss the popup window when tapped in it
//                true
//            }

//            val view = inflater.inflate(R.layout.layout_panduan_gerakan, null)
//            window.contentView = view
//            val tutup = findViewById<Button>(R.id.btnTutupPanduan)
//            tutup.setOnClickListener {
//                window.dismiss()
//            }
//            window.showAsDropDown(tvPanduan)

            Toast.makeText(this,"panduan", Toast.LENGTH_SHORT)
            val intent = Intent(this, Panduan::class.java)
            intent.putExtra("index", 0)
            startActivity(intent)
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_workout)
        supportActionBar?.hide()

        val ind = findViewById<TextView>(R.id.tvNamaWorkout)
        ind.text = intent.getStringExtra(EXTRA_NAME)
        goToPanduan()

        //data untuk popup



//        goToPanduan(this)
    }

}