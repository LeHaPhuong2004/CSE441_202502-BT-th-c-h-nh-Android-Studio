package com.example.kotlin.utils

import android.database.sqlite.SQLiteOpenHelper
//githubcompLIOT
class DatabaseHelper : SQLiteOpenHelper {
    constructor(Context):super(context, Database)



    companion object{
        val DATABASE_VERSION=1
        val DATABASE_NAME
    }
}