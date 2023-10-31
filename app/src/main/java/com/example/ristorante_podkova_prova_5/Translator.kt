package com.example.ristorante_podkova_prova_5

class Translator {
    fun transformFromEngToRussian(type:String,colum:String):String{
        var typeTransformed=""
        when(type){
            "Холодные закуски"->{
                when(colum){
                    "podkova"->typeTransformed="Подкова"
                    "aringa"->typeTransformed="Селёдка малосольная"
                    "sciuba"->typeTransformed="Селёдка под шубой"
                    "salumi"->typeTransformed="Нарезка колбасная"
                    "salmone"->typeTransformed="Сёмга малого посола"
                    "russa"->typeTransformed="Салат столичный"
                    "antivodka"->typeTransformed="Русские разносолы"
                    "insalata"->typeTransformed="Салат"
                    "sciuba"->typeTransformed="Селёдка под шубой"
                }
            }
            "Икра"->{
                when(colum){
                    "nero"->typeTransformed="Икра чëрная"
                    "rosso"->typeTransformed="Икра красная"
                    "burgerRosso"->typeTransformed="Бутерброд с красной икрой"
                    "crepeRosso"->typeTransformed="Блины с красной икрой"
                    "burgerNero"->typeTransformed="Бутерброд с чëрной икрой"
                    "spaghettiNero"->typeTransformed="Спагетти с чëрной икрой"
                    "spaghettiRosso"->typeTransformed="Спагетти с красной икрой"
                }
            }
            "Горячие закуски"->{
                when(colum){
                    "uovasalmone"->typeTransformed="Блины с красной икрой"
                    "patatefunghi"->typeTransformed="Блины с картошкой и грибами"
                    "carne"->typeTransformed="Блины с мясом"
                    "funghiformaggi"->typeTransformed="Блины с грибами и сыром"
                    "granofunghi"->typeTransformed="Блины с гречкой и грибами"
                    "patatesalmone"->typeTransformed="Блины с картошкой, лососем и красной икрой"
                    "juiliene"->typeTransformed="Жульен"
                }
            }
            "Первые блюда"->{
                when(colum){
                    "siberiani"->typeTransformed="Пельмени сибирские с мясом"
                    "brodo"->typeTransformed="Пельмени в бульоне"
                    "salmone"->typeTransformed="Пельмени «астраханские» рыбные"
                    "patate"->typeTransformed="Вареники с картошкой"
                    "tvorog"->typeTransformed="Вареники с творогом"
                    "funghi"->typeTransformed="Вареники с грибами"
                    "borshch"->typeTransformed="Борщ"
                    "solianca"->typeTransformed="Солянка сборная"
                }
            }
            "Вторые мясные блюда"->{
                when(colum){
                    "woronoff"->typeTransformed="Филе «Воронов»"
                    "cherry"->typeTransformed="Филе «Шерри»"
                    "manzo"->typeTransformed="Филе с перцем, облитое коньяком"
                    "stro"->typeTransformed="Филе «Строганов»"
                    "strofunghi"->typeTransformed="Филе «Строганов» с белыми грибами"
                    "zharkoie"->typeTransformed="Жаркое"
                    "zharkoieverdure"->typeTransformed="«Жаркое» из овощей"
                    "gulasch"->typeTransformed="«Гуляш»"
                    "shashlyk"->typeTransformed="Шашлык по-кавказски"
                    "anatra"->typeTransformed="Утка с черносливом и яблоками"
                    "petto"->typeTransformed="Утиная грудинка с малиновым соусом"
                    "polpette"->typeTransformed="Котлеты домашние с пюре"
                    "granomanzo"->typeTransformed="Каша гречневая с мясом"
                    "granofunghi"->typeTransformed="Каша гречневая с белыми грибами"
                    "golubtzy"->typeTransformed="Голубцы"
                }
            }
            "Вторые рыбные блюда"->{
                when(colum){
                    "shashlyk"->typeTransformed="Шашлык из осетрины"
                    "storione"->typeTransformed="Осетрина по-московски"
                    "podkova"->typeTransformed="Подкова"
                    "salmoneBianca"->typeTransformed="Сëмга под белым соусом"
                    "salmoneMiele"->typeTransformed="Лосось с мëдом и горчицей"
                    "salmoneFunghi"->typeTransformed="Лосось с белыми грибами"
                }
            }
            "Гарнир"->{
                when(colum){
                    "patate"->typeTransformed="Жаренная картошка"
                    "pure"->typeTransformed="Пюре"
                    "grano"->typeTransformed="Гречневая каша"
                    "verdura"->typeTransformed="Овощи гриль"
                }
            }

        }
        return typeTransformed
    }
    fun trasformFromRussian(type: String):String{
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
            "Напитки"->typeTransformed="bevande"
            "Алкоголь"->typeTransformed="alco"

        }
        return typeTransformed;
    }

    fun transformFromRussianColum(type:String,colum:String):String{
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
            "Гарнир"->{
                when(colum){
                    "Жаренная картошка"->typeTransformed="patate"
                    "Пюре"->typeTransformed="pure"
                    "Гречневая каша"->typeTransformed="grano"
                    "Овощи гриль"->typeTransformed="verdura"
                }
            }
            "Напитки"->{
                when(colum){
                    "Сок яблочно виноградный"->typeTransformed="melaUva"
                    "Сок томатный"->typeTransformed="pomodoro"
                    "Морс клюквенный"->typeTransformed="mors"
                }
            }
            "Напитки"->{
                when(colum){
                    "Сок яблочно виноградный"->typeTransformed="melaUva"
                    "Сок томатный"->typeTransformed="pomodoro"
                    "Морс клюквенный"->typeTransformed="mors"
                }
            }
            "Алкоголь"->{
                when(colum){
                    "Vodka Beluga"->typeTransformed="beluga"
                    "Vodka Russky Standart"->typeTransformed="standart"
                    "Vodka Russky Standart Bicchiere"->typeTransformed="standartGlass"
                    "Vodka lampone"->typeTransformed="lampone"
                    "Vodka granberry"->typeTransformed="granBerry"
                    "Vodka amarena"->typeTransformed="amarena"
                    "Vodka con peppe e miele"->typeTransformed="peppe"
                    "Birra Zhygulovske"->typeTransformed="zhygulovske"
                    "Birra Bochkovoe nefiltrovane"->typeTransformed="bochkovoe"
                    "Birra Kaban"->typeTransformed="kaban"
                    "Amaro"->typeTransformed="amaro"
                    "Whisky"->typeTransformed="whisky"
                    "Rum"->typeTransformed="rum"
                    "Brendi"->typeTransformed="brendi"
                    "Cognac"->typeTransformed="cognac"
                }
        }
        }
        return typeTransformed
    }
}