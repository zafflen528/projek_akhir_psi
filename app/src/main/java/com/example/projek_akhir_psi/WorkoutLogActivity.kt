package com.example.projek_akhir_psi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList

class WorkoutLogActivity : AppCompatActivity() {


   lateinit var search : SearchView
   lateinit var workoutLogAdapter: WorkoutLogAdapter
    companion object {
        var logList = mutableListOf<WorkoutLog>()
        fun addLog(log:WorkoutLog) {
            logList.add(log)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_log)
        supportActionBar?.hide()


        search = findViewById(R.id.search)
        val btnTambah: Button = findViewById(R.id.btnTambah)
        btnTambah.setOnClickListener {
            val intent = Intent(this, AddLogActivity::class.java)
            startActivity(intent)
        }
        setData()
        val rvWorkoutLog: RecyclerView = findViewById(R.id.recyclerView)
        workoutLogAdapter = WorkoutLogAdapter(logList)
        rvWorkoutLog.adapter = workoutLogAdapter
        rvWorkoutLog.layoutManager = LinearLayoutManager(this)

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }

    fun filterList(query : String?){
        val filteredList =  ArrayList<WorkoutLog>()
        if(query != null){
            for (i in logList){
                if (i.workoutName.toLowerCase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }
        }

        if (filteredList.isEmpty()){
            Toast.makeText(this,"Catatan tidak ditemukan",Toast.LENGTH_SHORT).show()
        }else{
            workoutLogAdapter.setFilteredList(filteredList)
        }
    }

    fun setData(){
        if(logList.isEmpty()){
            logList.add(WorkoutLog("build,","aaa",2,3,"12/31/2022"))
        }

    }
}