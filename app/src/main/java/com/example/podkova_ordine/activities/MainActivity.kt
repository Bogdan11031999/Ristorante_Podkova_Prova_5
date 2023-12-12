package com.example.podkova_ordine.activities
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.podkova_ordine.DatabaseHelper
import com.example.podkova_ordine.R

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

    override fun attachBaseContext(newBase: Context) {
        // Imposta la scala del font desiderata (ad esempio 1.0 per il default)
        val overrideConfiguration = Configuration(newBase.resources.configuration)
        overrideConfiguration.fontScale = 1.0f

        // Applica la configurazione al contesto dell'attività
        val context: Context = newBase.createConfigurationContext(overrideConfiguration)
        super.attachBaseContext(context)
    }




}