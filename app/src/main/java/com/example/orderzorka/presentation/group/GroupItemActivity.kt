package com.example.orderzorka.presentation.group

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.recyclerview.widget.RecyclerView
import com.example.orderzorka.R
import com.example.orderzorka.data.ProductApplication
import com.example.orderzorka.domain.productItem.GroupItem
import com.google.android.material.textfield.TextInputLayout

class GroupItemActivity : AppCompatActivity() {
    private lateinit var viewModel:GroupItemViewModel
    private lateinit var spinnerGroupList:Spinner

    private lateinit var tilGroupName:TextInputLayout
    private lateinit var etGroupName:EditText
    private lateinit var btnSaveGroup:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_item)
        viewModel = GroupItemViewModel((application as ProductApplication).repositoryGroup)
        initViews()


    }

    private fun initViews(){
        tilGroupName = findViewById(R.id.tilGroupName)
        etGroupName = findViewById(R.id.etGroupName)
        btnSaveGroup = findViewById(R.id.btnSave)
        spinnerGroupList = findViewById(R.id.spinnerGroupList)
    }

    private fun setupSpinner(){

    }

    private fun setupBtnSaveClickListener(){
        btnSaveGroup.setOnClickListener {

        }
    }

    companion object{
        const val EXTRA_SCREEN_MODE = "extra_screen_mode"
        const val MODE_ADD = "mode_add"
        const val MODE_EDIT = "mode_edit"
    }
}