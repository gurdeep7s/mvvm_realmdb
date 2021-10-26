package com.mvvm.test.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mvvm.test.ui.fragment.productlist.model.Product

@Database(entities = arrayOf(Product::class), version = 1 ,exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class ProductDatabase :RoomDatabase() {

    abstract fun getProductDao(): ProductDao

}