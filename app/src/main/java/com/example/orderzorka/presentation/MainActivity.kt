package com.example.orderzorka.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orderzorka.R
import com.example.orderzorka.data.ProductApplication
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var rvAdapter:ProductListAdapter
    private lateinit var mainViewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = MainViewModel((application as ProductApplication).repository)
        setupRecyclerView()
        mainViewModel.allProducts.observe(this) { product ->
            product.let { rvAdapter.submitList(it) }
        }

    val btnAdd = findViewById<FloatingActionButton>(R.id.fabAdd)
    btnAdd.setOnClickListener {
        val intent = ProductItemActivity.newIntentAddProduct(this)
        startActivity(intent)
    }
    }
    private fun setupRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.rv_product_item)
        rvAdapter = ProductListAdapter()
        recyclerView.adapter = rvAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        setupProductItemClickListener()
    }
    private fun setupProductItemClickListener(){
        rvAdapter.onProductItemClickListener = {
            val intent = ProductItemActivity.newIntentEditProduct(this,it.productId)
            startActivity(intent)
        }
    }



}