package com.example.sharedpreference

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
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
import com.example.sharedpreference.ui.theme.SHAREDPREFERENCETheme

class MainActivity : ComponentActivity() {

    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSave: Button
    private lateinit var btnDelete: Button
    private lateinit var btnShow: Button

    private lateinit var preHelper: PreferenceHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preHelper = PreferenceHelper(this)

        edtUsername = findViewById<EditText>(R.id.edt_username)
        edtPassword = findViewById<EditText>(R.id.edt_password)
        btnSave = findViewById<Button>(R.id.btn_save)
        btnDelete = findViewById<Button>(R.id.btn_delete)
        btnShow = findViewById<Button>(R.id.btn_show)


        btnSave.setOnClickListener { onSaveClicked(it) }
        btnDelete.setOnClickListener { onDeleteClicked(it) }
        btnShow.setOnClickListener { onShowClicked(it) }

    }

    fun onSaveClicked(view: View) {
        val username = edtUsername.text.toString()
        val password = edtPassword.text.toString()
        preHelper.saveData(username, password)
        edtUsername.setText("")
        edtPassword.setText("")
    }

    fun onDeleteClicked(view: View) {
        val username = edtUsername.text.toString()
        val password = edtPassword.text.toString()
        preHelper.clearData()
        edtUsername.setText("")
        edtPassword.setText("")
    }

    fun onShowClicked(view: View) {
        val (username, password) = preHelper.getData()

        edtUsername.setText(username)
        edtPassword.setText(password)
    }


}

