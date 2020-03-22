package com.marcosapps.vendedoresml.Views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.marcosapps.vendedoresml.Adapter.ItemAdapterProduct
import com.marcosapps.vendedoresml.Banco.ProductsQueries
import com.marcosapps.vendedoresml.Models.Products

import com.marcosapps.vendedoresml.R

class ProductsList : Fragment() {

    lateinit var listView: RecyclerView

    lateinit var adapter: RecyclerView.Adapter<ItemAdapterProduct.ItemViewHolder>

    var listItems = arrayListOf<Products>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)

        toolbar?.setTitleTextColor(resources.getColor(R.color.title_ml)

        )

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view =  inflater.inflate(R.layout.fragment_products_list, container, false)

        val layout = LinearLayoutManager(activity)

        val productsBanco = ProductsQueries(activity!!.applicationContext).getAllProducts()

        if (productsBanco != null) {

            listItems = productsBanco

            listView = view.findViewById(R.id.rv) as RecyclerView

            listView.layoutManager = layout

            adapter = ItemAdapterProduct(listItems, activity!!.applicationContext)

            listView.adapter = adapter
        }

        return view
    }
}
