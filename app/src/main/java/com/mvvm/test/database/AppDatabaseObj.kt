package com.mvvm.test.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mvvm.test.util.Constants

object AppDatabaseObj {
    private var db: ProductDatabase? = null;
    fun initDatabaseInstance(context: Context) {
        if (db == null) {
            db = Room.databaseBuilder(
                context,
                ProductDatabase::class.java, Constants.DATABASE_NAME
            ).build()
        }
    }

    fun getDatabaseInstance(): ProductDatabase? {

        return db;
    }
}