package com.example.projek_akhir_psi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WorkoutLogActivity : AppCompatActivity() {

    companion object {
        private val logList = mutableListOf<WorkoutLog>()
        val workoutLogAdapter = WorkoutLogAdapter(logList)
        lateinit var rvWorkoutLog: RecyclerView
        fun addLog(log:WorkoutLog) {
            logList.add(log)
            workoutLogAdapter.notifyDataSetChanged()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_log)
        supportActionBar?.hide()
        rvWorkoutLog = findViewById(R.id.recyclerView)

        val btnTambah: Button = findViewById(R.id.btnTambah)
        btnTambah.setOnClickListener {
            val intent = Intent(this, AddLogActivity::class.java)
            startActivity(intent)
        }

        rvWorkoutLog.adapter = workoutLogAdapter
        rvWorkoutLog.layoutManager = LinearLayoutManager(this)
    }
}