package com.example.ristorante_podkova_prova_5

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnFloorOne = findViewById<Button>(R.id.btnFloorOne)
        val btnFloorZero = findViewById<Button>(R.id.btnFloorZero)
        val btnResetAll = findViewById<Button>(R.id.buttonResetAll)

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
        btnResetAll.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val builder = AlertDialog.Builder(this@MainActivity)
                builder.setMessage("Вы точно хочете удалит\n все закази?")
                builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                    DatabaseHelper(this@MainActivity).updateAllColumnsToNull()
                }
                builder.setNegativeButton(android.R.string.no) { dialog, which ->

                }
                builder.show()
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