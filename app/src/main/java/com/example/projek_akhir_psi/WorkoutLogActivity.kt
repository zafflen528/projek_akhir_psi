package com.example.projek_akhir_psi

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList
import  io.reactivex.rxjava3.core.Observable
import com.jakewharton.rxbinding4.widget.TextViewBeforeTextChangeEvent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class WorkoutLogActivity : AppCompatActivity() {

    lateinit var subscription : CompositeDisposable
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

        subscription = CompositeDisposable()


        val observable_search = Observable.create(ObservableOnSubscribe<String> { subscriber ->
            search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    subscriber.onNext(query!!)
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    subscriber.onNext(newText!!)
                    return false
                }

            })

        })
            .debounce(1000, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({ text ->
                Log.d("search", "subscriber: $text")
                filterQuery(text)
            },
                {
                    Log.e("search","Erorr : $it")
                },
                {
                    Log.d("search","Complete")
                }
            )

        subscription.add(observable_search)



//        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                filterQuery(newText)
//                return true
//            }
//
//        })
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

    override fun onDestroy() {
        super.onDestroy()
        filterQuery("")
        subscription.dispose()
    }


}