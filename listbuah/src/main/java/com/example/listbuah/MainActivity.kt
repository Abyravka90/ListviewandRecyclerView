package com.example.listbuah

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val listNamaBuah = arrayOf("Alpukat", "Apel", "Ceri", "Durian", "Jambu Air", "Manggis", "Starwberry")

    val listGambarBuah = arrayOf(R.drawable.alpukat,
        R.drawable.apel,
        R.drawable.ceri,
        R.drawable.durian,
        R.drawable.jambuair,
        R.drawable.manggis,
        R.drawable.strawberry)

    val listSuaraBuah = arrayOf(R.raw.alpukat,
        R.raw.apel,
        R.raw.ceri,
        R.raw.durian,
        R.raw.jambu_air,
        R.raw.manggis,
        R.raw.strawberry)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val rvBuah : RecyclerView =  findViewById(R.id.rv_buah)
        val buahAdapter = BuahAdapter(listNamaBuah, listGambarBuah, listSuaraBuah)

        rvBuah.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = buahAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val rvBuah: RecyclerView=findViewById(R.id.rv_buah)
        if(item.itemId == R.id.menu_list){
            rvBuah.layoutManager = LinearLayoutManager(this@MainActivity)
        }

        if(item.itemId == R.id.menu_grid){
            val screenWithDp = resources.configuration.screenWidthDp
            if(screenWithDp >= 600){
                rvBuah.layoutManager = GridLayoutManager(this@MainActivity,4)
            }else{
                rvBuah.layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}