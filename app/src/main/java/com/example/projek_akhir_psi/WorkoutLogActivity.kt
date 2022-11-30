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
        fun addLog(log:WorkoutLog) {
            logList.add(log)
        }

        fun getLog() = logList
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_log)
        supportActionBar?.hide()

        val btnTambah: Button = findViewById(R.id.btnTambah)
        btnTambah.setOnClickListener {
            val intent = Intent(this, AddLogActivity::class.java)
            startActivity(intent)
        }

        val rvWorkoutLog: RecyclerView = findViewById(R.id.recyclerView)
        val workoutLogAdapter: WorkoutLogAdapter = WorkoutLogAdapter(logList)
        rvWorkoutLog.adapter = workoutLogAdapter
        rvWorkoutLog.layoutManager = LinearLayoutManager(this)
    }
}