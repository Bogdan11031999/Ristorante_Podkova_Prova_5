package com.example.ristorante_podkova_prova_5

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class ActivityTable() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)
        val floor = intent.getIntExtra("piano", 0)
        val table = intent.getIntExtra("tavolo", 0)
        val textView = findViewById<TextView>(R.id.textViewTable)
        textView.setText("ЭТАЖ: "+floor+" СТОЛ: "+table)
        val listViewMenu = findViewById<ListView>(R.id.listViewTable)
        val buttonOrder = findViewById<Button>(R.id.buttonOrder);
        val buttonDelete = findViewById<Button>(R.id.buttonDelete)

        val dataList = listOf("Холодные закуски", "Икра", "Горячие закуски", "Первые блюда", "Вторые мясные блюда", "Вторые рыбные блюда","Гарнир")
        val adapter = CustomListAdapter(this, dataList)
        listViewMenu.adapter = adapter
        listViewMenu.setOnItemClickListener { parent, view, position, id ->
            when (position) {
                0 -> startNewActivity(ActivityType::class.java,"Холодные закуски",floor, table)
                1 -> startNewActivity(ActivityType::class.java,"Икра",floor, table)
                2 -> startNewActivity(ActivityType::class.java,"Горячие закуски",floor, table)
                3 -> startNewActivity(ActivityType::class.java,"Первые блюда",floor, table)
                4 -> startNewActivity(ActivityType::class.java,"Вторые мясные блюда",floor, table)
                5 -> startNewActivity(ActivityType::class.java,"Вторые рыбные блюда",floor, table)
                6 -> startNewActivity(ActivityType::class.java,"Гарнир",floor, table)
            }
        }
        buttonOrder.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View){
                val intent = Intent(this@ActivityTable, ActivityOrder::class.java)
                intent.putExtra("floor", floor)
                intent.putExtra("table",table)
                startActivity(intent)
            }
        })
        buttonDelete.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val builder = AlertDialog.Builder(this@ActivityTable)
                builder.setMessage("Вы точно хочете удалит\n заказ даного стола?")
                builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                    DatabaseHelper(this@ActivityTable).updateDataToNullInAllTablesByChiaveEsterna((table.toString()+floor.toString()).toInt())
                }
                builder.setNegativeButton(android.R.string.no) { dialog, which ->

                }
                builder.show()
            }
        })
    }




    private fun startNewActivity(activityClass: Class<*>,type: String, floor: Int, table: Int) {
        val intent = Intent(this, activityClass)
        intent.putExtra("type", type)
        intent.putExtra("floor", floor)
        intent.putExtra("table", table)
        startActivity(intent)
    }
}