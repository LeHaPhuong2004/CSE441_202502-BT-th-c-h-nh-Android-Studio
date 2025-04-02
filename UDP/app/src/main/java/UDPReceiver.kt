import android.os.Handler
import android.os.Looper
import android.widget.TextView
import java.net.DatagramPacket
import java.net.DatagramSocket
import kotlin.concurrent.thread

class UDPReceiver(private val textView: TextView) {

    private val port = 12345  // Cổng UDP để lắng nghe tin nhắn
    private var isRunning = true
    private val handler = Handler(Looper.getMainLooper())
    private var socket: DatagramSocket? = null  // Thêm socket để có thể đóng sau này

    fun startReceiving() {
        thread {
            try {
                socket = DatagramSocket(port)
                val buffer = ByteArray(1024)

                while (isRunning) {
                    val packet = DatagramPacket(buffer, buffer.size)
                    socket?.receive(packet)

                    val message = String(packet.data, 0, packet.length)
                    handler.post {
                        textView.append("\nNhận: $message")
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                socket?.close() // Đóng socket khi vòng lặp kết thúc
            }
        }
    }

    fun stopReceiving() {
        isRunning = false
        socket?.close() // Đóng socket để dừng receive ngay lập tức
    }
}
