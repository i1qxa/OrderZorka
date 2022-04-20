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
import com.example.orderzorka.presentation.FragmentActivityProductItem.Companion.EMPTY_ID
import com.example.orderzorka.presentation.FragmentActivityProductItem.Companion.MODE_ADD
import com.example.orderzorka.presentation.FragmentActivityProductItem.Companion.MODE_EDIT
import com.example.orderzorka.presentation.FragmentActivityProductItem.Companion.MODE_UNKNOWN
import com.example.orderzorka.presentation.FragmentActivityProductItem.Companion.PRODUCT_ID
import com.example.orderzorka.presentation.FragmentActivityProductItem.Companion.SCREEN_MODE
import com.google.android.material.textfield.TextInputLayout
import java.lang.RuntimeException

class ProductItemActivity : AppCompatActivity() {

    private  var screenMode = MODE_UNKNOWN
    private  var productId = EMPTY_ID
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_item)
        parseIntent()
        launchCurrentMode()
    }

//        TODO("Реализовать открытие в режиме редактирования")
//        viewModel.getProduct(productId)
//        viewModel.productItem.observe(this){
//            etName.setText(it.productName)
//            etGroup.setText(it.groupProductId)
//            etUnit.setText(it.unitProductId)
//        }
//        btnSave.setOnClickListener {
//            val newProductItem = ProductItem(productId,etName.text.toString(),
//                etUnit.text.toString().toInt(),etGroup.text.toString().toInt())
//            viewModel.editProduct(newProductItem)
//            btnSaveAction(productId)
//        }
//
//    }
    private fun launchCurrentMode(){
    val fragment = when(screenMode){
            MODE_ADD -> FragmentActivityProductItem.newInstanceAddProduct()
            MODE_EDIT -> FragmentActivityProductItem.newInstanceEditProduct(productId)
            else -> throw RuntimeException("Unknown Screen Mode : $screenMode")
        }
    supportFragmentManager.popBackStack()
    supportFragmentManager.beginTransaction()
        .replace(R.id.product_item_container,fragment)
        .commit()
    }

    private fun parseIntent(){
        if (!intent.hasExtra(SCREEN_MODE)) throw RuntimeException("Param screen mode is absent")
        val mode = intent.getStringExtra(SCREEN_MODE)
        if (mode!= MODE_ADD && mode!= MODE_EDIT) throw RuntimeException("Unknown mode: $mode")
        screenMode = mode
        if (mode == MODE_EDIT)
        {
            if (!intent.hasExtra(PRODUCT_ID)) throw RuntimeException("Intent got no productId")
            productId = intent.getIntExtra(PRODUCT_ID, EMPTY_ID)
        }
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