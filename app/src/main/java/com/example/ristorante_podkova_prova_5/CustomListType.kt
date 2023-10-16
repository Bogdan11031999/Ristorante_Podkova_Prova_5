package com.example.ristorante_podkova_prova_5

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class CustomListType(private val context: Context, private val dataList: List<String>) : BaseAdapter() {
    lateinit var spinnerNumbers : Spinner
    var selectedValue: Double = 0.0
    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(position: Int): Any {
        return dataList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.custom_list_view_type, parent, false)
        val textViewItemType = view.findViewById<TextView>(R.id.textViewItemType)
        val item = getItem(position)
        textViewItemType.text = item.toString()
        val buttonAdd = view.findViewById<ImageButton>(R.id.imageButtonAdd)
        val buttonRemove = view.findViewById<ImageButton>(R.id.imageButtonRemove)
        val numbers = arrayOf("0","1","2","3","4","5","6","7","8","9","10","0.3","0.5")
        spinnerNumbers = view.findViewById(R.id.spinnerNumbers) as Spinner
        spinnerNumbers.adapter = ArrayAdapter<String>(context,R.layout.spinner_dropdown_layout,numbers)

        spinnerNumbers.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                var selectedItemAsString = parent?.getItemAtPosition(pos).toString()
                selectedValue = try {
                    selectedItemAsString.toDouble()
                } catch (e: NumberFormatException) {
                    0.0
                }


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        val foreignKey = DatiQuery.tavolo+DatiQuery.piano
        //type+"/"+table+"/"+floor
        buttonAdd.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View){
                if(selectedValue>0){
                    DatabaseHelper(context).inserisciDato(trasformFromRussian(DatiQuery.tabella),transformFromRussianColum(DatiQuery.tabella,textViewItemType.text.toString()),selectedValue,foreignKey.toInt())
                }
            }
        })

        buttonRemove.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View){
                if(position==0 && selectedValue>0){
                }
            }
        })


        return view
    }
    private fun trasformFromRussian(type: String):String{
        var typeTransformed=""
        when(type){
            "Холодные закуски"->typeTransformed="antipastifreddi"
            "Икра"->typeTransformed="caviale"
            "Горячие закуски"->typeTransformed="antipasticaldi"
            "Первые блюда"->typeTransformed="primi"
            "Вторые мясные блюда"->typeTransformed="secondicarne"
            "Вторые рыбные блюда"->typeTransformed="secondipesce"
            "Гарнир"->typeTransformed="contorni"
            "Десерт"->typeTransformed="desert"
        }
        return typeTransformed;
    }

    private fun transformFromRussianColum(type:String,colum:String):String{
        var typeTransformed=""
        when(type){
            "Холодные закуски"->{
                when(colum){
                    "Подкова"->typeTransformed="podkova"
                    "Селёдка малосольная"->typeTransformed="aringa"
                    "Селёдка под шубой"->typeTransformed="sciuba"
                    "Нарезка колбасная"->typeTransformed="salumi"
                    "Сёмга малого посола"->typeTransformed="salmone"
                    "Салат столичный"->typeTransformed="russa"
                    "Русские разносолы"->typeTransformed="antivodka"
                    "Салат"->typeTransformed="insalata"
                    "Селёдка под шубой"->typeTransformed="sciuba"
                }
            }
            "Икра"->{
                when(colum){
                    "Икра чëрная"->typeTransformed="nero"
                    "Икра красная"->typeTransformed="rosso"
                    "Бутерброд с красной икрой"->typeTransformed="burgerRosso"
                    "Блины с красной икрой"->typeTransformed="crepeRosso"
                    "Бутерброд с чëрной икрой"->typeTransformed="burgerNero"
                    "Спагетти с чëрной икрой"->typeTransformed="spaghettiNero"
                    "Спагетти с красной икрой"->typeTransformed="spaghettiRosso"
                }
            }
            "Горячие закуски"->{
                when(colum){
                    "Блины с красной икрой"->typeTransformed="uovasalmone"
                    "Блины с картошкой и грибами"->typeTransformed="patatefunghi"
                    "Блины с мясом"->typeTransformed="carne"
                    "Блины с грибами и сыром"->typeTransformed="funghiformaggi"
                    "Блины с гречкой и грибами"->typeTransformed="granofunghi"
                    "Блины с картошкой, лососем и красной икрой"->typeTransformed="patatesalmone"
                    "Жульен"->typeTransformed="juiliene"
                }
            }
            "Первые блюда"->{
                when(colum){
                    "Пельмени сибирские с мясом"->typeTransformed="siberiani"
                    "Пельмени в бульоне"->typeTransformed="brodo"
                    "Пельмени «астраханские» рыбные"->typeTransformed="salmone"
                    "Вареники с картошкой"->typeTransformed="patate"
                    "Вареники с творогом "->typeTransformed="tvorog"
                    "Вареники с грибами"->typeTransformed="funghi"
                    "Борщ"->typeTransformed="borshch"
                    "Солянка сборная"->typeTransformed="solianca"
                }
            }
            "Вторые мясные блюда"->{
                when(colum){
                    "Филе «Воронов»"->typeTransformed="woronoff"
                    "Филе «Шерри»"->typeTransformed="cherry"
                    "Филе с перцем, облитое коньяком"->typeTransformed="manzo"
                    "Филе «Строганов»"->typeTransformed="stro"
                    "Филе «Строганов» с белыми грибами"->typeTransformed="strofunghi"
                    "Жаркое"->typeTransformed="zharkoie"
                    "«Жаркое» из овощей"->typeTransformed="zharkoieverdure"
                    "«Гуляш»"->typeTransformed="gulasch"
                    "Шашлык по-кавказски"->typeTransformed="shashlyk"
                    "Утка с черносливом и яблоками"->typeTransformed="anatra"
                    "Утиная грудинка с малиновым соусом"->typeTransformed="petto"
                    "Котлеты домашние с пюре"->typeTransformed="polpette"
                    "Каша гречневая с мясом "->typeTransformed="granomanzo"
                    "Каша гречневая с белыми грибами "->typeTransformed="granofunghi"
                    "Голубцы"->typeTransformed="golubtzy"
                }
            }
            "Вторые рыбные блюда"->{
                when(colum){
                    "Шашлык из осетрины"->typeTransformed="shashlyk"
                    "Осетрина по-московски"->typeTransformed="storione"
                    "Подкова"->typeTransformed="podkova"
                    "Сëмга под белым соусом"->typeTransformed="salmoneBianca"
                    "Лосось с мëдом и горчицей"->typeTransformed="salmoneMiele"
                    "Лосось с белыми грибами "->typeTransformed="salmoneFunghi"
                }
            }
            "Десерт"->{
                when(colum){
                    "Торт"->typeTransformed="torta"
                    "Чернослив"->typeTransformed="prugne"
                    "Блины сгущенным молоком"->typeTransformed="crepeNutella"
                    "Блины с медом"->typeTransformed="crepeMiele"
                    "Блины с нутеллой"->typeTransformed="crepeLatte"
                    "Блины с мармеладом"->typeTransformed="crepeMarmellata"
                    "Сливочное мороженное с шоколадом"->typeTransformed="gelatoCiocolato"
                    "Сливочное мороженное с медом и орехами"->typeTransformed="gelatoAmarene"
                    "Сливочное мороженное с клюквенным вареньем"->typeTransformed="gelatoMiele"
                    "Сливочное мороженное с вишней"->typeTransformed="gelatoMarmellata"
                    "Сорбетто с клюквой"->typeTransformed="sorbetto"
                }
            }
            "Гарнир"->{
                when(colum){
                    "Жаренная картошка"->typeTransformed="patate"
                    "Пюре"->typeTransformed="pure"
                    "Гречневая каша"->typeTransformed="grano"
                    "Овощи гриль"->typeTransformed="verdura"
                }
            }

        }
        return typeTransformed
    }

    private class ViewHolder(view: View) {
        val textView: TextView = view.findViewById(R.id.textViewItemType)
    }
}