package com.example.broadcastreceiver

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.telephony.SmsManager
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat

class SmsService : Service() {
    override fun onCreate() {
        super.onCreate()
        val notification = NotificationCompat.Builder(this, "sms_channel")
            .setContentTitle("Auto SMS")
            .setContentText("Ứng dụng đang chạy để gửi SMS")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()

        startForeground(1, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val phoneNumber = intent?.getStringExtra("phoneNumber")

        if (phoneNumber != null) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS)
                == android.content.pm.PackageManager.PERMISSION_GRANTED
            ) {
                sendSMS(phoneNumber)
            } else {
                Log.e("SmsService", "❌ Không có quyền SEND_SMS")
            }
        }

        stopSelf() // Dừng service sau khi hoàn thành công việc
        return START_NOT_STICKY
    }

    private fun sendSMS(phoneNumber: String) {
        try {
            val smsManager = SmsManager.getDefault()
            val message = "Xin chào, tôi đã bỏ lỡ cuộc gọi của bạn. Vui lòng gọi lại sau nhé!"
            smsManager.sendTextMessage(phoneNumber, null, message, null, null)
            Log.d("SmsService", "📩 Đã gửi SMS đến: $phoneNumber")
        } catch (e: Exception) {
            Log.e("SmsService", "❌ Lỗi gửi SMS: ${e.message}")
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
