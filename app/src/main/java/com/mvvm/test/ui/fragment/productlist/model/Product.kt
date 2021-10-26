package com.mvvm.test.ui.fragment.productlist.model

import android.os.Parcelable
import androidx.room.*
import com.mvvm.test.util.Constants
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = Constants.TABLE_NAME )
data class Product(
     @ColumnInfo(name ="brand_id") val brand_id: Int,
    @ColumnInfo(name ="brand_name") val brand_name: String,
    @ColumnInfo(name ="cat_id") val cat_id: Int,
    @ColumnInfo(name ="cat_name")val cat_name: String,
    @ColumnInfo(name ="color_options") val color_options: List<ColorOption>,
    @ColumnInfo(name ="discount")val discount: Int,
    @ColumnInfo(name ="favId")val favId: Int?,
    @ColumnInfo(name ="finalprice")val finalprice: String,
    @ColumnInfo(name ="pov_code")val pov_code: String?,
    @ColumnInfo(name ="pov_default")val pov_default: String?,
    @ColumnInfo(name ="pov_display_title")val pov_display_title: String?,
    @ColumnInfo(name ="pov_id")val pov_id: String?,
    @ColumnInfo(name ="pov_quantity")val pov_quantity: String?,
    @ColumnInfo(name ="price")val price: String,
     @PrimaryKey @ColumnInfo(name ="prod_id")val prod_id: Int,
    @ColumnInfo(name ="prod_image")val prod_image: String,
    @ColumnInfo(name ="prod_max_order_qty")val prod_max_order_qty: Int,
    @ColumnInfo(name ="prod_min_order_qty")val prod_min_order_qty: Int,
    @ColumnInfo(name ="prod_name")val prod_name: String,
    @ColumnInfo(name ="prod_stock_out_sellable")val prod_stock_out_sellable: Int,
    @ColumnInfo(name ="stock")val stock: Boolean,
    @ColumnInfo(name ="totalstock")val totalstock: String?,
    @ColumnInfo(name ="ufp_pov_code")val ufp_pov_code: String?
) : Parcelable