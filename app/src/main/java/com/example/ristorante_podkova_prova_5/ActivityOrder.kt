package com.example.ristorante_podkova_prova_5

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.File


class ActivityOrder : AppCompatActivity() {

    val arrayMenu= mutableListOf<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val floor = intent.getIntExtra("floor", 0)
        val table = intent.getIntExtra("table", 0)
        val textViewOrderInfo = findViewById<TextView>(R.id.textViewOrderInfo)
        val btnStampa = findViewById<Button>(R.id.btnStampa)
        val listViewOrder = findViewById<ListView>(R.id.listViewOrder)
        val adapter = CustomListOrder(this@ActivityOrder,loadDataFromDBIntoMap(floor,table),arrayMenu)
        listViewOrder.adapter = adapter
        textViewOrderInfo.setText("ЭТАЖ: "+floor+" СТОЛ: "+table)
        val stringInfo="ЭТАЖ: "+floor+" СТОЛ: "+table
        val nonZeroDataAntipastiFreddi = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"${TableConstants.TABLE_ANTIPASTIFREDDI}","${KeyConstant.KEY_ID_ANTIPASTIFREDDI}")
        val nonZeroDataAntipastiCaldi = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"${TableConstants.TABLE_ANTIPASTICALDI}","${KeyConstant.KEY_ID_ANTIPASTICALDI}")
        val nonZeroDataCaviale = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"${TableConstants.TABLE_CAVIALE}","${KeyConstant.KEY_ID_CAVIALE}")
        val nonZeroDataPrimi = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"${TableConstants.TABLE_PRIMI}","${KeyConstant.KEY_ID_PRIMI}")
        val nonZeroDataSecondiCarne = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"${TableConstants.TABLE_SECONDICARNE}","${KeyConstant.KEY_ID_SECONDICARNE}")
        val nonZeroDataSecondiPesce = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"${TableConstants.TABLE_SECONDIPESCE}","${KeyConstant.KEY_ID_SECONDIPESCE}")
        val nonZeroDataControni = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"${TableConstants.TABLE_CONTORNI}","${KeyConstant.KEY_ID_CONTORNI}")
        val nonZeroDataBevande = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"${TableConstants.TABLE_BEVANDE}","${KeyConstant.KEY_ID_BEVANDE}")
        val nonZeroDataAlco = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"${TableConstants.TABLE_ALCO}","${KeyConstant.KEY_ID_ALCO}")
        btnStampa.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View){
                val outputFilePath = getExternalFilesDir(null)?.absolutePath + File.separator+"ЭТАЖ"+ floor+"СТОЛ"+table+".pdf"
                val pdfGenerator = PDFGenerator(this@ActivityOrder)
                pdfGenerator.generateAndPrintPDF(stringInfo,outputFilePath, nonZeroDataAntipastiFreddi,nonZeroDataAntipastiCaldi,
                    nonZeroDataCaviale,nonZeroDataPrimi,nonZeroDataSecondiCarne,nonZeroDataSecondiPesce,nonZeroDataControni,nonZeroDataBevande,nonZeroDataAlco)
                val pdfFile = File(outputFilePath)
                PDFPrinter.printPDF(this@ActivityOrder, pdfFile)
            }
        })


    }
    fun loadDataFromDBIntoMap(floor:Int,table:Int): Map<String,Double>{
        val translator = Translator()
        val nonZeroDataAntipastiFreddi = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"${TableConstants.TABLE_ANTIPASTIFREDDI}","${KeyConstant.KEY_ID_ANTIPASTIFREDDI}")
        val nonZeroDataAntipastiCaldi = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"${TableConstants.TABLE_ANTIPASTICALDI}","${KeyConstant.KEY_ID_ANTIPASTICALDI}")
        val nonZeroDataCaviale = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"${TableConstants.TABLE_CAVIALE}","${KeyConstant.KEY_ID_CAVIALE}")
        val nonZeroDataPrimi = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"${TableConstants.TABLE_PRIMI}","${KeyConstant.KEY_ID_PRIMI}")
        val nonZeroDataSecondiCarne = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"${TableConstants.TABLE_SECONDICARNE}","${KeyConstant.KEY_ID_SECONDICARNE}")
        val nonZeroDataSecondiPesce = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"${TableConstants.TABLE_SECONDIPESCE}","${KeyConstant.KEY_ID_SECONDIPESCE}")
        val nonZeroDataControni = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"${TableConstants.TABLE_CONTORNI}","${KeyConstant.KEY_ID_CONTORNI}")
        val nonZeroDataBevande = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"${TableConstants.TABLE_BEVANDE}","${KeyConstant.KEY_ID_BEVANDE}")
        val nonZeroDataAlco = DatabaseHelper(this).retrieveDataFromDataBase((table.toString()+floor.toString()).toInt(),"${TableConstants.TABLE_ALCO}","${KeyConstant.KEY_ID_ALCO}")
        var cont = 0
        val data = mutableMapOf<String, Double>()
        if(nonZeroDataAntipastiFreddi.size!=0){
            for ((column, value) in nonZeroDataAntipastiFreddi){
                if(value!=0.0){
                    data.put(translator.transformFromEngToRussian("Холодные закуски",column),value)
                    createArrayMenu("Холодные закуски",cont)
                    cont+=1
                }
            }
        }
        if(nonZeroDataAntipastiCaldi.size!=0){
            for ((column, value) in nonZeroDataAntipastiCaldi){
                if(value!=0.0){
                    data.put(translator.transformFromEngToRussian("Горячие закуски",column),value)
                    createArrayMenu("Горячие закуски",cont)
                    cont+=1
                }
            }
        }
        if(nonZeroDataCaviale.size!=0){
            for ((column, value) in nonZeroDataCaviale){
                if(value!=0.0){
                    data.put(translator.transformFromEngToRussian("Икра",column),value)
                    createArrayMenu("Икра",cont)
                    cont+=1
                }
            }
        }
        if(nonZeroDataPrimi.size!=0){
            for ((column, value) in nonZeroDataPrimi){
                if(value!=0.0){
                    data.put(translator.transformFromEngToRussian("Первые блюда",column),value)
                    createArrayMenu("Первые блюда",cont)
                    cont+=1
                }
            }
        }
        if(nonZeroDataSecondiCarne.size!=0){
            for ((column, value) in nonZeroDataSecondiCarne){
                if(value!=0.0){
                    data.put(translator.transformFromEngToRussian("Вторые мясные блюда",column),value)
                    createArrayMenu("Вторые мясные блюда",cont)
                    cont+=1
                }
            }
        }
        if(nonZeroDataSecondiPesce.size!=0){
            for ((column, value) in nonZeroDataSecondiPesce){
                if(value!=0.0){
                    data.put(translator.transformFromEngToRussian("Вторые рыбные блюда",column),value)
                    createArrayMenu("Вторые рыбные блюда",cont)
                    cont+=1
                }
            }
        }
        if(nonZeroDataControni.size!=0){
            for ((column, value) in nonZeroDataSecondiPesce){
                if(value!=0.0){
                    data.put(translator.transformFromEngToRussian("Гарнир",column),value)
                    createArrayMenu("Гарнир",cont)
                    cont+=1
                }
            }
        }
        if(nonZeroDataBevande.size!=0){
            for ((column, value) in nonZeroDataBevande){
                if(value!=0.0){
                    data.put(translator.transformFromEngToRussian("Напитки",column),value)
                    createArrayMenu("Напитки",cont)
                    cont+=1
                }
            }
        }
        if(nonZeroDataAlco.size!=0){
            for ((column, value) in nonZeroDataAlco){
                if(value!=0.0){
                    data.put(translator.transformFromEngToRussian("Алкоголь",column),value)
                    createArrayMenu("Алкоголь",cont)
                    cont+=1
                }
            }
        }
        return data
    }
    fun createArrayMenu(menu:String,cont:Int):List<String>{
        arrayMenu.add(cont,menu)
        return arrayMenu
    }

}