package com.example.sqlite

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "mydatabase.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "nguoidung"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_PHONE = "phone"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME ($COLUMN_NAME TEXT PRIMARY KEY, $COLUMN_PHONE TEXT)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addData(name: String, phone: String): Boolean {
        val db = writableDatabase

        // Kiểm tra xem name đã tồn tại chưa
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $COLUMN_NAME = ?", arrayOf(name))
        if (cursor.count > 0) {
            cursor.close()
            db.close()
            return false // Trả về false nếu đã tồn tại
        }
        cursor.close()

        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, name)
        contentValues.put(COLUMN_PHONE, phone)

        val result = db.insert(TABLE_NAME, null, contentValues)
        db.close()

        return result != -1L
    }

    fun editData(name: String, phone: String) {
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_PHONE, phone)
        db.update(TABLE_NAME, contentValues, "$COLUMN_NAME = ?", arrayOf(name))
        db.close()
    }

    fun deleteData(name: String) {
        val db = writableDatabase
        db.delete(TABLE_NAME, "$COLUMN_NAME = ?", arrayOf(name))
        db.close()
    }

    @SuppressLint("Recycle", "Range")
    fun showData(name: String): Pair<String, String>? {
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_NAME,
            arrayOf(COLUMN_NAME, COLUMN_PHONE),
            "$COLUMN_NAME = ?",
            arrayOf(name),
            null, null, null
        )

        if (cursor.moveToFirst()) {
            val avaiName = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
            val avaiPhone = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE))
            cursor.close()
            db.close()
            return Pair(avaiName, avaiPhone)
        }
        cursor.close()
        db.close()
        return null
    }
}
