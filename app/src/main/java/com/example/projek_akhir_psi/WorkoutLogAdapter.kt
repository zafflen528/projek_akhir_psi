package com.example.projek_akhir_psi

import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class WorkoutLogAdapter(private var listWorkoutLog : MutableList<WorkoutLog>):
    RecyclerView.Adapter<WorkoutLogAdapter.ListViewHolder>() {
        inner class ListViewHolder(logView: View) : RecyclerView.ViewHolder(logView) {
            val tvTitle:TextView = logView.findViewById(R.id.tvLogTitle)
            val tvDate:TextView = logView.findViewById(R.id.tvLogDate)
            val constraintLayout: ConstraintLayout = logView.findViewById(R.id.logItemConstraint)

            val ctx = logView.context

            fun bind(workoutLog: WorkoutLog) {
                tvTitle.text = workoutLog.workoutName
                tvDate.text = workoutLog.date
                constraintLayout.setOnClickListener {
                    val intent = Intent(ctx,WorkoutLogDetail::class.java)
                    intent.apply {
                        putExtra(WorkoutLogDetail.TITLE,workoutLog.workoutName)
                        putExtra(WorkoutLogDetail.NAME, workoutLog.exerciseName)
                        putExtra(WorkoutLogDetail.REPS, workoutLog.reps)
                        putExtra(WorkoutLogDetail.SETS, workoutLog.sets)
                        putExtra(WorkoutLogDetail.DATE, workoutLog.date)
                    }
                    ctx.startActivity(intent)
                }
            }
        }

    fun setFilteredList(list : ArrayList<WorkoutLog>) {
        listWorkoutLog = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.log_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listWorkoutLog[position])
    }

    override fun getItemCount(): Int = listWorkoutLog.size
}