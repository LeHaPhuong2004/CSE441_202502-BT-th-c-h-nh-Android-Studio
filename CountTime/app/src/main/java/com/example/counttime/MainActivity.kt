package com.example.counttime

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
import com.example.counttime.ui.theme.CountTimeTheme

class MainActivity : ComponentActivity() {
    private lateinit var textView: TextView
    private var seconds = 0
    private var running = false
    private val handler = Handler(Looper.getMainLooper())

    private val runnable = object : Runnable {
        @SuppressLint("SetTextI18n")
        override fun run() {
            if (running) {
                seconds++
                textView.text = "Time: $seconds s"
                handler.postDelayed(this, 1000)
            }
        }
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        textView = findViewById(R.id.textView)
        running = true
        handler.post(runnable)
    }

    override fun onDestroy() {
        super.onDestroy()
        running = false
        handler.removeCallbacks(runnable)
    }
}

