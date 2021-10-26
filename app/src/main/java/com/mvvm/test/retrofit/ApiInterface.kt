package com.mvvm.test.retrofit

import com.mvvm.test.ui.fragment.productlist.model.ProductListResponseModel
import com.mvvm.test.ui.fragment.productlist.model.RequestModel
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiInterface {

    @POST("products/list/1")
    suspend fun getProductsList(
        @Body request: RequestModel,
    ): ProductListResponseModel
}