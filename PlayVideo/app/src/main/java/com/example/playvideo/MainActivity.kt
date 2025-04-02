package com.example.playvideo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
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
import com.example.playvideo.ui.theme.PlayVideoTheme
import android.app.Activity

class MainActivity : ComponentActivity() {
    private lateinit var videoView: VideoView
    private lateinit var btnChooseVideo: Button
    private lateinit var btnPlayUrl: Button
    private lateinit var edtVideoUrl: EditText
    private val PICK_VIDEO_REQUEST = 1  // Request code để chọn video

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoView = findViewById(R.id.videoView)
        btnChooseVideo = findViewById(R.id.btnChooseVideo)
        btnPlayUrl = findViewById(R.id.btnPlayUrl)
        edtVideoUrl = findViewById(R.id.edtVideoUrl)

        // Chọn video từ thiết bị
        btnChooseVideo.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_VIDEO_REQUEST)
        }

        // Phát video từ URL
        btnPlayUrl.setOnClickListener {
            val videoUrl = edtVideoUrl.text.toString()
            if (videoUrl.isNotEmpty()) {
                playVideo(Uri.parse(videoUrl))
            } else {
                Toast.makeText(this, "Vui lòng nhập URL hợp lệ!", Toast.LENGTH_SHORT).show()
            }
        }
        videoView.setOnErrorListener { _, _, _ ->
            Toast.makeText(this, "Lỗi khi phát video!", Toast.LENGTH_SHORT).show()
            true
        }

    }

    @Deprecated("This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      with the appropriate {@link ActivityResultContract} and handling the result in the\n      {@link ActivityResultCallback#onActivityResult(Object) callback}.")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_VIDEO_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedVideoUri = data.data
            if (selectedVideoUri != null) {
                playVideo(selectedVideoUri)
            }
        }
    }

    private fun playVideo(uri: Uri) {
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.start()
    }

    override fun onPause() {
        super.onPause()
        if (videoView.isPlaying) {
            videoView.pause()
        }
    }

}

