package com.example.tcp

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
import com.example.tcp.ui.theme.TCPTheme
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket
import kotlin.concurrent.thread

class MainActivity : ComponentActivity() {
    private lateinit var etMessage: EditText
    private lateinit var btnSend: Button
    private lateinit var tvResponse: TextView

    private val serverIP = "10.0.107.140" // Thay bằng địa chỉ IP của Server
    private val serverPort = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etMessage = findViewById(R.id.etMessagee)
        btnSend = findViewById(R.id.btnSendd)
        tvResponse = findViewById(R.id.tvResponsee)

        btnSend.setOnClickListener {
            val message = etMessage.text.toString()
            if (message.isNotEmpty()) {
                sendMessage(message)
            }
        }
    }

    private fun sendMessage(message: String) {
        thread {
            try {
                val socket = Socket(serverIP, serverPort)
                val output = PrintWriter(socket.getOutputStream(), true)
                val input = BufferedReader(InputStreamReader(socket.getInputStream()))

                output.println(message) // Gửi tin nhắn đến Server

                val response = input.readLine() // Nhận phản hồi từ Server
                runOnUiThread { tvResponse.text = response }

                socket.close()
            } catch (e: Exception) {
                e.printStackTrace()
                runOnUiThread { tvResponse.text = "Không thể kết nối đến server" }
            }
        }
    }
}

