package com.example.projek_akhir_psi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList
import  io.reactivex.rxjava3.core.Observable
import com.jakewharton.rxbinding4.widget.TextViewBeforeTextChangeEvent

class WorkoutLogActivity : AppCompatActivity() {

    lateinit var search : SearchView
    lateinit var btnBack : Button

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
        val titleArr: Array<String> = resources.getStringArray(R.array.title_array)
        val exerciseArr: Array<String> = resources.getStringArray(R.array.exercise_array)
        val setsArr: IntArray = resources.getIntArray(R.array.sets_array)
        val repsArr: IntArray = resources.getIntArray(R.array.reps_array)
        val dateArr: Array<String> = resources.getStringArray(R.array.date_array)
        for (i in 0 .. 4) {
            addLog(WorkoutLog(titleArr[i],exerciseArr[i],setsArr[i],repsArr[i],dateArr[i]))
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_log)
        supportActionBar?.hide()
        rvWorkoutLog = findViewById(R.id.recyclerView)
        search = findViewById(R.id.search)

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

        btnBack = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            this.finish()
        }

        rvWorkoutLog.adapter = workoutLogAdapter
        rvWorkoutLog.layoutManager = LinearLayoutManager(this)

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterQuery(newText)
                return true
            }

        })
    }

    private fun validateForm() {
        //reactive
    }

    private fun filterQuery(query : String?) {
        if (query != null){
            val filteredList = ArrayList<WorkoutLog>()
            for (i in logList){
                if (i.workoutName.lowercase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()){
                Toast.makeText(this, "Catatan tidak ditemukan,",Toast.LENGTH_SHORT).show()
            }else{
                workoutLogAdapter.setFilteredList(filteredList)
            }
        }


    }


}