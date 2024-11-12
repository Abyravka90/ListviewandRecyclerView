package com.example.listviewandrecyclerview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
        val kucing = arrayOf("Persia", "Anggora", "Himalaya", "Peeknos", "Rumahan", "Garong")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listView : ListView = findViewById(R.id.list_view)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, kucing)

        listView.adapter = adapter
        listView.setOnItemClickListener{_,_,index,_ ->
            Toast.makeText(this, "Anda Memilih Kucing ${kucing[index]}", Toast.LENGTH_SHORT).show()
        }
    }
}