package com.mvvm.test.database


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mvvm.test.ui.fragment.productlist.model.Product
import com.mvvm.test.util.Constants


@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: Product)


    @Query("SELECT DISTINCT * FROM "+Constants.TABLE_NAME)
    suspend fun getProducts(): List<Product>

}