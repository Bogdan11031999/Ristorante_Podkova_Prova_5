package com.example.podkova_ordine

class Translator {
    fun transformFromEngToRussian(type:String,colum:String):String{
        var typeTransformed=""
        when(type){
            "Холодные закуски"->{
                when(colum){
                    "podkova"->typeTransformed="подкова"
                    "aringa"->typeTransformed="селедка"
                    "sciuba"->typeTransformed="шуба"
                    "salumi"->typeTransformed="колбаса"
                    "salmone"->typeTransformed="лосось"
                    "russa"->typeTransformed="оливье"
                    "antivodka"->typeTransformed="закуска под водку"
                    "insalata"->typeTransformed="салат из овощей"
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
                    "uovasalmone"->typeTransformed="блины с красной"
                    "patatefunghi"->typeTransformed="блины с карт"
                    "carne"->typeTransformed="Блины с мясом"
                    "funghiformaggi"->typeTransformed="блины с сыром"
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
                    "woronoff"->typeTransformed="Филе Воронов"
                    "cherry"->typeTransformed="Филе Шерри"
                    "manzo"->typeTransformed="Филе с перцем, облитое коньяком"
                    "stro"->typeTransformed="Филе Строганов"
                    "strofunghi"->typeTransformed="Филе Строганов с белыми грибами"
                    "zharkoie"->typeTransformed="Жаркое"
                    "zharkoieverdure"->typeTransformed="Жаркое из овощей"
                    "gulasch"->typeTransformed="Гуляш"
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
                    "podkova"->typeTransformed="Подкова рыба"
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
            "Напитки"->{
                when(colum){
                    "melaUva" ->typeTransformed= "Сок яблочно виноградный"
                    "pomodoro" ->typeTransformed= "Сок томатный"
                    "mors" ->typeTransformed= "Морс клюквенный"
                    "cola" ->typeTransformed= "Кока Кола"
                    "te" ->typeTransformed= "Чай"
                    "caffe" ->typeTransformed= "Кофе"
                    "gasata" ->typeTransformed= "Газированая"
                    "naturale" ->typeTransformed= "Минеральная"
                }
            }
            "Алкоголь"->{
                when(colum){
                    "beluga" ->typeTransformed= "Vodka Beluga"
                    "standart" ->typeTransformed= "Vodka Russky Standart"
                    "standartGlass" ->typeTransformed= "Vodka Russky Standart Bicchiere"
                    "lampone" ->typeTransformed= "Vodka lampone"
                    "granBerry" ->typeTransformed= "Vodka granberry"
                    "amarena" ->typeTransformed= "Vodka amarena"
                    "peppe" ->typeTransformed= "Vodka con peppe e miele"
                    "zhygulovske" ->typeTransformed= "Birra Zhygulovske"
                    "bochkovoe" ->typeTransformed= "Birra Bochkovoe nefiltrovane"
                    "kaban" ->typeTransformed= "Birra Kaban"
                    "amaro" ->typeTransformed= "Amaro"
                    "whisky" ->typeTransformed= "Whisky"
                    "rum" ->typeTransformed= "Rum"
                    "brendi" ->typeTransformed= "Brendi"
                    "cognac" ->typeTransformed= "Cognac"
                }
            }
            "Bollicine"->{
                when(colum){
                    "conegliano" -> typeTransformed = "Conegliano Valdobbiadene PS DOCG"
                    "levante" -> typeTransformed = "R.D.O.Levante"
                    "franciacorta" -> typeTransformed = "Franciacorta Brut Barone Di Erbusco"
                    "billecart" -> typeTransformed = "Billecart-Salmon Brut Reserve"
                    "moet" -> typeTransformed = "Moet Chandon Brut Imperial"
                }
            }
            "Vini Rossi"-> {
                when (colum) {
                    "sassela" -> typeTransformed = "Sassella Valtellina Superiore DOCG"
                    "dolcetto" -> typeTransformed = "Dolcetto D'Alba"
                    "etichettaNera" -> typeTransformed = "Etichetta Nera"
                    "nebbiolo" -> typeTransformed = "Nebbiolo"
                    "barolo" -> typeTransformed = "Barolo DOCG Riserva"
                    "barbaresco" -> typeTransformed = "Barbaresco DOCG Asili"
                    "pinot" -> typeTransformed = "Pinot Nero Alto Adige DOC"
                    "cabernet" -> typeTransformed = "Cabernet Sauvignon"
                    "cabernetMezzo" -> typeTransformed = "Cabernet Sauvignon ½"
                    "valpolicella" -> typeTransformed = "Valpolicella Classico DOC"
                    "amarone" -> typeTransformed = "Amarone DOC"
                    "rosso" -> typeTransformed = "Rosso Di Montepulciano"
                    "chianti" -> typeTransformed = "Chianti Classico DOCG"
                    "chiantiMezzo" -> typeTransformed = "Chianti Classico Riserva DOCG ½"
                    "nobile" -> typeTransformed = "Nobile Di Montepulciano Riserva DOCG"
                    "brunello" -> typeTransformed = "Brunello Di Montalcino Riserva DOCG"
                    "zephyro" -> typeTransformed = "Zephyro Bolgheri Rosso DOC"
                    "morellino" -> typeTransformed = "Morellino Di Scansano DOCG"
                    "antico" -> typeTransformed = "Antico Sigillo Primitivo Di Manduria DOP"
                }
            }
            "Vini Georgiani"->{
                when(colum){
                    "kisi" -> typeTransformed = "Kisi-Mtsvane"
                    "rkatsiteli" -> typeTransformed = "Rkatsiteli"
                    "saperavi" -> typeTransformed = "Saperavi"
                    "muzukani" -> typeTransformed = "Mukuzani"
                    "muzukaniBadagoni" -> typeTransformed = "Mukuzani Badagoni"
                    "muzukaniMarani" -> typeTransformed = "Mukuzani Marani"
                    "kindzmarauli" -> typeTransformed = "Kindzmarauli"
                }
            }
            "Vini Bianchi"->{
                when(colum){
                    "gavi" -> typeTransformed = "Gavi Di Gavi"
                    "roero" -> typeTransformed = "Roero Arneis"
                    "gewurztraminer" -> typeTransformed = "Gewurztraminer DOC"
                    "muller" -> typeTransformed = "Muller Thurgau DOC"
                    "chardonnay" -> typeTransformed = "Chardonnay Collio"
                    "sauvignon" -> typeTransformed = "Sauvignon Collio"
                    "pinot" -> typeTransformed = "Pinot Grigio Collio"
                    "pinotMezzo" -> typeTransformed = "Pinot Grigio Collio ½"
                    "pigato" -> typeTransformed = "Pigato Di Albenga R.l.p. DOC"
                    "pecorino" -> typeTransformed = "Pecorino Superiore"
                    "fiano" -> typeTransformed = "Fiano Di Avellino"
                    "greco" -> typeTransformed = "Greco Di Tufo"
                    "arethusa" -> typeTransformed = "Vermentino Di Sardegna DOC"
                    "ribolla" -> typeTransformed = "Ribolla Gialla"
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
            "Bollicine"->typeTransformed="bollicine"
            "Vini Rossi"->typeTransformed=TableConstants.TABLE_ROSSI
            "Vini Bianchi"->typeTransformed=TableConstants.TABLE_BIANCHI
            "Vini Georgiani"->typeTransformed=TableConstants.TABLE_GEORGIANI
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
                    "Филе Воронов"->typeTransformed="woronoff"
                    "Филе Шерри"->typeTransformed="cherry"
                    "Филе с перцем, облитое коньяком"->typeTransformed="manzo"
                    "Филе Строганов"->typeTransformed="stro"
                    "Филе Строганов с белыми грибами"->typeTransformed="strofunghi"
                    "Жаркое"->typeTransformed="zharkoie"
                    "Жаркое из овощей"->typeTransformed="zharkoieverdure"
                    "Гуляш"->typeTransformed="gulasch"
                    "Шашлык по-кавказски"->typeTransformed="shashlyk"
                    "Утка с черносливом и яблоками"->typeTransformed="anatra"
                    "Утиная грудинка с малиновым соусом"->typeTransformed="petto"
                    "Котлеты домашние с пюре"->typeTransformed="polpette"
                    "Каша гречневая с мясом"->typeTransformed="granomanzo"
                    "Каша гречневая с белыми грибами"->typeTransformed="granofunghi"
                    "Голубцы"->typeTransformed="golubtzy"
                }
            }
            //"Шашлык из осетрины", "Осетрина по-московски", "Подкова рыба", "Сëмга под белым соусом", "Лосось с мëдом и горчицей", "Лосось с белыми грибами
            "Вторые рыбные блюда"->{
                when(colum){
                    "Шашлык из осетрины"->typeTransformed="shashlyk"
                    "Осетрина по-московски"->typeTransformed="storione"
                    "Подкова рыба"->typeTransformed="podkova"
                    "Сëмга под белым соусом"->typeTransformed="salmoneBianca"
                    "Лосось с мëдом и горчицей"->typeTransformed="salmoneMiele"
                    "Лосось с белыми грибами"->typeTransformed="salmoneFunghi"
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
                    "Кока Кола"->typeTransformed="cola"
                    "Чай"->typeTransformed="te"
                    "Кофе"->typeTransformed="caffe"
                    "Газированая"->typeTransformed="gasata"
                    "Минеральная"->typeTransformed="naturale"
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
            "Bollicine"->{
                when(colum){
                    "Conegliano Valdobbiadene PS DOCG" -> typeTransformed = "conegliano"
                    "R.D.O.Levante" -> typeTransformed = "levante"
                    "Franciacorta Brut Barone Di Erbusco" -> typeTransformed = "franciacorta"
                    "Billecart-Salmon Brut Reserve" -> typeTransformed = "billecart"
                    "Moet Chandon Brut Imperial" -> typeTransformed = "moet"
                }
            }
            "Vini Rossi"->{
                when(colum){
                    "Sassella Valtellina Superiore DOCG" -> typeTransformed = "sassela"
                    "Dolcetto D'Alba" -> typeTransformed = "dolcetto"
                    "Etichetta Nera" -> typeTransformed = "etichettaNera"
                    "Nebbiolo" -> typeTransformed = "nebbiolo"
                    "Barolo DOCG Riserva" -> typeTransformed = "barolo"
                    "Barbaresco DOCG Asili" -> typeTransformed = "barbaresco"
                    "Pinot Nero Alto Adige DOC" -> typeTransformed = "pinot"
                    "Cabernet Sauvignon" -> typeTransformed = "cabernet"
                    "Cabernet Sauvignon ½" -> typeTransformed = "cabernetMezzo"
                    "Valpolicella Classico DOC" -> typeTransformed = "valpolicella"
                    "Amarone DOC" -> typeTransformed = "amarone"
                    "Rosso Di Montepulciano" -> typeTransformed = "rosso"
                    "Chianti Classico DOCG" -> typeTransformed = "chianti"
                    "Chianti Classico Riserva DOCG ½" -> typeTransformed = "chiantiMezzo"
                    "Nobile Di Montepulciano Riserva DOCG" -> typeTransformed = "nobile"
                    "Brunello Di Montalcino Riserva DOCG" -> typeTransformed = "brunello"
                    "Zephyro Bolgheri Rosso DOC" -> typeTransformed = "zephyro"
                    "Morellino Di Scansano DOCG" -> typeTransformed = "morellino"
                    "Antico Sigillo Primitivo Di Manduria DOP" -> typeTransformed = "antico"
                }
            }
            "Vini Georgiani"->{
                when(colum){
                    "Kisi-Mtsvane" -> typeTransformed = "kisi"
                    "Rkatsiteli" -> typeTransformed = "rkatsiteli"
                    "Saperavi" -> typeTransformed = "saperavi"
                    "Mukuzani" -> typeTransformed = "muzukani"
                    "Mukuzani Badagoni" -> typeTransformed = "muzukaniBadagoni"
                    "Mukuzani Marani" -> typeTransformed = "muzukaniMarani"
                    "Kindzmarauli" -> typeTransformed = "kindzmarauli"
                }
            }
            "Vini Bianchi"-> {
                when (colum) {
                    "Gavi Di Gavi" -> typeTransformed = "gavi"
                    "Roero Arneis" -> typeTransformed = "roero"
                    "Gewurztraminer DOC" -> typeTransformed = "gewurztraminer"
                    "Muller Thurgau DOC" -> typeTransformed = "muller"
                    "Chardonnay Collio" -> typeTransformed = "chardonnay"
                    "Sauvignon Collio" -> typeTransformed = "sauvignon"
                    "Pinot Grigio Collio" -> typeTransformed = "pinot"
                    "Pinot Grigio Collio ½" -> typeTransformed = "pinotMezzo"
                    "Pigato Di Albenga R.l.p. DOC" -> typeTransformed = "pigato"
                    "Pecorino Superiore" -> typeTransformed = "pecorino"
                    "Fiano Di Avellino" -> typeTransformed = "fiano"
                    "Greco Di Tufo" -> typeTransformed = "greco"
                    "Vermentino Di Sardegna DOC" -> typeTransformed = "arethusa"
                    "Ribolla Gialla" -> typeTransformed = "ribolla"
                }
            }
        }
        return typeTransformed
    }
}

