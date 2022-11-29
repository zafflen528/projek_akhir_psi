package com.example.projek_akhir_psi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListJenisLatihanAdapter(private val listLatihan: ArrayList<JenisLatihan>):
    RecyclerView.Adapter<ListJenisLatihanAdapter.ListViewHolder>() {
        inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var imgPhoto: ImageView = itemView.findViewById(R.id.ivLatihanRV)
            var tvNamaLatihan: TextView = itemView.findViewById(R.id.tvJenisLatihanRV)

            fun bind(jenis_latihan: JenisLatihan) {
                with(itemView){
                    com.bumptech.glide.Glide.with(itemView.context).load(jenis_latihan.image).into(imgPhoto)
                    tvNamaLatihan.text = jenis_latihan.nama
                }
                imgPhoto.setOnClickListener {
                    Toast.makeText( itemView.context, "Kamu memilih ${jenis_latihan.nama}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate( R.layout.layout_latihan, viewGroup, false)
        return ListViewHolder(view)
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listLatihan[position])
    }
    override fun getItemCount(): Int = listLatihan.size
    // comment
}
