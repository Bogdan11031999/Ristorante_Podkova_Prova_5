package com.example.ristorante_podkova_prova_5

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnFloorOne = findViewById<Button>(R.id.btnFloorOne)
        val btnFloorZero = findViewById<Button>(R.id.btnFloorZero)

        btnFloorOne.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View){
                val intent = Intent(this@MainActivity, ActivityFloorOne::class.java)
                startActivity(intent)
            }
        })
        btnFloorZero.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View){
                val intent = Intent(this@MainActivity, ActivityFloorZero::class.java)
                startActivity(intent)
            }
        })


        val databaseHelper = DatabaseHelper(this)
        val db = databaseHelper.readableDatabase


        if (db != null) {
            databaseHelper.onCreate(db)
        } else {

        }


    }





}