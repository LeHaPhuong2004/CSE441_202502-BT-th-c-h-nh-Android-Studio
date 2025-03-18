package com.example.kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlin.ui.theme.KotlinTheme
import com.example.kotlin.utils.DatabaseHelper

class MainActivity : ComponentActivity() {
//xd e er để lm j ntn
    //Khai báo thuộc tính của một lớp
    private lateinit var edtPhone: EditText
    private lateinit var btnSave: Button
    private lateinit var btnLoad: Button
    private lateinit var txtInfo: TextView

    @SuppressLint("MissingInflatedId", "CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    /*    edtPhone = findViewById(R.id.edt_phone);
        btnLoad = findViewById(R.id.btn_load);
        btnSave = findViewById(R.id.btn_save);
        txtInfo = findViewById(R.id.txt_info);

        btnSave.setOnClickListener{
            //lay ra tri gia nhap vao tu edt
            val phone = edtPhone.text.toString()
            //luu vao
            val sharedPreferences = getSharedPreferences("ANHYEUEM", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("PHONE", phone);
            editor.apply()
        }
        btnLoad.setOnClickListener {
            val sharedPreferences = getSharedPreferences("ANHYEUEM", MODE_PRIVATE)
            val phone = sharedPreferences.getString("PHONE", "")
            txtInfo.text = phone
        }*/

            //db brower for sqlite


        var db = DatabaseHelper(this)

    }
}
