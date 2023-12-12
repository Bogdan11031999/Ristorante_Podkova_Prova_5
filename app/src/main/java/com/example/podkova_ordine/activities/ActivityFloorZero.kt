package com.example.podkova_ordine.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.podkova_ordine.customs.CustomListAdapter
import com.example.podkova_ordine.DatiQuery
import com.example.podkova_ordine.R

class ActivityFloorZero : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floor_zero)
        val listView = findViewById<ListView>(R.id.listView)

        val dataList = listOf("СТОЛ 1", "СТОЛ 2", "СТОЛ 3", "СТОЛ 4", "СТОЛ 5", "СТОЛ 6", "СТОЛ 7", "СТОЛ 8", "СТОЛ 9", "СТОЛ 10")
        val adapter = CustomListAdapter(this, dataList)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            when (position) {
                0 -> startNewActivity(ActivityType::class.java, 0, 1)
                1 -> startNewActivity(ActivityType::class.java, 0, 2)
                2 -> startNewActivity(ActivityType::class.java, 0, 3)
                3 -> startNewActivity(ActivityType::class.java, 0, 4)
                4 -> startNewActivity(ActivityType::class.java, 0, 5)
                5 -> startNewActivity(ActivityType::class.java, 0, 6)
                6 -> startNewActivity(ActivityType::class.java, 0, 7)
                7 -> startNewActivity(ActivityType::class.java, 0, 8)
                8 -> startNewActivity(ActivityType::class.java, 0, 9)
                9 -> startNewActivity(ActivityType::class.java, 0, 10)
            }
        }
    }

    private fun startNewActivity(activityClass: Class<*>, int1: Int, int2: Int) {
        val intent = Intent(this, activityClass)
        DatiQuery.tabella ="Холодные закуски"
        DatiQuery.tavolo =int2.toString()
        DatiQuery.piano =int1.toString()
        startActivity(intent)
    }
}