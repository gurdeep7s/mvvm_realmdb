package com.mvvm.test

import android.app.Application
import androidx.room.RoomDatabase
import com.mvvm.test.database.AppDatabaseObj

class MyApplication : Application() {
    var db: RoomDatabase? = null;
    override fun onCreate() {
        super.onCreate()
        AppDatabaseObj.initDatabaseInstance(this)

    }

    fun String.add(a:String,b:String): String{
        return  this+a+b;
    }
}