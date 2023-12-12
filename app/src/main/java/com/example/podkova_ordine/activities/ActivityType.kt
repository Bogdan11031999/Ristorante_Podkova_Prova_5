package com.example.podkova_ordine.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.podkova_ordine.customs.CustomListType
import com.example.podkova_ordine.DatiQuery
import com.example.podkova_ordine.R

class ActivityType : AppCompatActivity() {



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type)
        val listView = findViewById<ListView>(R.id.listViewType)
        val textView = findViewById<TextView>(R.id.textViewType)
        val buttonViewOrder = findViewById<Button>(R.id.buttonViewOrder)
        textView.setText("ЭТАЖ: "+ DatiQuery.piano +" СТОЛ: "+ DatiQuery.tavolo +"\n"+"КАТ: "+ DatiQuery.tabella)
        val listButtons = mutableListOf<String>("Хол.\nзакуски","Икра","Гор.\nзакуски","Первые\nблюда","Втор.\nмясные","Втор.\nрыбные","Гарнир","Напитки","Алкоголь","Bollicine","Vini\nRossi","Vini\nBianchi","Vini\nGeorgiani")
        val density = resources.displayMetrics.density
        val widthInPx = (110 * density).toInt()
        val heightInPx = (80 * density).toInt()
        val linearLayout = findViewById<LinearLayout>(R.id.linear_layout_buttons)
        for (e in listButtons)  {
            val button = Button(this).apply {
                text = e
                layoutParams = LinearLayout.LayoutParams(
                    widthInPx,
                    heightInPx
                )
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
                gravity = Gravity.CENTER_HORIZONTAL

                setOnClickListener {
                    when (e) {
                        "Хол.\nзакуски"->{
                            DatiQuery.tabella ="Холодные закуски"
                            onResume()
                        }
                        "Икра" ->{
                            DatiQuery.tabella ="Икра"
                            onResume()
                        }
                        "Гор.\nзакуски" ->{
                            DatiQuery.tabella ="Горячие закуски"
                            onResume()
                        }
                        "Первые\nблюда"->{
                            DatiQuery.tabella ="Первые блюда"
                            onResume()
                        }
                        "Втор.\nмясные"->{
                            DatiQuery.tabella ="Вторые мясные блюда"
                            onResume()
                        }
                        "Втор.\nрыбные"->{
                            DatiQuery.tabella ="Вторые рыбные блюда"
                            onResume()
                        }
                        "Гарнир"->{
                            DatiQuery.tabella ="Гарнир"
                            onResume()
                        }
                        "Напитки"->{
                            DatiQuery.tabella ="Напитки"
                            onResume()
                        }
                        "Алкоголь"->{
                            DatiQuery.tabella ="Алкоголь"
                            onResume()
                        }
                        "Bollicine"->{
                            DatiQuery.tabella ="Bollicine"
                            onResume()
                        }
                        "Vini\nRossi"->{
                            DatiQuery.tabella ="Vini Rossi"
                            onResume()
                        }
                        "Vini\nBianchi"->{
                            DatiQuery.tabella ="Vini Bianchi"
                            onResume()
                        }
                        "Vini\nGeorgiani"->{
                            DatiQuery.tabella ="Vini Georgiani"
                            onResume()
                        }
                    }
                }
            }

            linearLayout.addView(button)
        }

        val dataList = creaListaDiNumeri(DatiQuery.tabella)
        val adapter = CustomListType(this, dataList)
        listView.adapter = adapter
        buttonViewOrder.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View){
                val intent = Intent(this@ActivityType, ActivityOrder::class.java)
                intent.putExtra("floor", DatiQuery.piano.toInt())
                intent.putExtra("table", DatiQuery.tavolo.toInt())
                startActivity(intent)
            }
        })

    }
    override fun onResume() {
        super.onResume()
        val listView = findViewById<ListView>(R.id.listViewType)
        val textView = findViewById<TextView>(R.id.textViewType)
        val buttonViewOrder = findViewById<Button>(R.id.buttonViewOrder)
        textView.setText("ЭТАЖ: "+ DatiQuery.piano +" СТОЛ: "+ DatiQuery.tavolo +"\n"+"КАТ: "+ DatiQuery.tabella)

        val dataList = creaListaDiNumeri(DatiQuery.tabella)
        val adapter = CustomListType(this, dataList)
        listView.adapter = adapter

        buttonViewOrder.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View){
                val intent = Intent(this@ActivityType, ActivityOrder::class.java)
                intent.putExtra("floor", DatiQuery.piano.toInt())
                intent.putExtra("table", DatiQuery.tavolo.toInt())
                startActivity(intent)
            }
        })

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
                typeList= mutableListOf("Блины с красной икрой", "Блины с картошкой и грибами", "Блины с мясом", "Блины с грибами и сыром", "Блины с гречкой и грибами", "Блины с картошкой, лососем и красной икрой", "Жульен")
            }
            "Первые блюда"->{
                typeList= mutableListOf("Пельмени сибирские с мясом", "Пельмени в бульоне", "Пельмени «астраханские» рыбные", "Вареники с картошкой", "Вареники с творогом ", "Вареники с грибами", "Борщ", "Солянка сборная")
            }
            "Вторые мясные блюда"->{
                typeList= mutableListOf("Филе Воронов", "Филе Шерри", "Филе с перцем, облитое коньяком", "Филе Строганов", "Филе Строганов с белыми грибами", "Жаркое", "Жаркое из овощей", "Гуляш","Шашлык по-кавказски","Утка с черносливом и яблоками","Утиная грудинка с малиновым соусом","Котлеты домашние с пюре","Каша гречневая с мясом","Каша гречневая с белыми грибами","Голубцы")
            }
            "Вторые рыбные блюда"->{
                typeList= mutableListOf("Шашлык из осетрины", "Осетрина по-московски", "Подкова рыба", "Сëмга под белым соусом", "Лосось с мëдом и горчицей", "Лосось с белыми грибами")
            }
            "Гарнир"->{
                typeList= mutableListOf("Жаренная картошка", "Пюре", "Гречневая каша", "Овощи гриль")
            }
            "Напитки"->{
                typeList= mutableListOf("Сок яблочно виноградный", "Сок томатный", "Морс клюквенный","Кока Кола","Чай","Кофе","Газированая","Минеральная")
            }
            "Алкоголь"->{
                typeList= mutableListOf("Vodka Beluga", "Vodka Russky Standart", "Vodka Russky Standart Bicchiere",
                    "Vodka lampone","Vodka granberry","Vodka amarena","Vodka con peppe e miele","Birra Zhygulovske",
                    "Birra Bochkovoe nefiltrovane", "Birra Kaban","Amaro","Whisky","Rum","Brendi","Cognac")
            }
            "Bollicine"->{
                typeList= mutableListOf("Conegliano Valdobbiadene PS DOCG", "R.D.O.Levante", "Franciacorta Brut Barone Di Erbusco","Billecart-Salmon Brut Reserve","Moet Chandon Brut Imperial")
            }
            "Vini Rossi"->{
                typeList = mutableListOf(
                    "Sassella Valtellina Superiore DOCG",
                    "Dolcetto D'Alba",
                    "Etichetta Nera",
                    "Nebbiolo",
                    "Barolo DOCG Riserva",
                    "Barbaresco DOCG Asili",
                    "Pinot Nero Alto Adige DOC",
                    "Cabernet Sauvignon",
                    "Cabernet Sauvignon ½",
                    "Valpolicella Classico DOC",
                    "Amarone DOC",
                    "Rosso Di Montepulciano",
                    "Chianti Classico DOCG",
                    "Chianti Classico Riserva DOCG ½",
                    "Nobile Di Montepulciano Riserva DOCG",
                    "Brunello Di Montalcino Riserva DOCG",
                    "Zephyro Bolgheri Rosso DOC",
                    "Morellino Di Scansano DOCG",
                    "Antico Sigillo Primitivo Di Manduria DOP"
                )
            }
            "Vini Georgiani"->{
                typeList = mutableListOf(
                    "Kisi-Mtsvane",
                    "Rkatsiteli",
                    "Saperavi",
                    "Mukuzani",
                    "Mukuzani Badagoni",
                    "Mukuzani Marani",
                    "Kindzmarauli"
                )
            }
            "Vini Bianchi"->{
                typeList = mutableListOf(
                    "Gavi Di Gavi",
                    "Roero Arneis",
                    "Gewurztraminer DOC",
                    "Muller Thurgau DOC",
                    "Chardonnay Collio",
                    "Sauvignon Collio",
                    "Pinot Grigio Collio",
                    "Pinot Grigio Collio ½",
                    "Pigato Di Albenga R.l.p. DOC",
                    "Pecorino Superiore",
                    "Fiano Di Avellino",
                    "Greco Di Tufo",
                    "Vermentino Di Sardegna DOC",
                    "Ribolla Gialla"
                )
            }
        }

        return typeList
    }

}