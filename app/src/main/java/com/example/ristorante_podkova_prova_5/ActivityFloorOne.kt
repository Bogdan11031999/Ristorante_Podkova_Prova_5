package com.example.ristorante_podkova_prova_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ActivityFloorOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floor_one)
        val listView = findViewById<ListView>(R.id.listView)

        val dataList = listOf("СТОЛ 1", "СТОЛ 2", "СТОЛ 3", "СТОЛ 4", "СТОЛ 5", "СТОЛ 6", "СТОЛ 7", "СТОЛ 8", "СТОЛ 9", "СТОЛ 10")
        val adapter = CustomListAdapter(this, dataList)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            when (position) {
                0 -> startNewActivity(ActivityTable::class.java, 1, 1)
                1 -> startNewActivity(ActivityTable::class.java, 1, 2)
                2 -> startNewActivity(ActivityTable::class.java, 1, 3)
                3 -> startNewActivity(ActivityTable::class.java, 1, 4)
                4 -> startNewActivity(ActivityTable::class.java, 1, 5)
                5 -> startNewActivity(ActivityTable::class.java, 1, 6)
                6 -> startNewActivity(ActivityTable::class.java, 1, 7)
                7 -> startNewActivity(ActivityTable::class.java, 1, 8)
                8 -> startNewActivity(ActivityTable::class.java, 1, 9)
                9 -> startNewActivity(ActivityTable::class.java, 1, 10)
            }
        }
    }

    private fun startNewActivity(activityClass: Class<*>, int1: Int, int2: Int) {
        val intent = Intent(this, activityClass)
        intent.putExtra("piano", int1)
        intent.putExtra("tavolo", int2)
        startActivity(intent)
    }
}