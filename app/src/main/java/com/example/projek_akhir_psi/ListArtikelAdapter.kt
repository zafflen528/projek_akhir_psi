package com.example.projek_akhir_psi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListArtikelAdapter(private val listArtikel: ArrayList<Artikel>):
    RecyclerView.Adapter<ListArtikelAdapter.ListViewHolder>() {
        inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imgArtikel: ImageView = itemView.findViewById(R.id.img_artikel)
            val tvJudul: TextView = itemView.findViewById(R.id.tv_judul)
            val btnBaca : Button = itemView.findViewById(R.id.btn_baca)

            fun bind(artikel: Artikel) {
                with(itemView) {
                    Glide.with(itemView.context).load(artikel.image)
                        .into(imgArtikel)
                    tvJudul.text = artikel.judul
                }
//                btnBaca.setOnClickListener {
//                    val intent = Intent(itemView.context,DetailWorkout::class.java)
//                    intent.apply {
//                        putExtra(DetailWorkout.EXTRA_NAME,jenis_latihan.nama)
//                    }
//                    itemView.context.startActivity(intent)
//                }
            }
        }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.artikel_item, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listArtikel[position])
    }

    override fun getItemCount(): Int = listArtikel.size
}
