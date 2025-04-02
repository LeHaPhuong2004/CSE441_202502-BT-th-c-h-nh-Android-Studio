package com.example.udp

import UDPReceiver
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import kotlin.concurrent.thread

class MainActivity : ComponentActivity() {
    private lateinit var udpReceiver: UDPReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvReceivedMessages = findViewById<TextView>(R.id.tvReceivedMessages)
        val etMessage = findViewById<EditText>(R.id.etMessage)
        val etIP = findViewById<EditText>(R.id.etIpAddress)
        val btnSend = findViewById<Button>(R.id.btnSend)

        // Bắt đầu nhận tin nhắn
        udpReceiver = UDPReceiver(tvReceivedMessages)
        udpReceiver.startReceiving()

        // Xử lý khi nhấn nút Gửi
        btnSend.setOnClickListener {
            val message = etMessage.text.toString()
            val ip = etIP.text.toString()
            val port = 12345 // Cổng cố định

            if (message.isNotEmpty() && ip.isNotEmpty()) {
                sendUDPMessage(message, ip, port)
            }
        }
    }

    private fun sendUDPMessage(message: String, ip: String, port: Int) {
        thread {
            try {
                val socket = DatagramSocket()
                val address = InetAddress.getByName(ip)
                val data = message.toByteArray()
                val packet = DatagramPacket(data, data.size, address, port)

                socket.send(packet)
                socket.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
