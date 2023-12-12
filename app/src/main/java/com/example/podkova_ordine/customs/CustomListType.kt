package com.example.podkova_ordine.customs

import android.annotation.SuppressLint
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
import com.example.podkova_ordine.DatabaseHelper
import com.example.podkova_ordine.DatiQuery
import com.example.podkova_ordine.R
import com.example.podkova_ordine.Translator

class CustomListType(private val context: Context, var dataList: List<String>) : BaseAdapter() {
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
        val textViewPieces = view.findViewById<TextView>(R.id.textViewPieces)
        val numbers = arrayOf("0","1","2","3","4","5","6","7","8","9","10","0.3","0.5")
        spinnerNumbers = view.findViewById(R.id.spinnerNumbers) as Spinner
        spinnerNumbers.adapter = ArrayAdapter<String>(context,
            R.layout.spinner_dropdown_layout,numbers)
        val translator = Translator()
        val foreignKey = DatiQuery.tavolo + DatiQuery.piano
        System.out.println(textViewItemType.text.toString())
        var count =0.0
        textViewPieces.setText(
            DatabaseHelper(context).getDatoFromTabella(translator.trasformFromRussian(
                DatiQuery.tabella
            ),translator.transformFromRussianColum(DatiQuery.tabella,textViewItemType.text.toString()),foreignKey.toInt()).toString())
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
                    DatabaseHelper(context).inserisciDato(translator.trasformFromRussian(DatiQuery.tabella),translator.transformFromRussianColum(
                        DatiQuery.tabella,textViewItemType.text.toString()),selectedValue,foreignKey.toInt())
                    textViewPieces.setText(
                        DatabaseHelper(context).getDatoFromTabella(translator.trasformFromRussian(
                            DatiQuery.tabella
                        ),translator.transformFromRussianColum(DatiQuery.tabella,textViewItemType.text.toString()),foreignKey.toInt()).toString())
                }else{
                    count+=1
                    DatabaseHelper(context).inserisciDato(translator.trasformFromRussian(DatiQuery.tabella),translator.transformFromRussianColum(
                        DatiQuery.tabella,textViewItemType.text.toString()),count,foreignKey.toInt())
                    textViewPieces.setText(
                        DatabaseHelper(context).getDatoFromTabella(translator.trasformFromRussian(
                            DatiQuery.tabella
                        ),translator.transformFromRussianColum(DatiQuery.tabella,textViewItemType.text.toString()),foreignKey.toInt()).toString())
                }
            }
        })

        buttonRemove.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View){
                DatabaseHelper(context).setColumnValueToZero(translator.trasformFromRussian(
                    DatiQuery.tabella
                ),translator.transformFromRussianColum(DatiQuery.tabella,textViewItemType.text.toString()),foreignKey.toInt())
                textViewPieces.setText(
                    DatabaseHelper(context).getDatoFromTabella(translator.trasformFromRussian(
                        DatiQuery.tabella
                    ),translator.transformFromRussianColum(DatiQuery.tabella,textViewItemType.text.toString()),foreignKey.toInt()).toString())
                spinnerNumbers.setSelection(0)
                count=0.0
            }
        })


        return view
    }


}