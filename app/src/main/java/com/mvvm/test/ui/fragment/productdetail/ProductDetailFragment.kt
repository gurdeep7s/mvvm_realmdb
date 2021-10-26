package com.mvvm.test.ui.fragment.productdetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mvvm.test.R
import com.mvvm.test.ui.fragment.productlist.model.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_product_item.view.*
import kotlinx.android.synthetic.main.fragment_product_detail.*

class ProductDetailFragment : Fragment() {

    private var data: Product? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        data = arguments?.getParcelable<Product>("data")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        data?.let {
            Picasso.get().load(it.prod_image).placeholder(R.drawable.placeholder)
                .into(imageIV)
            titleTV.setText(it.prod_name)
            sizeTV.setText("Size " + it.prod_min_order_qty)
            colorTV.setText(it.cat_name)
            discountPriceTV.setText("USD " + it.finalprice)
            amountTV.setText("" + (if (it.discount == 0) "" else "USD " + it.price))
        }
    }


}