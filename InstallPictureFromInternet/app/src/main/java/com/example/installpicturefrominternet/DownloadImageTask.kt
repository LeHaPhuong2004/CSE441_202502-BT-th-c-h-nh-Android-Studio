import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class DownloadImageTask(
    private val imageView: ImageView,
    private val progressBar: ProgressBar
) : AsyncTask<String, Int, Bitmap?>() {

    override fun onPreExecute() {
        super.onPreExecute()
        progressBar.visibility = View.VISIBLE // Hiển thị progress bar
    }

    override fun doInBackground(vararg params: String?): Bitmap? {
        val urlString = params[0] ?: return null
        var bitmap: Bitmap? = null
        try {
            val url = URL(urlString)
            val connection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()

            val fileLength = connection.contentLength // Lấy kích thước file
            val inputStream: InputStream = connection.inputStream
            val byteArray = ByteArray(fileLength)
            var totalBytesRead = 0
            var bytesRead: Int

            while (inputStream.read(byteArray, totalBytesRead, byteArray.size - totalBytesRead)
                    .also { bytesRead = it } != -1
            ) {
                totalBytesRead += bytesRead
                publishProgress((totalBytesRead * 100) / fileLength) // Cập nhật tiến trình
            }

            bitmap = BitmapFactory.decodeByteArray(byteArray, 0, totalBytesRead)
            inputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bitmap
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        val progress = values[0] ?: 0
        progressBar.progress = progress // Cập nhật progress bar
    }

    override fun onPostExecute(result: Bitmap?) {
        super.onPostExecute(result)
        progressBar.visibility = View.GONE // Ẩn progress bar
        if (result != null) {
            imageView.setImageBitmap(result) // Hiển thị ảnh lên ImageView
        }
    }
}

