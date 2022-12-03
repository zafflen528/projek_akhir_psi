package com.example.projek_akhir_psi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
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


    private fun populate() {
        addLog(
            WorkoutLog(
                getString(R.string.title1),
                getString(R.string.exercise1),
                resources.getInteger(R.integer.sets1),
                resources.getInteger(R.integer.reps1),
                getString(R.string.date1)
            )
        )
        addLog(
            WorkoutLog(
                getString(R.string.title2),
                getString(R.string.exercise2),
                resources.getInteger(R.integer.sets2),
                resources.getInteger(R.integer.reps2),
                getString(R.string.date2)
            )
        )
        addLog(
            WorkoutLog(
                getString(R.string.title3),
                getString(R.string.exercise3),
                resources.getInteger(R.integer.sets3),
                resources.getInteger(R.integer.reps3),
                getString(R.string.date3)
            )
        )
        addLog(
            WorkoutLog(
                getString(R.string.title4),
                getString(R.string.exercise4),
                resources.getInteger(R.integer.sets4),
                resources.getInteger(R.integer.reps4),
                getString(R.string.date4)
            )
        )
        addLog(
            WorkoutLog(
                getString(R.string.title5),
                getString(R.string.exercise5),
                resources.getInteger(R.integer.sets5),
                resources.getInteger(R.integer.reps5),
                getString(R.string.date5)
            )
        )
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
        btnTambah.setOnLongClickListener {
            populate()
            Toast.makeText(this, "Added some workout logs!", Toast.LENGTH_LONG).show()
            false
        }

        rvWorkoutLog.adapter = workoutLogAdapter
        rvWorkoutLog.layoutManager = LinearLayoutManager(this)
    }
}