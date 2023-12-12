package com.example.podkova_ordine.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.podkova_ordine.customs.CustomListAdapter
import com.example.podkova_ordine.DatiQuery
import com.example.podkova_ordine.R

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
                0 -> startNewActivity(ActivityType::class.java, 1, 1)
                1 -> startNewActivity(ActivityType::class.java, 1, 2)
                2 -> startNewActivity(ActivityType::class.java, 1, 3)
                3 -> startNewActivity(ActivityType::class.java, 1, 4)
                4 -> startNewActivity(ActivityType::class.java, 1, 5)
                5 -> startNewActivity(ActivityType::class.java, 1, 6)
                6 -> startNewActivity(ActivityType::class.java, 1, 7)
                7 -> startNewActivity(ActivityType::class.java, 1, 8)
                8 -> startNewActivity(ActivityType::class.java, 1, 9)
                9 -> startNewActivity(ActivityType::class.java, 1, 10)
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