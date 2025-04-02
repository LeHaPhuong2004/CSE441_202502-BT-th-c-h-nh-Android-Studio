package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.provider.CallLog
import android.telephony.TelephonyManager
import android.util.Log
import androidx.core.content.ContextCompat

class PhoneReceiver : BroadcastReceiver() {

    companion object {
        var incomingNumber: String? = null
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == TelephonyManager.ACTION_PHONE_STATE_CHANGED) {
            val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)

            if (state == TelephonyManager.EXTRA_STATE_IDLE && context != null) {
                val lastMissedCall = getLastMissedCall(context)
                if (lastMissedCall != null) {
                    Log.d("PhoneReceiver", "📞 Cuộc gọi nhỡ từ: $lastMissedCall")

                    // Gửi tin nhắn bằng Service
                    val serviceIntent = Intent(context, SmsService::class.java).apply {
                        putExtra("phoneNumber", lastMissedCall)
                    }
                    ContextCompat.startForegroundService(context, serviceIntent)
                }
            }
        }
    }

    private fun getLastMissedCall(context: Context): String? {
        val cursor: Cursor? = context.contentResolver.query(
            CallLog.Calls.CONTENT_URI,
            arrayOf(CallLog.Calls.NUMBER, CallLog.Calls.TYPE),
            "${CallLog.Calls.TYPE} = ${CallLog.Calls.MISSED_TYPE}",
            null,
            "${CallLog.Calls.DATE} DESC LIMIT 1"
        )

        return cursor?.use {
            if (it.moveToFirst()) it.getString(0) else null
        }
    }
}
