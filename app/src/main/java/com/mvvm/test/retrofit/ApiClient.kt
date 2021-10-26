package com.mvvm.test.retrofit


import android.content.Context

import com.google.gson.Gson
import com.mvvm.test.util.Constants

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    var retrofit: Retrofit? = null;
    fun getApiClient(context: Context): Retrofit? {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClientOne: OkHttpClient.Builder = OkHttpClient.Builder()

        httpClientOne.addInterceptor(logging)
        httpClientOne.connectTimeout(60, TimeUnit.SECONDS);
        httpClientOne.readTimeout(60, TimeUnit.SECONDS);
        httpClientOne.writeTimeout(60, TimeUnit.SECONDS);

        if (retrofit == null) {
            retrofit =
                Retrofit.Builder().baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(Gson()))
                    .client(httpClientOne.build()).build()
        }
        return retrofit
    }

}