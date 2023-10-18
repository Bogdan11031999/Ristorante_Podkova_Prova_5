package com.example.ristorante_podkova_prova_5

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.File


class ActivityOrder : AppCompatActivity() {

    companion object {
        private const val KEY_ID_ANTIPASTIFREDDI = "id_antipasti_freddi"
        private const val TABLE_ANTIPASTIFREDDI = "antipastifreddi"
        private const val TABLE_ANTIPASTICALDI = "antipasticaldi"
        private const val KEY_ID_ANTIPASTICALDI = "id_antipasti_caldi"
        private const val KEY_ID_CAVIALE = "id_caviale"
        private const val TABLE_CAVIALE = "caviale"
        private const val KEY_ID_PRIMI = "id_primi"
        private const val TABLE_PRIMI = "primi"
        private const val KEY_ID_SECONDICARNE = "id_secondicarne"
        private const val TABLE_SECONDICARNE = "secondicarne"
        private const val KEY_ID_SECONDIPESCE = "id_secondipesce"
        private const val TABLE_SECONDIPESCE = "secondipesce"
        private const val KEY_ID_CONTORNI = "id_contorni"
        private const val TABLE_CONTORNI = "contorni"
        private const val KEY_ID_DESERT = "id_desert"
        private const val TABLE_DESERT = "desert"
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val floor = intent.getIntExtra("floor", 0)
        val table = intent.getIntExtra("table", 0)
        val textViewOrder = findViewById<TextView>(R.id.textViewOrder)
        val textViewOrderInfo = findViewById<TextView>(R.id.textViewOrderInfo)
        val btnStampa = findViewById<Button>(R.id.btnStampa)
        textViewOrderInfo.setText("ЭТАЖ: "+floor+" СТОЛ: "+table)
        val stringInfo="ЭТАЖ: "+floor+" СТОЛ: "+table
        //ricavo i dati dal database per gli antipasti_freddi
        val nonZeroDataAntipastiFreddi = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"$TABLE_ANTIPASTIFREDDI","$KEY_ID_ANTIPASTIFREDDI")
        val nonZeroDataAntipastiCaldi = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"$TABLE_ANTIPASTICALDI","$KEY_ID_ANTIPASTICALDI")
        val nonZeroDataCaviale = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"$TABLE_CAVIALE","$KEY_ID_CAVIALE")
        val nonZeroDataPrimi = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"$TABLE_PRIMI","$KEY_ID_PRIMI")
        val nonZeroDataSecondiCarne = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"$TABLE_SECONDICARNE","$KEY_ID_SECONDICARNE")
        val nonZeroDataSecondiPesce = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"$TABLE_SECONDIPESCE","$KEY_ID_SECONDIPESCE")
        val nonZeroDataControni = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"$TABLE_CONTORNI","$KEY_ID_CONTORNI")
        val nonZeroDataDesert = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"$TABLE_DESERT","$KEY_ID_DESERT")

        if(nonZeroDataAntipastiFreddi.size!=0 || nonZeroDataAntipastiCaldi.size!=0 || nonZeroDataCaviale.size!=0){
            textViewOrder.append("Antipasti:"+"\n")
            for ((column, value) in nonZeroDataAntipastiFreddi) {
                if(value!=0.0){
                    textViewOrder.append("$column: $value"+"\n")
                }
            }
            for ((column, value) in nonZeroDataAntipastiCaldi) {
                if(value!=0.0){
                    textViewOrder.append("$column: $value"+"\n")
                }
            }
            for ((column, value) in nonZeroDataCaviale) {
                if(value!=0.0){
                    textViewOrder.append("$column: $value"+"\n")
                }
            }
        }

        if(nonZeroDataPrimi.size!=0){
            textViewOrder.append("Primi:"+"\n")
            for ((column, value) in nonZeroDataPrimi) {
                if(value!=0.0){
                    textViewOrder.append("$column: $value"+"\n")
                }
            }
        }

        if(nonZeroDataSecondiCarne.size!=0 || nonZeroDataSecondiPesce.size!=0){
            textViewOrder.append("Secondi:"+"\n")
            for ((column, value) in nonZeroDataSecondiCarne) {
                if(value!=0.0){
                    textViewOrder.append("$column: $value"+"\n")
                }
            }
            for ((column, value) in nonZeroDataSecondiPesce) {
                if(value!=0.0){
                    textViewOrder.append("$column: $value"+"\n")
                }
            }
        }

        if(nonZeroDataControni.size!=0){
            textViewOrder.append("Contorni:"+"\n")
            for ((column, value) in nonZeroDataControni) {
                if(value!=0.0){
                    textViewOrder.append("$column: $value"+"\n")
                }
            }
        }

        btnStampa.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View){
                val outputFilePath = getExternalFilesDir(null)?.absolutePath + File.separator+"ЭТАЖ"+ floor+"СТОЛ"+table+".pdf" // Specifica il percorso per il PDF risultante
                val pdfGenerator = PDFGenerator(this@ActivityOrder) // 'this' è il contesto dell'attività corrente
                pdfGenerator.generateAndPrintPDF(stringInfo,outputFilePath, nonZeroDataAntipastiFreddi,nonZeroDataAntipastiCaldi,
                    nonZeroDataCaviale,nonZeroDataPrimi,nonZeroDataSecondiCarne,nonZeroDataSecondiPesce,nonZeroDataControni,nonZeroDataDesert)
                val pdfFile = File(outputFilePath) // Sostituisci con il percorso effettivo del tuo file PDF
                PDFPrinter.printPDF(this@ActivityOrder, pdfFile) // 'this' è il contesto dell'attività corrente
            }
        })


    }

}