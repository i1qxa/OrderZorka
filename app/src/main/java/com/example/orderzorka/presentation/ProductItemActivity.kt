package com.example.orderzorka.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import com.example.orderzorka.R
import com.example.orderzorka.data.ProductApplication
import com.example.orderzorka.domain.productItem.ProductItem
import com.google.android.material.textfield.TextInputLayout
import java.lang.RuntimeException

class ProductItemActivity : AppCompatActivity() {
    /*private lateinit var viewModel:ProductItemViewModel

    private lateinit var tilName:TextInputLayout
    private lateinit var etName:EditText
    private lateinit var tilGroup:TextInputLayout
    private lateinit var etGroup:EditText
    private lateinit var tilUnit:TextInputLayout
    private lateinit var etUnit:EditText
    private lateinit var btnSave:Button

    private  var screenMode = MODE_UNKNOWN
    private  var productId = EMPTY_ID
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_item)
        /*viewModel = ProductItemViewModel((application as ProductApplication).repository)
        initViews()
        parseIntent()
        launchCurrentMode()
        launchAddMode()
        viewModelObserve()
        addTextChangeListeners()*/

    }
    /*private fun addTextChangeListeners(){
        etName.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputName()
            }

            override fun afterTextChanged(p0: Editable?) {
                }
        })
        etGroup.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            viewModel.resetErrorInputGroup()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
        etUnit.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            viewModel.resetErrorInputUnit()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    private fun btnSaveAction(productId: Int){
        val name = etName.text.toString()
        val group = etGroup.text.toString()
        val unit = etUnit.text.toString()
        viewModel.insertProduct(name, group, unit)
    }

    private fun launchAddMode(){
        btnSave.setOnClickListener {
            btnSaveAction(0)
        }

    }
    private fun launchEditMode(){
        TODO("Реализовать открытие в режиме редактирования")
        *//*viewModel.getProduct(productId)
        viewModel.productItem.observe(this){
            etName.setText(it.productName)
            etGroup.setText(it.groupProductId)
            etUnit.setText(it.unitProductId)
        }
        btnSave.setOnClickListener {
            *//**//*val newProductItem = ProductItem(productId,etName.text.toString(),
                etUnit.text.toString().toInt(),etGroup.text.toString().toInt())
            viewModel.editProduct(newProductItem)*//**//*
            btnSaveAction(productId)
        }
*//*
    }
    private fun launchCurrentMode(){
        when(screenMode){
            MODE_ADD -> launchAddMode()
            MODE_EDIT -> launchEditMode()
        }
    }
    private fun viewModelObserve(){
        viewModel.shouldCloseScreen.observe(this){
            finish()
        }
        viewModel.errorInputName.observe(this){
            val message = if(it){
                "Error input Name"
            }
            else{
                null
            }
            tilName.error = message
        }
        viewModel.errorInputGroup.observe(this){
            val message = if(it){
                "Error input group"
            }
            else{
                null
            }
            tilGroup.error = message
        }
        viewModel.errorInputUnit.observe(this){
            val message = if(it){
                "Error input Unit"
            }
            else{
                null
            }
            tilUnit.error = message
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
*/
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