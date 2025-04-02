package com.example.blockcall

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log

class PhoneStateReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == TelephonyManager.ACTION_PHONE_STATE_CHANGED) {
            val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)
            val incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)

            if (state == TelephonyManager.EXTRA_STATE_RINGING && incomingNumber != null) {
                Log.d("PhoneStateReceiver", "Cuộc gọi đến từ: $incomingNumber")

                // Kiểm tra số điện thoại có trong danh sách chặn không
                if (isBlockedNumber(incomingNumber, context!!)) {
                    Log.d("PhoneStateReceiver", "Chặn cuộc gọi từ: $incomingNumber")
                    endCall(context)
                }
            }
        }
    }

    private fun isBlockedNumber(number: String, context: Context): Boolean {
        // Danh sách chặn
        val blockedNumbers = listOf("+84901234567", "+84876543210")
        return blockedNumbers.contains(number)
    }

    private fun endCall(context: Context) {
        try {
            val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            val clazz = Class.forName(telephonyManager.javaClass.name)
            val method = clazz.getDeclaredMethod("getITelephony")
            method.isAccessible = true
            val telephonyInterface = method.invoke(telephonyManager)
            val endCallMethod = telephonyInterface.javaClass.getMethod("endCall")
            endCallMethod.invoke(telephonyInterface)
        } catch (e: Exception) {
            Log.e("PhoneStateReceiver", "Không thể chặn cuộc gọi: ${e.message}")
        }
    }
}
