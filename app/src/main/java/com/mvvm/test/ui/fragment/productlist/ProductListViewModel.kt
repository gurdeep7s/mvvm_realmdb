package com.mvvm.test.ui.fragment.productlist

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.mvvm.test.database.AppDatabaseObj
import com.mvvm.test.retrofit.ApiClient
import com.mvvm.test.retrofit.ApiInterface
import com.mvvm.test.ui.fragment.productlist.model.Product
import com.mvvm.test.ui.fragment.productlist.model.RequestModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductListViewModel(val frag: Fragment) : ViewModel() {
    private val productsList = MutableLiveData<List<Product>>()
    private val message = MutableLiveData<String>()

    fun getProductList(): MutableLiveData<List<Product>> {
        return productsList
    }

    fun getErrorMessage(): MutableLiveData<String> {
        return message;
    }


     fun getProductsList() {

        viewModelScope.launch {

            try {
                val apiInterface =
                    ApiClient.getApiClient(frag.requireActivity())!!
                        .create(ApiInterface::class.java);
                var res = apiInterface.getProductsList(RequestModel(""))

                for (data in res.data.products) {
                    AppDatabaseObj.getDatabaseInstance()?.getProductDao()!!.insertUsers(data)
                }

                var list = AppDatabaseObj.getDatabaseInstance()!!.getProductDao().getProducts()
                productsList.value = list
            } catch (e: Exception) {
                message.value = e.localizedMessage
            }

        }
    }
}