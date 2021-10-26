package com.mvvm.test.ui.fragment.productlist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.mvvm.test.R
import com.mvvm.test.ui.fragment.productlist.adapter.ProductsListAdapter
import com.mvvm.test.ui.fragment.productlist.model.Product
import kotlinx.android.synthetic.main.fragment_product_list.*

class ProductListFragment : Fragment() {

    companion object {
        fun newInstance() = ProductListFragment()
    }

    private var adapter: ProductsListAdapter? = null
    private var viewModel: ProductListViewModel? = null
    var list = ArrayList<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initVM()

    }

    private fun initAdapter() {
        if (adapter == null)
            adapter = ProductsListAdapter(this, list)

        var layoutManager = GridLayoutManager(activity, 2)
        listRV.layoutManager = layoutManager
        listRV.adapter = adapter


    }

    private fun initVM() {
        if (viewModel == null) {
            viewModel = ViewModelProvider(
                this,
                ProductListViewModelFactory(this)
            ).get(ProductListViewModel::class.java)

            progressPB.visibility = View.VISIBLE
            viewModel!!.getProductsList()

            viewModel!!.getProductList()
                .observe(requireActivity(), object : Observer<List<Product>> {
                    override fun onChanged(t: List<Product>?) {
                        progressPB.visibility = View.GONE

                        list.clear()
                        list.addAll(t!!)
                        adapter!!.notifyDataSetChanged()
                    }

                })

            viewModel!!.getErrorMessage().observe(requireActivity(), object : Observer<String> {
                override fun onChanged(t: String?) {
                    progressPB.visibility = View.GONE
                    Toast.makeText(activity, t!!, Toast.LENGTH_SHORT).show()
                }

            })
        }
    }

}