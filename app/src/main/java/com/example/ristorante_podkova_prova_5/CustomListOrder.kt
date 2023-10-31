package com.example.ristorante_podkova_prova_5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomListOrder(private val context: Context, private val dataList: List<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(position: Int): Any {
        return dataList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view =
                LayoutInflater.from(context).inflate(R.layout.custom_list_view_order, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val item = getItem(position) as String

        // Imposta il testo nella TextView
        viewHolder.textView.text = item

        return view
    }

    private class ViewHolder(view: View) {
        val textView: TextView = view.findViewById(R.id.textViewItem)
    }
}