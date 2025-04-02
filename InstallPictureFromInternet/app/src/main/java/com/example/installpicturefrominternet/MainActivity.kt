import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.activity.ComponentActivity

import com.example.installpicturefrominternet.R

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextUrl = findViewById<EditText>(R.id.edt_url)
        val buttonDownload = findViewById<Button>(R.id.button)
        val imageView = findViewById<ImageView>(R.id.installed_imv)
        val progressBar = findViewById<ProgressBar>(R.id.loading_btn)

        buttonDownload.setOnClickListener {
            val imageUrl = editTextUrl.text.toString().trim()
            if (imageUrl.isNotEmpty()) {
                DownloadImageTask(imageView, progressBar).execute(imageUrl) // Gọi AsyncTask
            } else {
                editTextUrl.error = "Vui lòng nhập URL hợp lệ!"
            }
        }
    }
}
