package com.mvvm.test.ui.fragment.productlist.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ColorOption (
    val opn_color_code: String,
    val opn_id: Int,
    val opn_value: String,
    val option_created_at: String,
    val option_created_by_id: Int,
    val option_has_image: Int,
    val option_has_sizechart: Int,
    val option_id: Int,
    val option_name: String,
    val option_type: Int,
    val option_updated_at: String,
    val option_updated_by_id: Int,
    val otv_opn_id: Int,
    val otv_pov_id: Int,
    val poption_id: Int,
    val poption_opn_id: Int,
    val poption_option_id: Int,
    val poption_prod_id: Int,
    val pov_code: String,
    val pov_default: Int,
    val pov_display_title: String,
    val pov_id: Int,
    val pov_price: String,
    val pov_prod_id: Int,
    val pov_publish: Int,
    val pov_quantity: Int,
    val pov_sku: String
) : Parcelable