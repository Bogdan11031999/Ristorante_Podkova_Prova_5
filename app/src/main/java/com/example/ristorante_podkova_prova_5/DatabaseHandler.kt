package com.example.ristorante_podkova_prova_5
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    private val mContext = context
    companion object {
        private const val DATABASE_NAME = "podkova.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_TAVOLO = "tavolo"
        private const val KEY_ID = "id"
        private const val KEY_ID_ANTIPASTIFREDDI = "id_antipasti_freddi"
        private const val TABLE_ANTIPASTIFREDDI = "antipastifreddi"
        private const val TABLE_ANTIPASTICALDI = "antipasticaldi"
        private const val KEY_ID_ANTIPASTICALDI = "id_antipasti_caldi"
        private const val KEY_ID_CAVIALE = "id_caviale"
        private const val TABLE_CAVIALE = "caviale"
        private const val KEY_ID_PRIMI = "id_primi"
        private const val TABLE_PRIMI = "primi"
        private const val KEY_ID_SECONDICARNE = "id_secondicarne"
        private const val TABLE_SECONDICARNE = "secondicarne"
        private const val KEY_ID_SECONDIPESCE = "id_secondipesce"
        private const val TABLE_SECONDIPESCE = "secondipesce"
        private const val KEY_ID_CONTORNI = "id_contorni"
        private const val TABLE_CONTORNI = "contorni"
        private const val KEY_ID_BOLLICINE= "id_bollicine"
        private const val TABLE_BOLLICINE = "bollicine"
        private const val KEY_ID_BIANCHI= "id_bianchi"
        private const val TABLE_BIANCHI = "bianchi"
        private const val KEY_ID_GEORGIANI= "id_georgiani"
        private const val TABLE_GEORGIANI = "georgiani"
        private const val KEY_ID_ALCO= "id_alco"
        private const val TABLE_ALCO = "alco"
        private const val KEY_ID_BEVANDE= "id_bevande"
        private const val TABLE_BEVANDE = "bevande"
        private const val KEY_ID_ROSSI= "id_rossi"
        private const val TABLE_ROSSI = "rossi"
    }

    override fun onCreate(db: SQLiteDatabase) {
        createTablesTable(db)
        createTablesAntipastiFreddi(db)
        createTablesAntipastiCaldi(db)
        createTablesCaviale(db)
        createTablesPrimi(db)
        createTablesSecondiCarne(db)
        createTablesSecondiPesci(db)
        createTablesContorni(db)
        createTablesBollicine(db)
        createTablesRossi(db)
        createTablesBianci(db)
        createTablesGeorgiani(db)
        createTablesBevande(db)
        createTablesAlco(db)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
    private fun createTablesTable(db: SQLiteDatabase) {
        val createTableTavolo = """
        CREATE TABLE IF NOT EXISTS $TABLE_TAVOLO (
            $KEY_ID INTEGER PRIMARY KEY
        )
    """.trimIndent()

        db.execSQL(createTableTavolo)

        val chiaviPrimarie = arrayOf(
            10,
            20,
            30,
            40,
            50,
            60,
            70,
            80,
            90,
            100,
            11,
            21,
            31,
            41,
            51,
            61,
            71,
            81,
            91,
            101
        )

        try {
            for (id in chiaviPrimarie) {
                val contentValues = ContentValues()
                contentValues.put("id", id)
                db.insertWithOnConflict(
                    "tavolo",
                    null,
                    contentValues,
                    SQLiteDatabase.CONFLICT_IGNORE
                )
            }
        } catch (e: Exception) {

        }
    }
    private fun createTablesAntipastiCaldi(db: SQLiteDatabase) {
        val createTableAntipastiFreddi = """
        CREATE TABLE IF NOT EXISTS $TABLE_ANTIPASTICALDI (
          $KEY_ID_ANTIPASTICALDI INTEGER PRIMARY KEY AUTOINCREMENT,
                uovasalmone DOUBLE,
                patatefunghi DOUBLE,
                carne DOUBLE,
                funghiformaggi DOUBLE,
                granofunghi DOUBLE,
                patatesalmone DOUBLE,
                juiliene DOUBLE,
                chiaveEsternaTavolo INTEGER UNIQUE,
                FOREIGN KEY (chiaveEsternaTavolo) REFERENCES $TABLE_TAVOLO($KEY_ID)
        )
    """.trimIndent()

        db.execSQL(createTableAntipastiFreddi)

        val chiaviEsterne = arrayOf(
            10,
            20,
            30,
            40,
            50,
            60,
            70,
            80,
            90,
            100,
            11,
            21,
            31,
            41,
            51,
            61,
            71,
            81,
            91,
            101
        )

        try {
            for (id in chiaviEsterne) {
                val contentValues = ContentValues()
                contentValues.put("chiaveEsternaTavolo", id)
                db.insertWithOnConflict(
                    "$TABLE_ANTIPASTICALDI",
                    null,
                    contentValues,
                    SQLiteDatabase.CONFLICT_ABORT
                )
            }
        } catch (e: Exception) {
            // Gestisci l'eccezione qui se necessario
        }
    }
    private fun createTablesAntipastiFreddi(db: SQLiteDatabase) {
        val createTableAntipastiFreddi = """
        CREATE TABLE IF NOT EXISTS $TABLE_ANTIPASTIFREDDI (
            $KEY_ID_ANTIPASTIFREDDI INTEGER PRIMARY KEY AUTOINCREMENT,
            podkova DOUBLE,
            aringa DOUBLE,
            sciuba DOUBLE,
            salumi DOUBLE,
            salmone DOUBLE,
            russa DOUBLE,
            antivodka DOUBLE,
            insalata DOUBLE,
            chiaveEsternaTavolo INTEGER UNIQUE,
            FOREIGN KEY (chiaveEsternaTavolo) REFERENCES $TABLE_TAVOLO($KEY_ID)
        )
    """.trimIndent()

        db.execSQL(createTableAntipastiFreddi)

        val chiaviEsterne = arrayOf(
            10,
            20,
            30,
            40,
            50,
            60,
            70,
            80,
            90,
            100,
            11,
            21,
            31,
            41,
            51,
            61,
            71,
            81,
            91,
            101
        )

        try {
            for (id in chiaviEsterne) {
                val contentValues = ContentValues()
                contentValues.put("chiaveEsternaTavolo", id)
                db.insertWithOnConflict(
                    "$TABLE_ANTIPASTIFREDDI",
                    null,
                    contentValues,
                    SQLiteDatabase.CONFLICT_ABORT
                )
            }
        } catch (e: Exception) {
            // Gestisci l'eccezione qui se necessario
        }
    }
    private fun createTablesCaviale(db: SQLiteDatabase) {
        val createTableCaviale = """
        CREATE TABLE IF NOT EXISTS $TABLE_CAVIALE(
            $KEY_ID_CAVIALE INTEGER PRIMARY KEY AUTOINCREMENT,
            nero DOUBLE,
            rosso DOUBLE,
            burgerRosso DOUBLE,
            burgerNero DOUBLE,
            crepeRosso DOUBLE,
            spaghettiNero DOUBLE,
            spaghettiRosso DOUBLE,
            chiaveEsternaTavolo INTEGER UNIQUE,
            FOREIGN KEY (chiaveEsternaTavolo) REFERENCES $TABLE_TAVOLO($KEY_ID)
        )
    """.trimIndent()

        db.execSQL(createTableCaviale)

        val chiaviEsterne = arrayOf(
            10,
            20,
            30,
            40,
            50,
            60,
            70,
            80,
            90,
            100,
            11,
            21,
            31,
            41,
            51,
            61,
            71,
            81,
            91,
            101
        )

        try {
            for (id in chiaviEsterne) {
                val contentValues = ContentValues()
                contentValues.put("chiaveEsternaTavolo", id)
                db.insertWithOnConflict(
                    "$TABLE_CAVIALE",
                    null,
                    contentValues,
                    SQLiteDatabase.CONFLICT_ABORT
                )
            }
        } catch (e: Exception) {
            // Gestisci l'eccezione qui se necessario
        }
    }
    private fun createTablesPrimi(db: SQLiteDatabase) {
        val createTableCaviale = """
        CREATE TABLE IF NOT EXISTS $TABLE_PRIMI(
            $KEY_ID_PRIMI INTEGER PRIMARY KEY AUTOINCREMENT,
            siberiani DOUBLE,
            brodo DOUBLE,
            salmone DOUBLE,
            patate DOUBLE,
            tvorog DOUBLE,
            funghi DOUBLE,
            borshch DOUBLE,
            solianca DOUBLE,
            chiaveEsternaTavolo INTEGER UNIQUE,
            FOREIGN KEY (chiaveEsternaTavolo) REFERENCES $TABLE_TAVOLO($KEY_ID)
        )
    """.trimIndent()

        db.execSQL(createTableCaviale)

        val chiaviEsterne = arrayOf(
            10,
            20,
            30,
            40,
            50,
            60,
            70,
            80,
            90,
            100,
            11,
            21,
            31,
            41,
            51,
            61,
            71,
            81,
            91,
            101
        )

        try {
            for (id in chiaviEsterne) {
                val contentValues = ContentValues()
                contentValues.put("chiaveEsternaTavolo", id)
                db.insertWithOnConflict(
                    "$TABLE_PRIMI",
                    null,
                    contentValues,
                    SQLiteDatabase.CONFLICT_ABORT
                )
            }
        } catch (e: Exception) {
            // Gestisci l'eccezione qui se necessario
        }
    }
    private fun createTablesSecondiCarne(db: SQLiteDatabase) {
        val createTableSecondiCarne = """
            CREATE TABLE IF NOT EXISTS $TABLE_SECONDICARNE (
                $KEY_ID_SECONDICARNE INTEGER PRIMARY KEY,
                woronoff DOUBLE,
                cherry DOUBLE,
                manzo DOUBLE,
                stro DOUBLE,
                strofunghi DOUBLE,
                zharkoie DOUBLE,
                zharkoieverdure DOUBLE,
                gulasch DOUBLE,
                shashlyk DOUBLE,
                anatra DOUBLE,
                petto DOUBLE,
                polpette DOUBLE,
                granomanzo DOUBLE,
                granofunghi DOUBLE,
                golubtzy DOUBLE,
                chiaveEsternaTavolo INTEGER UNIQUE,
                FOREIGN KEY (chiaveEsternaTavolo) REFERENCES $TABLE_TAVOLO($KEY_ID)
            )
        """.trimIndent()

        db.execSQL(createTableSecondiCarne)

        val chiaviEsterne = arrayOf(
            10,
            20,
            30,
            40,
            50,
            60,
            70,
            80,
            90,
            100,
            11,
            21,
            31,
            41,
            51,
            61,
            71,
            81,
            91,
            101
        )

        try {
            for (id in chiaviEsterne) {
                val contentValues = ContentValues()
                contentValues.put("chiaveEsternaTavolo", id)
                db.insertWithOnConflict(
                    "$TABLE_SECONDICARNE",
                    null,
                    contentValues,
                    SQLiteDatabase.CONFLICT_ABORT
                )
            }
        } catch (e: Exception) {
            // Gestisci l'eccezione qui se necessario
        }
    }
    private fun createTablesSecondiPesci(db: SQLiteDatabase) {
        val createTableSecondiPesci = """
            CREATE TABLE IF NOT EXISTS $TABLE_SECONDIPESCE (
                $KEY_ID_SECONDIPESCE INTEGER PRIMARY KEY,
                shashlyk DOUBLE,
                storione DOUBLE,
                podkova DOUBLE,
                salmoneBianca DOUBLE,
                salmoneMiele DOUBLE,
                salmoneFunghi DOUBLE,
                chiaveEsternaTavolo INTEGER UNIQUE,
                FOREIGN KEY (chiaveEsternaTavolo) REFERENCES $TABLE_TAVOLO($KEY_ID)
            )
        """.trimIndent()

        db.execSQL(createTableSecondiPesci)

        val chiaviEsterne = arrayOf(
            10,
            20,
            30,
            40,
            50,
            60,
            70,
            80,
            90,
            100,
            11,
            21,
            31,
            41,
            51,
            61,
            71,
            81,
            91,
            101
        )

        try {
            for (id in chiaviEsterne) {
                val contentValues = ContentValues()
                contentValues.put("chiaveEsternaTavolo", id)
                db.insertWithOnConflict(
                    "$TABLE_SECONDIPESCE",
                    null,
                    contentValues,
                    SQLiteDatabase.CONFLICT_ABORT
                )
            }
        } catch (e: Exception) {
            // Gestisci l'eccezione qui se necessario
        }
    }
    private fun createTablesContorni(db: SQLiteDatabase) {
        val createTableContorni = """
            CREATE TABLE IF NOT EXISTS $TABLE_CONTORNI (
                $KEY_ID_CONTORNI INTEGER PRIMARY KEY,
                patate DOUBLE,
                pure DOUBLE,
                grano DOUBLE,
                verdura DOUBLE,
                chiaveEsternaTavolo INTEGER UNIQUE,
                FOREIGN KEY (chiaveEsternaTavolo) REFERENCES $TABLE_TAVOLO($KEY_ID)
            )
        """.trimIndent()

        db.execSQL(createTableContorni)

        val chiaviEsterne = arrayOf(
            10,
            20,
            30,
            40,
            50,
            60,
            70,
            80,
            90,
            100,
            11,
            21,
            31,
            41,
            51,
            61,
            71,
            81,
            91,
            101
        )

        try {
            for (id in chiaviEsterne) {
                val contentValues = ContentValues()
                contentValues.put("chiaveEsternaTavolo", id)
                db.insertWithOnConflict(
                    "$TABLE_CONTORNI",
                    null,
                    contentValues,
                    SQLiteDatabase.CONFLICT_ABORT
                )
            }
        } catch (e: Exception) {
            // Gestisci l'eccezione qui se necessario
        }
    }
    private fun createTablesBollicine(db: SQLiteDatabase) {
        val createTableDesert = """
            CREATE TABLE IF NOT EXISTS $TABLE_BOLLICINE (
                $KEY_ID_BOLLICINE INTEGER PRIMARY KEY,
                conegliano DOUBLE,
                levante DOUBLE,
                franciacorta DOUBLE,
                billecart DOUBLE,
                moet DOUBLE,
                chiaveEsternaTavolo INTEGER UNIQUE,
                FOREIGN KEY (chiaveEsternaTavolo) REFERENCES $TABLE_TAVOLO($KEY_ID)
            )
        """.trimIndent()

        db.execSQL(createTableDesert)

        val chiaviEsterne = arrayOf(
            10, 20, 30, 40, 50, 60, 70, 80, 90, 100,
            11, 21, 31, 41, 51, 61, 71, 81, 91, 101
        )

        try {
            for (id in chiaviEsterne) {
                val contentValues = ContentValues()
                contentValues.put("chiaveEsternaTavolo", id)
                db.insertWithOnConflict(
                    "$TABLE_BOLLICINE",
                    null,
                    contentValues,
                    SQLiteDatabase.CONFLICT_ABORT
                )
            }
        } catch (e: Exception) {
            // Gestisci l'eccezione qui se necessario
        }
    }
    private fun createTablesRossi(db: SQLiteDatabase) {
        val createTableDesert = """
            CREATE TABLE IF NOT EXISTS $TABLE_ROSSI (
                $KEY_ID_ROSSI INTEGER PRIMARY KEY,
                sassela DOUBLE,
                dolcetto DOUBLE,
                nebbiolo DOUBLE,
                barolo DOUBLE,
                barbaresco DOUBLE,
                pinot DOUBLE,
                cabernet DOUBLE,
                valpolicella DOUBLE,
                amarone DOUBLE,
                rosso DOUBLE,
                chianti DOUBLE,
                nobile DOUBLE,
                brunello DOUBLE,
                zephyro DOUBLE,
                morellino DOUBLE,
                antico DOUBLE,
                chiaveEsternaTavolo INTEGER UNIQUE,
                FOREIGN KEY (chiaveEsternaTavolo) REFERENCES $TABLE_TAVOLO($KEY_ID)
            )
        """.trimIndent()

        db.execSQL(createTableDesert)

        val chiaviEsterne = arrayOf(
            10, 20, 30, 40, 50, 60, 70, 80, 90, 100,
            11, 21, 31, 41, 51, 61, 71, 81, 91, 101
        )

        try {
            for (id in chiaviEsterne) {
                val contentValues = ContentValues()
                contentValues.put("chiaveEsternaTavolo", id)
                db.insertWithOnConflict(
                    "$TABLE_ROSSI",
                    null,
                    contentValues,
                    SQLiteDatabase.CONFLICT_ABORT
                )
            }
        } catch (e: Exception) {
            // Gestisci l'eccezione qui se necessario
        }
    }
    private fun createTablesGeorgiani(db: SQLiteDatabase) {
        val createTableDesert = """
            CREATE TABLE IF NOT EXISTS $TABLE_GEORGIANI (
                $KEY_ID_GEORGIANI INTEGER PRIMARY KEY,
                kisi DOUBLE,
                rkatsiteli DOUBLE,
                saperavi DOUBLE,
                muzukani DOUBLE,
                muzukaniMarani DOUBLE,
                kindzmarauli DOUBLE,
                chiaveEsternaTavolo INTEGER UNIQUE,
                FOREIGN KEY (chiaveEsternaTavolo) REFERENCES $TABLE_TAVOLO($KEY_ID)
            )
        """.trimIndent()

        db.execSQL(createTableDesert)

        val chiaviEsterne = arrayOf(
            10, 20, 30, 40, 50, 60, 70, 80, 90, 100,
            11, 21, 31, 41, 51, 61, 71, 81, 91, 101
        )

        try {
            for (id in chiaviEsterne) {
                val contentValues = ContentValues()
                contentValues.put("chiaveEsternaTavolo", id)
                db.insertWithOnConflict(
                    "$TABLE_GEORGIANI",
                    null,
                    contentValues,
                    SQLiteDatabase.CONFLICT_ABORT
                )
            }
        } catch (e: Exception) {
            // Gestisci l'eccezione qui se necessario
        }
    }
    private fun createTablesBianci(db: SQLiteDatabase) {
        val createTableDesert = """
            CREATE TABLE IF NOT EXISTS $TABLE_BIANCHI (
                $KEY_ID_BIANCHI INTEGER PRIMARY KEY,
                gavi DOUBLE,
                roero DOUBLE,
                gewurztraminer DOUBLE,
                muller DOUBLE,
                chardonnay DOUBLE,
                sauvignon DOUBLE,
                pinot DOUBLE,
                pigato DOUBLE,
                pecorino DOUBLE,
                fiano DOUBLE,
                greco DOUBLE,
                arethusa DOUBLE,
                ribolla DOUBLE,
                chiaveEsternaTavolo INTEGER UNIQUE,
                FOREIGN KEY (chiaveEsternaTavolo) REFERENCES $TABLE_TAVOLO($KEY_ID)
            )
        """.trimIndent()

        db.execSQL(createTableDesert)

        val chiaviEsterne = arrayOf(
            10, 20, 30, 40, 50, 60, 70, 80, 90, 100,
            11, 21, 31, 41, 51, 61, 71, 81, 91, 101
        )

        try {
            for (id in chiaviEsterne) {
                val contentValues = ContentValues()
                contentValues.put("chiaveEsternaTavolo", id)
                db.insertWithOnConflict(
                    "$TABLE_BIANCHI",
                    null,
                    contentValues,
                    SQLiteDatabase.CONFLICT_ABORT
                )
            }
        } catch (e: Exception) {
            // Gestisci l'eccezione qui se necessario
        }
    }
    private fun createTablesBevande(db: SQLiteDatabase) {
        val createTableDesert = """
            CREATE TABLE IF NOT EXISTS $TABLE_BEVANDE (
                $KEY_ID_BEVANDE INTEGER PRIMARY KEY,
                melaUva DOUBLE,
                pomodoro DOUBLE,
                mors DOUBLE,
                cola DOUBLE,
                te DOUBLE,
                caffe DOUBLE,
                gasata DOUBLE,
                naturale DOUBLE,
                chiaveEsternaTavolo INTEGER UNIQUE,
                FOREIGN KEY (chiaveEsternaTavolo) REFERENCES $TABLE_TAVOLO($KEY_ID)
            )
        """.trimIndent()

        db.execSQL(createTableDesert)

        val chiaviEsterne = arrayOf(
            10, 20, 30, 40, 50, 60, 70, 80, 90, 100,
            11, 21, 31, 41, 51, 61, 71, 81, 91, 101
        )

        try {
            for (id in chiaviEsterne) {
                val contentValues = ContentValues()
                contentValues.put("chiaveEsternaTavolo", id)
                db.insertWithOnConflict(
                    "$TABLE_BEVANDE",
                    null,
                    contentValues,
                    SQLiteDatabase.CONFLICT_ABORT
                )
            }
        } catch (e: Exception) {
            // Gestisci l'eccezione qui se necessario
        }
    }
    private fun createTablesAlco(db: SQLiteDatabase) {
        val createTableDesert = """
            CREATE TABLE IF NOT EXISTS $TABLE_ALCO (
                $KEY_ID_ALCO INTEGER PRIMARY KEY,
                beluga DOUBLE,
                standart DOUBLE,
                standartGlass DOUBLE,
                lampone DOUBLE,
                granBerry DOUBLE,
                amarena DOUBLE,
                peppe DOUBLE,
                zhygulovske DOUBLE,
                bochkovoe DOUBLE,
                kaban DOUBLE,
                amaro DOUBLE,
                whisky DOUBLE,
                rum DOUBLE,
                brendi DOUBLE,
                cognac DOUBLE,
                chiaveEsternaTavolo INTEGER UNIQUE,
                FOREIGN KEY (chiaveEsternaTavolo) REFERENCES $TABLE_TAVOLO($KEY_ID)
            )
        """.trimIndent()

        db.execSQL(createTableDesert)

        val chiaviEsterne = arrayOf(
            10, 20, 30, 40, 50, 60, 70, 80, 90, 100,
            11, 21, 31, 41, 51, 61, 71, 81, 91, 101
        )

        try {
            for (id in chiaviEsterne) {
                val contentValues = ContentValues()
                contentValues.put("chiaveEsternaTavolo", id)
                db.insertWithOnConflict(
                    "$TABLE_ALCO",
                    null,
                    contentValues,
                    SQLiteDatabase.CONFLICT_ABORT
                )
            }
        } catch (e: Exception) {
            // Gestisci l'eccezione qui se necessario
        }
    }
    fun inserisciDato(tabella: String, colonna: String, valore: Double, chiaveEsternaTavolo: Int) {
        val db = this.readableDatabase
        val contentValues = ContentValues()
        contentValues.put(colonna, valore)


        val whereClause = "chiaveEsternaTavolo = ?"
        val whereArgs = arrayOf(chiaveEsternaTavolo.toString())

        val rowsUpdated = db.update(tabella, contentValues, whereClause, whereArgs)

        if (rowsUpdated > 0) {
            val toast = Toast.makeText(mContext, "Добавлено", Toast.LENGTH_SHORT)
            toast.show()
        } else {
            val toast = Toast.makeText(mContext, "Ошибка", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
    fun retrieveDataFromDataBase(chiaveEsternaTavolo: Int, tableName: String, chiavePrimaria: String): Map<String, Double> {
        val db = this.readableDatabase
        val data = mutableMapOf<String, Double>()
        val selection = "chiaveEsternaTavolo = ?"
        val selectionArgs = arrayOf(chiaveEsternaTavolo.toString())
        val cursor = db.rawQuery(
            "SELECT * FROM $tableName WHERE $selection",
            selectionArgs
        )
        if (cursor.moveToFirst()) {
            val columnNames = cursor.columnNames
            for (columnName in columnNames) {
                val columnIndex = cursor.getColumnIndex(columnName)
                val value = cursor.getDouble(columnIndex)
                if (value != null && value != 0.0) {
                    if(columnName.equals(chiavePrimaria)==false && columnName.equals("chiaveEsternaTavolo")==false){
                        data[columnName] = value
                    }
                }
            }
        }
        cursor.close()
        return data
    }


    fun setColumnValueToZero( tableName: String, columnName: String, chiaveEsterna: Int) {
        val db = this.readableDatabase
        val contentValues = ContentValues()
        contentValues.put(columnName, 0)

        val whereClause = "chiaveEsternaTavolo = ?"
        val whereArgs = arrayOf(chiaveEsterna.toString())

        val rowsUpdated = db.update(tableName, contentValues, whereClause, whereArgs)

        if (rowsUpdated > 0) {
            val toast = Toast.makeText(mContext, "Удалено", Toast.LENGTH_SHORT)
            toast.show()
        } else {
            val toast = Toast.makeText(mContext, "Ошибка", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
    fun updateDataToNullInAllTablesByChiaveEsterna( chiaveEsterna: Int) {
        val tableNames = arrayOf(
            TableConstants.TABLE_ANTIPASTIFREDDI,
            TableConstants.TABLE_ANTIPASTICALDI,
            TableConstants.TABLE_CAVIALE,
            TableConstants.TABLE_PRIMI,
            TableConstants.TABLE_SECONDICARNE,
            TableConstants.TABLE_SECONDIPESCE,
            TableConstants.TABLE_CONTORNI,
            TableConstants.TABLE_ALCO,
            TableConstants.TABLE_BOLLICINE,
            TableConstants.TABLE_BEVANDE,
            TableConstants.TABLE_ROSSI,
            TableConstants.TABLE_BIANCHI,
            TableConstants.TABLE_GEORGIANI
        )
        val toast = Toast.makeText(mContext, "Данние успешно удалини", Toast.LENGTH_SHORT)
        toast.show()
        for (tableName in tableNames) {
            updateDataToNullInTabelleByChiaveEsterna(mContext, chiaveEsterna, tableName)
        }
    }

    fun updateDataToNullInTabelleByChiaveEsterna(context: Context, chiaveEsterna: Int, tableName: String) {
        val db = context.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null)
        val contentValues = ContentValues()

        val columnNames = getTableColumnNames(db, tableName)
        val mutableColumnNames = columnNames.toMutableList()
        val keysToRemove = setOf(
            KeyConstant.KEY_ID,
            KeyConstant.KEY_ID_ANTIPASTIFREDDI,
            KeyConstant.KEY_ID_ANTIPASTICALDI,
            KeyConstant.KEY_ID_PRIMI,
            KeyConstant.KEY_ID_SECONDICARNE,
            KeyConstant.KEY_ID_SECONDIPESCE,
            KeyConstant.KEY_ID_CONTORNI,
            KeyConstant.KEY_ID_CAVIALE,
            KeyConstant.KEY_ID_BEVANDE,
            KeyConstant.KEY_ID_ROSSI,
            KeyConstant.KEY_ID_GEORGIANI,
            KeyConstant.KEY_ID_BOLLICINE,
            KeyConstant.KEY_ID_ALCO,
            KeyConstant.KEY_ID_BIANCHI
        )

// Rimuovi le chiavi specificate da columnNames
        mutableColumnNames.removeAll(keysToRemove)
        mutableColumnNames.remove("chiaveEsternaTavolo")
        for (columnName in mutableColumnNames) {
            contentValues.putNull(columnName)
        }

        val whereClause = "chiaveEsternaTavolo = ?"
        val whereArgs = arrayOf(chiaveEsterna.toString())

        db.update(tableName, contentValues, whereClause, whereArgs)
        db.close()
    }
    private fun getTableColumnNames(db: SQLiteDatabase, tableName: String): List<String> {
        val columnNames = mutableListOf<String>()
        val cursor = db.rawQuery("PRAGMA table_info($tableName)", null)
        if (cursor != null) {
            val nameColumnIndex = cursor.getColumnIndex("name")
            if (nameColumnIndex >= 0) {
                while (cursor.moveToNext()) {
                    val columnName = cursor.getString(nameColumnIndex)
                    columnNames.add(columnName)
                }
            }
            cursor.close()
        }
        return columnNames
    }
    fun getDatoFromTabella(tableName: String,columnName: String, chiaveEsterna: Int): Double? {
        val db = this.readableDatabase

        val selection = "chiaveEsternaTavolo = ?"
        val selectionArgs = arrayOf(chiaveEsterna.toString())

        val cursor = db.query(tableName,arrayOf(columnName),selection,
            selectionArgs,null,null,null
        )

        var dato: Double? = null

        val columnIndex = cursor.getColumnIndex(columnName)
        if (columnIndex != -1 && cursor.moveToFirst()) {
            dato = cursor.getDouble(columnIndex)
        }

        cursor.close()
        db.close()

        return dato
    }



}












