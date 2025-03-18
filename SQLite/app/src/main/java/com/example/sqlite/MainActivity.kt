package com.example.sqlite

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var editName: EditText
    private lateinit var editPhone: EditText
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var btnAdd: Button
    private lateinit var btnEdit: Button
    private lateinit var btnDelete: Button
    private lateinit var btnShow: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editName = findViewById(R.id.edt_name)
        editPhone = findViewById(R.id.edt_phone)
        btnAdd = findViewById(R.id.btn_add)
        btnEdit = findViewById(R.id.btn_edit)
        btnDelete = findViewById(R.id.btn_delete)
        btnShow = findViewById(R.id.btn_show)

        databaseHelper = DatabaseHelper(this)

        btnAdd.setOnClickListener { onAddClicked(it) }
        btnEdit.setOnClickListener { onEditClicked(it) }
        btnDelete.setOnClickListener { onDeleteClicked(it) }
        btnShow.setOnClickListener { onShowClicked(it) }
    }

    fun onAddClicked(view: View) {
        val name = editName.text.toString().trim()
        val phone = editPhone.text.toString().trim()

        val result = databaseHelper.addData(name, phone)
        if (result) {
            Toast.makeText(this, "Thêm dữ liệu thành công!", Toast.LENGTH_SHORT).show()
            editName.setText("")
            editPhone.setText("")
        } else {
            Toast.makeText(this, "Thêm dữ liệu thất bại! Tên đã tồn tại.", Toast.LENGTH_SHORT).show()
        }
    }

    fun onEditClicked(view: View) {
        val name = editName.text.toString().trim()
        val phone = editPhone.text.toString().trim()



        databaseHelper.editData(name, phone)
        Toast.makeText(this, "Cập nhật thành công!", Toast.LENGTH_SHORT).show()
        editName.setText("")
        editPhone.setText("")
    }

    fun onDeleteClicked(view: View) {
        val name = editName.text.toString().trim()

        if (name.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập tên để xóa!", Toast.LENGTH_SHORT).show()
            return
        }

        databaseHelper.deleteData(name)
        Toast.makeText(this, "Xóa thành công!", Toast.LENGTH_SHORT).show()
        editName.setText("")
        editPhone.setText("")
    }

    fun onShowClicked(view: View) {
        val name = editName.text.toString().trim()

        if (name.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập tên để tìm kiếm!", Toast.LENGTH_SHORT).show()
            return
        }

        val data = databaseHelper.showData(name)
        if (data != null) {
            editName.setText(data.first)  // Hiển thị tên
            editPhone.setText(data.second) // Hiển thị số điện thoại
        } else {
            Toast.makeText(this, "Không tìm thấy dữ liệu!", Toast.LENGTH_SHORT).show()
        }
    }
}
