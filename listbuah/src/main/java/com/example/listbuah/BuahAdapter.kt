package com.example.listbuah

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BuahAdapter( //4. implement member
    val listNamaBuah : Array<String>,
    val listGambarBuah : Array<Int>,
    val listSuara : Array<Int>,
):RecyclerView.Adapter<BuahAdapter.ViewHolder>() { //1. awal tulis sampai sini,
    // 2. ketika view holder merah langsung refactor aja bikin class viewholder
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){ //3. selesaikan kode ini
        private val tvBuah: TextView = view.findViewById(R.id.item_rv_buah)
        private val imageBuah: ImageView = view.findViewById(R.id.item_image)
        fun bind(namaBuah: String, gambarBuah:Int, suaraBuah:Int){
            tvBuah.text = namaBuah
            imageBuah.setImageResource(gambarBuah)
            itemView.setOnClickListener{
                val mediaPlayer = MediaPlayer.create(itemView.context, suaraBuah)
                mediaPlayer.start()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_raw_buah, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listGambarBuah.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(
            listNamaBuah[position],
            listGambarBuah[position],
            listSuara[position],
        )
    }

}