package com.example.projek_akhir_psi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class WorkoutLogDetail : AppCompatActivity() {

    companion object {
        const val TITLE = "title"
        const val DATE = "date"
        const val NAME = "name"
        const val REPS = "reps"
        const val SETS = "sets"
    }

    private fun calcTotal(sets:Int,reps:Int): Int {
        return sets * reps
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        val tvTitle: TextView = findViewById(R.id.tvInnerLogTitle)
        val tvDate: TextView = findViewById(R.id.tvInnerLogDate)
        val tvNameContent:TextView = findViewById(R.id.tvNameContent)
        val tvRepsContent:TextView = findViewById(R.id.tvRepsContent)
        val tvSetsContent:TextView = findViewById(R.id.tvSetContent)
        val tvTotalContent:TextView = findViewById(R.id.tvTotalContent)

        tvTitle.text = intent.getStringExtra(TITLE)
        tvDate.text = intent.getStringExtra(DATE)
        tvNameContent.text = intent.getStringExtra(NAME)
        tvRepsContent.text = getString(R.string.repetisi,intent.getIntExtra(REPS,0))
        tvSetsContent.text = getString(R.string.set,intent.getIntExtra(SETS,0))
        tvTotalContent.text =
            getString(R.string.repetisi,
                calcTotal(
                    intent.getIntExtra(REPS,0),
                    intent.getIntExtra(SETS,0)
                )
            )
    }
}