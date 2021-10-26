package com.mvvm.test.ui.fragment.productlist.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.test.R
import com.mvvm.test.ui.fragment.productlist.ProductListFragment
import com.mvvm.test.ui.fragment.productlist.model.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_product_item.view.*

class ProductsListAdapter(val frag: ProductListFragment, val list: List<Product>) :
    RecyclerView.Adapter<ProductsListAdapter.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsListAdapter.Holder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_product_item, parent, false)


        return Holder(view);
    }

    override fun onBindViewHolder(holder: ProductsListAdapter.Holder, position: Int) {
        list.get(position).let {
            Picasso.get().load(it.prod_image).placeholder(R.drawable.placeholder)
                .into(holder.itemView.imageIV)
            holder.itemView.titleTV.setText(it.prod_name)
            holder.itemView.sizeTV.setText("Size " + it.prod_min_order_qty)
            holder.itemView.colorTV.setText(it.cat_name)
            holder.itemView.discountPriceTV.setText("USD " + it.finalprice)

            holder.itemView.amountTV.setText("" + (if (it.discount == 0) "" else "USD " + it.price))

            holder.itemView.setTag(it)
            holder.itemView.setOnClickListener {
                var product = it.getTag() as Product
                var bundle = Bundle();
                bundle.putParcelable("data", product)

                frag.findNavController()
                    .navigate(R.id.action_productListFragment_to_productDetailFragment, bundle)

            }
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }
}