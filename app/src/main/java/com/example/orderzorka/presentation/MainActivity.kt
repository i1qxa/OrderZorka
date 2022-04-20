package com.example.orderzorka.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orderzorka.R
import com.example.orderzorka.data.ProductApplication
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var rvAdapter:ProductListAdapter
    private lateinit var mainViewModel:MainViewModel
    private var productItemContainer:FragmentContainerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        productItemContainer = findViewById(R.id.product_item_container)
        mainViewModel = MainViewModel((application as ProductApplication).repository)
        setupRecyclerView()
        mainViewModel.allProducts.observe(this) { product ->
            product.let { rvAdapter.submitList(it) }
        }

    val btnAdd = findViewById<FloatingActionButton>(R.id.fabAdd)
    btnAdd.setOnClickListener {
        if(isOnePaneMode()){
            val intent = ProductItemActivity.newIntentAddProduct(this)
            startActivity(intent)
        }
        else{
            launchFragment(FragmentActivityProductItem.newInstanceAddProduct())
        }
    }
    }

    private fun isOnePaneMode():Boolean{
        return productItemContainer == null
    }

    private fun launchFragment(fragment:Fragment){
        supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction()
            .replace(R.id.product_item_container, fragment)
            .addToBackStack(null)
            .commit()
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
            if (isOnePaneMode()){
                val intent = ProductItemActivity.newIntentEditProduct(this,it.productId)
                startActivity(intent)
            }
            else{
                launchFragment(FragmentActivityProductItem.newInstanceEditProduct(it.productId))
            }

        }
    }



}