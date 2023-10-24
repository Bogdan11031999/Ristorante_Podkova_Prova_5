package com.example.ristorante_podkova_prova_5

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityType : AppCompatActivity() {

    var type:String = ""
    var table:String = ""
    var floor:String = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type)
        type = intent.getStringExtra("type").toString()
        floor = intent.getIntExtra("floor", 0).toString()
        table = intent.getIntExtra("table", 0).toString()
        DatiQuery.tavolo=table
        DatiQuery.piano=floor
        DatiQuery.tabella=type
        val listView = findViewById<ListView>(R.id.listViewType)
        val textView = findViewById<TextView>(R.id.textViewType)
        textView.setText("ЭТАЖ: "+floor+" СТОЛ: "+table+" КАТ: "+type)

        val dataList = creaListaDiNumeri(type)
        val adapter = CustomListType(this, dataList)
        listView.adapter = adapter


    }






    fun creaListaDiNumeri(type: String?): List<String> {
        var typeList = mutableListOf<String>()

        when(type){
            "Холодные закуски"->{
                typeList= mutableListOf("Подкова", "Селёдка малосольная", "Селёдка под шубой", "Нарезка колбасная", "Сёмга малого посола", "Салат столичный", "Русские разносолы", "Салат")
            }
            "Икра"->{
                typeList= mutableListOf("Икра чëрная", "Икра красная", "Бутерброд с красной икрой", "Блины с красной икрой", "Бутерброд с чëрной икрой", "Спагетти с чëрной икрой", "Спагетти с красной икрой")
            }
            "Горячие закуски"->{
                typeList= mutableListOf("Блины с красной икрой", "Блины с картошкой и грибами", "Блины с мясом", "Блины с грибами и сыром ", "Блины с гречкой и грибами", "Блины с картошкой, лососем и красной икрой ", "Жульен")
            }
            "Первые блюда"->{
                typeList= mutableListOf("Пельмени сибирские с мясом", "Пельмени в бульоне", "Пельмени «астраханские» рыбные", "Вареники с картошкой", "Вареники с творогом ", "Вареники с грибами", "Борщ", "Солянка сборная")
            }
            "Вторые мясные блюда"->{
                typeList= mutableListOf("Филе «Воронов»", "Филе «Шерри»", "Филе с перцем, облитое коньяком", "Филе «Строганов»", "Филе «Строганов» с белыми грибами", "Жаркое", "«Жаркое» из овощей", "«Гуляш»","Шашлык по-кавказски ","Утка с черносливом и яблоками","Утиная грудинка с малиновым соусом ","Котлеты домашние с пюре","Каша гречневая с мясом ","Каша гречневая с белыми грибами ","Голубцы")
            }
            "Вторые рыбные блюда"->{
                typeList= mutableListOf("Шашлык из осетрины", "Осетрина по-московски", "Подкова", "Сëмга под белым соусом", "Лосось с мëдом и горчицей", "Лосось с белыми грибами ")
            }
            "Гарнир"->{
                typeList= mutableListOf("Жаренная картошка", "Пюре", "Гречневая каша", "Овощи гриль")
            }
        }

        return typeList
    }
}