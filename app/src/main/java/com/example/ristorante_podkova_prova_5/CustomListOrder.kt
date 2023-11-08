package com.example.ristorante_podkova_prova_5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
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
        val elementArrayMenu=arrayMenu.get(position-1)
        val textView = view.findViewById<TextView>(R.id.textViewItemType)
        val textViewPieces = view.findViewById<TextView>(R.id.textViewPieces)
        val numbers = arrayOf("0","1","2","3","4","5","6","7","8","9","10","0.3","0.5")
        spinnerNumbers = view.findViewById(R.id.spinnerNumbers) as Spinner
        spinnerNumbers.adapter = ArrayAdapter<String>(context,R.layout.spinner_dropdown_layout,numbers)
        textView.text = entry.key
        textViewPieces.text = entry.value.toString()

        return view
    }
}

