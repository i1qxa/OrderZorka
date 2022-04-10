package com.example.orderzorka.presentation.product

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.orderzorka.R
import com.example.orderzorka.presentation.ProductItemViewModel
import com.google.android.material.textfield.TextInputLayout

class ProductItemActivity : AppCompatActivity() {
    private lateinit var viewModel: ProductItemViewModel

    private lateinit var tilName:TextInputLayout
    private lateinit var etName:EditText
    private lateinit var rvGroup:RecyclerView
    private lateinit var rvUnit:RecyclerView
    private lateinit var btnSave:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_item)
        viewModel = ViewModelProvider(this)[ProductItemViewModel::class.java]
        initViews()

    }
    private fun initViews(){
        tilName = findViewById<TextInputLayout>(R.id.tilName)
        etName = findViewById(R.id.etName)
        rvGroup = findViewById(R.id.rvGroupSelect)
        rvUnit = findViewById(R.id.rvUnit)
        btnSave = findViewById(R.id.btnSave)

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