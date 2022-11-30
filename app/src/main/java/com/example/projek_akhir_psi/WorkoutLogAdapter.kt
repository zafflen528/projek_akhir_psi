package com.example.projek_akhir_psi

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class WorkoutLogAdapter(private val listWorkoutLog : MutableList<WorkoutLog>):
    RecyclerView.Adapter<WorkoutLogAdapter.ListViewHolder>() {
        inner class ListViewHolder(logView: View) : RecyclerView.ViewHolder(logView) {
            //TODO
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = listWorkoutLog.size
}