package com.example.firebase

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class MainActivity : ComponentActivity() {
    private lateinit var btnRegister: Button
    private lateinit var btnSignIn: Button
    private lateinit var btnShow: Button
    private lateinit var edtEmail: EditText
    private lateinit var edtPass: EditText
    private lateinit var dataTextView: TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        btnRegister = findViewById(R.id.btn_register)
        btnSignIn = findViewById(R.id.btn_signin)
        btnShow = findViewById(R.id.btn_show)
        edtEmail = findViewById(R.id.edt_email)
        edtPass = findViewById(R.id.edt_pass)
        dataTextView = findViewById(R.id.textView)

        btnRegister.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPass.text.toString().trim()

            if (email.isNotEmpty() && password.length >= 6) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val userId = auth.currentUser?.uid
                            val databaseRef = FirebaseDatabase.getInstance().getReference("Users")
                            if (userId != null) {
                                val user = hashMapOf("email" to email)
                                databaseRef.child(userId).setValue(user)
                            }
                            edtEmail.setText("")
                            edtPass.setText("")
                            Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(
                                this,
                                "Đăng ký thất bại: ${task.exception?.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Email không hợp lệ hoặc mật khẩu quá ngắn!", Toast.LENGTH_SHORT).show()
            }
        }

        btnSignIn.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPass.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show()
                            edtEmail.setText("")
                            edtPass.setText("")
                        } else {
                            Toast.makeText(
                                this,
                                "Đăng nhập thất bại: ${task.exception?.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Vui lòng nhập email và mật khẩu!", Toast.LENGTH_SHORT).show()
            }
        }

        btnShow.setOnClickListener {
            val email = edtEmail.text.toString().trim()


            if (email.isNotEmpty()) {
                val currentUser = auth.currentUser
                if (currentUser != null && currentUser.email == email) {
                    dataTextView.text = "UID: ${currentUser.uid}\nEmail: ${currentUser.email}"
                } else {
                    Toast.makeText(this, "Bạn chưa đăng nhập!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Vui lòng nhập email!", Toast.LENGTH_SHORT).show()
            }
        }



    }
}
