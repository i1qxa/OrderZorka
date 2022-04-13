package com.example.orderzorka.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.orderzorka.R
import com.example.orderzorka.data.ProductApplication
import com.example.orderzorka.domain.productItem.ProductItem
import com.google.android.material.textfield.TextInputLayout
import java.lang.RuntimeException

class ProductItemActivity : AppCompatActivity() {
    private lateinit var viewModel:ProductItemViewModel

    private lateinit var tilName:TextInputLayout
    private lateinit var etName:EditText
    private lateinit var tilGroup:TextInputLayout
    private lateinit var etGroup:EditText
    private lateinit var tilUnit:TextInputLayout
    private lateinit var etUnit:EditText
    private lateinit var btnSave:Button

    private  var screenMode = MODE_UNKNOWN
    private  var productId = EMPTY_ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_item)
        viewModel = ProductItemViewModel((application as ProductApplication).repository)
        initViews()
        parseIntent()
        launchCurrentMode()
        launchAddMode()
        finishWork()

    }
    private fun launchAddMode(){
        val newProductItem = ProductItem(0,etName.text.toString(),
            etUnit.text.toString().toInt(), etGroup.text.toString().toInt())
        btnSave.setOnClickListener {
            viewModel.insertProduct(newProductItem)

        }

    }
    private fun launchEditMode(){
        viewModel.getProduct(productId)
        viewModel.productItem.observe(this){
            etName.setText(it.productName)
            etGroup.setText(it.groupProductId)
            etUnit.setText(it.unitProductId)
        }
        btnSave.setOnClickListener {
            var newProductItem = ProductItem(productId,etName.text.toString(),
                etUnit.text.toString().toInt(),etGroup.text.toString().toInt())
            viewModel.editProduct(newProductItem)
        }

    }
    private fun launchCurrentMode(){
        when(screenMode){
            MODE_ADD -> launchAddMode()
            MODE_EDIT -> launchEditMode()
        }
    }
    fun finishWork(){
        viewModel.shouldCloseScreen.observe(this){
            finish()
        }
    }

    private fun parseIntent(){
        if (!intent.hasExtra(EXTRA_SCREEN_MODE)) throw RuntimeException("Param screen mode is absent")
        val mode = intent.getStringExtra(EXTRA_SCREEN_MODE)
        if (mode!= MODE_ADD && mode!= MODE_EDIT) throw RuntimeException("Unknown mode: $mode")
        screenMode = mode
        if (mode == MODE_EDIT)
        {
            if (!intent.hasExtra(PRODUCT_ID)) throw RuntimeException("Intent got no productId")
            productId = intent.getIntExtra(PRODUCT_ID, EMPTY_ID)
        }
    }

    private fun initViews(){
        tilName = findViewById(R.id.tilName)
        etName = findViewById(R.id.etName)
        tilGroup = findViewById(R.id.tilGroup)
        etGroup = findViewById(R.id.etGroup)
        tilUnit = findViewById(R.id.tilUnit)
        etUnit = findViewById(R.id.etUnit)
        btnSave = findViewById(R.id.btnSaveProduct)
    }

    companion object{
        const val EXTRA_SCREEN_MODE = "extra_screen_mode"
        const val MODE_ADD = "mode_add"
        const val MODE_EDIT = "mode_edit"
        const val PRODUCT_ID = "product_id"
        const val MODE_UNKNOWN = "mode_unknown"
        const val EMPTY_ID = -1
        fun newIntentAddProduct(context: Context): Intent {
            val intent = Intent(context, ProductItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_ADD)
            return intent
        }
        fun newIntentEditProduct(context: Context, productId:Int):Intent{
            val intent = Intent(context, ProductItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_EDIT)
            intent.putExtra(PRODUCT_ID,productId)
            return intent
        }

    }
}