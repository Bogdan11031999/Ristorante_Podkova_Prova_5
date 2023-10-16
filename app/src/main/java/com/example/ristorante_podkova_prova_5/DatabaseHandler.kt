package com.example.ristorante_podkova_prova_5
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

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
        private const val KEY_ID_DESERT = "id_desert"
        private const val TABLE_DESERT = "desert"
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
        createTablesDesert(db)
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

    private fun createTablesDesert(db: SQLiteDatabase) {
        val createTableDesert = """
            CREATE TABLE IF NOT EXISTS $TABLE_DESERT (
                $KEY_ID_DESERT INTEGER PRIMARY KEY,
                torta DOUBLE,
                prugne DOUBLE,
                crepeNutella DOUBLE,
                crepeMiele DOUBLE,
                crepeLatte DOUBLE,
                crepeMarmellata DOUBLE,
                gelatoCiocolato DOUBLE,
                gelatoAmarene DOUBLE,
                gelatoMiele DOUBLE,
                gelatoMarmellata DOUBLE,
                sorbetto DOUBLE,
                chiaveEsternaTavolo INTEGER UNIQUE,
                FOREIGN KEY (chiaveEsternaTavolo) REFERENCES $TABLE_TAVOLO($KEY_ID)
            )
        """.trimIndent()

        db.execSQL(createTableDesert)

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
                    "$TABLE_DESERT",
                    null,
                    contentValues,
                    SQLiteDatabase.CONFLICT_ABORT
                )
            }
        } catch (e: Exception) {
            // Gestisci l'eccezione qui se necessario
        }
    }

    @SuppressLint("Range")


    fun inserisciDato(tabella: String, colonna: String, valore: Double, chiaveEsternaTavolo: Int) {
        val db = this.readableDatabase
        val contentValues = ContentValues()
        contentValues.put(colonna, valore)


        val whereClause = "chiaveEsternaTavolo = ?"
        val whereArgs = arrayOf(chiaveEsternaTavolo.toString())

        val rowsUpdated = db.update(tabella, contentValues, whereClause, whereArgs)

        if (rowsUpdated > 0) {
            println("Aggiornamento riuscito. Righe modificate: $rowsUpdated")
        } else {
            println("Nessuna riga aggiornata.")
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
}












