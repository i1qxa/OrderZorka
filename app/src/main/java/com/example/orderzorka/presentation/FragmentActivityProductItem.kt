package com.example.orderzorka.presentation

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.orderzorka.R
import com.example.orderzorka.data.ProductApplication
import com.google.android.material.textfield.TextInputLayout

class FragmentActivityProductItem(
):Fragment() {
    private lateinit var viewModel:ProductItemViewModel

    private lateinit var tilName: TextInputLayout
    private lateinit var etName: EditText
    private lateinit var tilGroup:TextInputLayout
    private lateinit var etGroup:EditText
    private lateinit var tilUnit:TextInputLayout
    private lateinit var etUnit:EditText
    private lateinit var btnSave: Button

    private  var screenMode:String = MODE_UNKNOWN
    private  var productId:Int = EMPTY_ID


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_activity_product_item,container,false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParams()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ProductItemViewModel((application as ProductApplication).repository)
        initViews(view)
        launchCurrentMode()
        launchAddMode()
        viewModelObserve()
        addTextChangeListeners()
    }
    private fun addTextChangeListeners(){
        etName.addTextChangedListener(object: TextWatcher {
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
       /* viewModel.getProduct(productId)
        viewModel.productItem.observe(this){
            etName.setText(it.productName)
            etGroup.setText(it.groupProductId)
            etUnit.setText(it.unitProductId)
        }
        btnSave.setOnClickListener {
            val newProductItem = ProductItem(productId,etName.text.toString(),
                etUnit.text.toString().toInt(),etGroup.text.toString().toInt())
            viewModel.editProduct(newProductItem)
            btnSaveAction(productId)
        }*/

    }
    private fun launchCurrentMode(){
        when(screenMode){
            MODE_ADD -> launchAddMode()
            MODE_EDIT -> launchEditMode()
        }
    }
    private fun viewModelObserve(){
        viewModel.shouldCloseScreen.observe(viewLifecycleOwner){
            finish()
        }
        viewModel.errorInputName.observe(viewLifecycleOwner){
            val message = if(it){
                "Error input Name"
            }
            else{
                null
            }
            tilName.error = message
        }
        viewModel.errorInputGroup.observe(viewLifecycleOwner){
            val message = if(it){
                "Error input group"
            }
            else{
                null
            }
            tilGroup.error = message
        }
        viewModel.errorInputUnit.observe(viewLifecycleOwner){
            val message = if(it){
                "Error input Unit"
            }
            else{
                null
            }
            tilUnit.error = message
        }
    }

    private fun parseParams(){
        val args = requireArguments()
        if (!args.containsKey(SCREEN_MODE))
            throw java.lang.RuntimeException("Arguments got now SCREEN_MODE")
        screenMode = args.getString(SCREEN_MODE).toString()
        if (screenMode != MODE_ADD || screenMode!= MODE_EDIT)
            throw RuntimeException("Param screen mode is absent")
        if (screenMode == MODE_EDIT) {
            if (!args.containsKey(PRODUCT_ID))
                throw java.lang.RuntimeException("Arguments got no PRODUCT_ID")
            productId = args.getInt(PRODUCT_ID)
        }
    }

    private fun initViews(view: View){
        tilName = view.findViewById(R.id.tilName)
        etName = view.findViewById(R.id.etName)
        tilGroup = view.findViewById(R.id.tilGroup)
        etGroup = view.findViewById(R.id.etGroup)
        tilUnit = view.findViewById(R.id.tilUnit)
        etUnit = view.findViewById(R.id.etUnit)
        btnSave = view.findViewById(R.id.btnSaveProduct)
    }
    companion object{
        const val SCREEN_MODE = "extra_screen_mode"
        const val MODE_ADD = "mode_add"
        const val MODE_EDIT = "mode_edit"
        const val PRODUCT_ID = "product_id"
        const val MODE_UNKNOWN = "mode_unknown"
        const val EMPTY_ID = -1
        fun newInstanceAddProduct(): FragmentActivityProductItem {
            return FragmentActivityProductItem().apply {
                arguments = Bundle().apply {
                    putString(SCREEN_MODE, MODE_ADD)
                }
            }
        }
        fun newInstanceEditProduct(productId:Int): FragmentActivityProductItem {
            return FragmentActivityProductItem().apply {
                arguments = Bundle().apply {
                    putString(SCREEN_MODE, MODE_EDIT)
                    putInt(PRODUCT_ID, productId)
                }
            }
        }

    }
}