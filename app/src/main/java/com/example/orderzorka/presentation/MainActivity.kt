package com.example.orderzorka.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orderzorka.R
import com.example.orderzorka.data.ProductApplication
import com.example.orderzorka.domain.productItem.ProductItem
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var rvAdapter:ProductListAdapter
    private val mainViewModel:MainViewModel by viewModels {
        MainViewModelFactory((application as ProductApplication).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        mainViewModel.allProducts.observe(this) { product ->
            product.let { rvAdapter.submitList(it) }
        }

    val btnAdd = findViewById<FloatingActionButton>(R.id.fabAdd)
    btnAdd.setOnClickListener {
        var newProduct = ProductItem(0,"Moloko",2,2)
        mainViewModel.insertProduct(newProduct)
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
            Toast.makeText(this,it.productId.toString(),Toast.LENGTH_SHORT).show()
        }
    }


}