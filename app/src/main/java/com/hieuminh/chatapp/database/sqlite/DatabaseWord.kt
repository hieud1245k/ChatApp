package com.hieuminh.chatapp.database.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi
import com.hieuminh.chatapp.model.WordModel
import java.time.LocalDate

class DatabaseWord(private var context: Context) {

    private lateinit var helper : DBHelper
    private lateinit var db : SQLiteDatabase

    companion object {
        val DATABASE_NAME = "ChapApp"
        val DATABASE_TABLE = "words"
        val ID = "id"
        val TEXT = "text"
        val TIME = "time"
        val TYPE = "type"
        val DATABASE_VERSION = 1

        class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

            override fun onCreate(db: SQLiteDatabase?) {
                db!!.execSQL(" CREATE TABLE " + DATABASE_TABLE + " (" +
                        ID +  " INTEGER PRIMARY KEY ," +
                        TEXT + " TEXT NOT NULL, " +
                        TIME + " TEXT NOT NULL, " +
                        TYPE + " INTEGER NOT NULL);"
                )
            }

            override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
                db!!.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
                onCreate(db);
            }
        }
    }

    fun open() : DatabaseWord {
        helper = DBHelper(context)
        db = helper.writableDatabase
        return this
    }

    fun close() {
        helper.close()
    }

    fun createInsert(word : WordModel) : Long {
        var cv = ContentValues()
        cv.put(TEXT, word.text)
        cv.put(TIME, word.time.toString())
        cv.put(TYPE, word.type)
        return db.insert(DATABASE_TABLE,null, cv)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getAll(sql : String, selectionAgs : List<String>?) : MutableList<WordModel> {
        var list : MutableList<WordModel> = ArrayList()
        var cursor = db.rawQuery(sql, selectionAgs?.toTypedArray())

        // den dong dau cua tap du lieu
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            // doc du lieu dong hien tai
            var id = cursor.getInt(0)
            var text = cursor.getString(1)
            var time = cursor.getInt(2)
            var type = cursor.getInt(3)
            list.add(WordModel(id,LocalDate.now(), text , type))
            cursor.moveToNext()
        }
        return list
    }

    fun deleteColumn(index : Int) {
        db.delete(DATABASE_TABLE, ID + "= ?", arrayOf(index.toString()))
    }
}