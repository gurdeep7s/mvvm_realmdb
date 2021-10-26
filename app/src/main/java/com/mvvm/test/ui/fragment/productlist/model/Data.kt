package com.mvvm.test.ui.fragment.productlist.model

data class Data(
    val common: Common,
    val pages: Int,
    val products: List<Product>,
    val total: Int
)