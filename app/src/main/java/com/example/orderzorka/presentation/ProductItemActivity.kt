package com.example.orderzorka.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.orderzorka.R

class ProductItemActivity : AppCompatActivity() {
    private lateinit var viewModel:ProductItemViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_item)
        viewModel = ViewModelProvider(this)[ProductItemViewModel::class.java]

    }
    fun newIntentAddProduct(context: Context): Intent {
        val intent = Intent(context, ProductItemActivity::class.java)
        intent.putExtra(EXTRA_SCREEN_MODE, MODE_ADD)
        return intent
    }
    companion object{
        const val EXTRA_SCREEN_MODE = "extra_screen_mode"
        const val MODE_ADD = "mode_add"
    }
}