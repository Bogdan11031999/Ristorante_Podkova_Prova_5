package com.example.ristorante_podkova_prova_5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView

class CustomListOrder(private val context: Context, private val dataList: Map<String, Double>,private val arrayMenu:List<String>) : BaseAdapter() {
    lateinit var spinnerNumbers : Spinner
    var selectedValue: Double = 0.0
    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(position: Int): Any {
        val entries = dataList.entries.toList()
        return entries[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.custom_list_view_type, parent, false)
        val entry = getItem(position) as Map.Entry<String, Double>
        val translator = Translator()
        val elementArrayMenu=arrayMenu.get(position)
        val textViewItemType= view.findViewById<TextView>(R.id.textViewItemType)
        val textViewPieces = view.findViewById<TextView>(R.id.textViewPieces)
        val buttonAdd = view.findViewById<ImageButton>(R.id.imageButtonAdd)
        val buttonRemove = view.findViewById<ImageButton>(R.id.imageButtonRemove)
        val numbers = arrayOf("0","1","2","3","4","5","6","7","8","9","10","0.3","0.5")
        spinnerNumbers = view.findViewById(R.id.spinnerNumbers) as Spinner
        spinnerNumbers.adapter = ArrayAdapter<String>(context,R.layout.spinner_dropdown_layout,numbers)
        textViewItemType.text = entry.key
        textViewPieces.text = entry.value.toString()
        val foreignKey = DatiQuery.tavolo+DatiQuery.piano
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

        buttonAdd.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View){
                if(selectedValue>0){
                    DatabaseHelper(context).inserisciDato(translator.trasformFromRussian(arrayMenu[position]),translator.transformFromRussianColum(arrayMenu[position],textViewItemType.text.toString()),selectedValue,foreignKey.toInt())
                    textViewPieces.setText(DatabaseHelper(context).getDatoFromTabella(translator.trasformFromRussian(DatiQuery.tabella),translator.transformFromRussianColum(DatiQuery.tabella,textViewItemType.text.toString()),foreignKey.toInt()).toString())
                }
            }
        })

        buttonRemove.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View){
                DatabaseHelper(context).setColumnValueToZero(translator.trasformFromRussian(arrayMenu[position]),translator.transformFromRussianColum(arrayMenu[position],textViewItemType.text.toString()),foreignKey.toInt())
                textViewPieces.setText(DatabaseHelper(context).getDatoFromTabella(translator.trasformFromRussian(arrayMenu[position]),translator.transformFromRussianColum(arrayMenu[position],textViewItemType.text.toString()),foreignKey.toInt()).toString())
                spinnerNumbers.setSelection(0)
            }
        })

        return view
    }
}

