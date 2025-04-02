package com.example.recordreplay

import android.Manifest
import android.content.ContentValues
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import java.io.IOException

class MainActivity : ComponentActivity() {
    private var mediaRecorder: MediaRecorder? = null
    private var mediaPlayer: MediaPlayer? = null
    private var audioUri: Uri? = null
    private var isRecording = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRecord = findViewById<Button>(R.id.btnRecord)
        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val listView = findViewById<ListView>(R.id.listView)

        btnRecord.setOnClickListener { toggleRecording() }
        btnPlay.setOnClickListener { startPlaying() }

        requestPermissions()
    }

    private fun requestPermissions() {
        val permissions = arrayOf(
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.READ_MEDIA_AUDIO // Android 13+
        )

        if (!permissions.all { checkSelfPermission(it) == PackageManager.PERMISSION_GRANTED }) {
            requestPermissions(permissions, 0)
        }
    }

    private fun toggleRecording() {
        if (isRecording) {
            stopRecording()
        } else {
            startRecording()
        }
    }

    private fun startRecording() {
        val values = ContentValues().apply {
            put(MediaStore.Audio.Media.DISPLAY_NAME, "recording_${System.currentTimeMillis()}.3gp")
            put(MediaStore.Audio.Media.MIME_TYPE, "audio/3gpp")
        }

        val resolver = contentResolver
        audioUri = resolver.insert(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, values)

        try {
            val fileDescriptor = contentResolver.openFileDescriptor(audioUri!!, "w")?.fileDescriptor ?: return
            mediaRecorder = MediaRecorder().apply {
                setAudioSource(MediaRecorder.AudioSource.MIC)
                setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
                setOutputFile(fileDescriptor)
                prepare()
                start()
            }
            isRecording = true
            Toast.makeText(this, "Recording started", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun stopRecording() {
        mediaRecorder?.apply {
            stop()
            release()
        }
        mediaRecorder = null
        isRecording = false
        Toast.makeText(this, "Recording saved", Toast.LENGTH_SHORT).show()
        loadRecordings()
    }


    private fun startPlaying() {
        if (audioUri == null) {
            Toast.makeText(this, "No recording found", Toast.LENGTH_SHORT).show()
            return
        }

        mediaPlayer = MediaPlayer().apply {
            try {
                setDataSource(applicationContext, audioUri!!)
                prepare()
                start()
                Toast.makeText(this@MainActivity, "Playing Audio", Toast.LENGTH_SHORT).show()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }


    }
    private fun loadRecordings() {
        val recordings = mutableListOf<String>()
        val projection = arrayOf(MediaStore.Audio.Media._ID, MediaStore.Audio.Media.DISPLAY_NAME)
        val cursor = contentResolver.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            projection, null, null, MediaStore.Audio.Media.DATE_ADDED + " DESC"
        )

        cursor?.use {
            val nameIndex = it.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME)
            while (it.moveToNext()) {
                recordings.add(it.getString(nameIndex))
            }
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, recordings)
        findViewById<ListView>(R.id.listView).adapter = adapter
    }


}
