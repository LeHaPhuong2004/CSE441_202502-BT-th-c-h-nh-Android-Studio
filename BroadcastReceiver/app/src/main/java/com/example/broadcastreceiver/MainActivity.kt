package com.example.broadcastreceiver

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        checkPermissions()
        createNotificationChannel()
    }

    private fun checkPermissions() {
        val permissions = arrayOf(
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_CALL_LOG,
            Manifest.permission.SEND_SMS
        )

        requestPermissionLauncher.launch(permissions)
    }

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { results ->
            val granted = results.all { it.value }
            if (granted) {
                Toast.makeText(this, "✅ Đã cấp đủ quyền!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "❌ Cần cấp quyền để ứng dụng hoạt động", Toast.LENGTH_LONG).show()
            }
        }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "sms_channel", // ID của channel
                "SMS Service", // Tên hiển thị của channel
                NotificationManager.IMPORTANCE_LOW // Mức độ ưu tiên
            )

            
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }

}
