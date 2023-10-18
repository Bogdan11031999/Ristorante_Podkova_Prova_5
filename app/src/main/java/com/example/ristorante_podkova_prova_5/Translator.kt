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
            "Десерт"->{
                when(colum){
                    "torta"->typeTransformed="Торт"
                    "prugne"->typeTransformed="Чернослив"
                    "crepeNutella"->typeTransformed="Блины сгущенным молоком"
                    "crepeMiele"->typeTransformed="Блины с медом"
                    "crepeLatte"->typeTransformed="Блины с нутеллой"
                    "crepeMarmellata"->typeTransformed="Блины с мармеладом"
                    "gelatoCiocolato"->typeTransformed="Сливочное мороженное с шоколадом"
                    "gelatoAmarene"->typeTransformed="Сливочное мороженное с медом и орехами"
                    "gelatoMiele"->typeTransformed="Сливочное мороженное с клюквенным вареньем"
                    "gelatoMarmellata"->typeTransformed="Сливочное мороженное с вишней"
                    "sorbetto"->typeTransformed="Сорбетто с клюквой"
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
}