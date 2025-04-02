package com.example.tcp;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        int port = 5000; // Cổng server
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running in port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Tạo luồng riêng để xử lý Client
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String message = input.readLine(); // Nhận tin nhắn từ client
                if (message == null) break; // Nếu client ngắt kết nối thì dừng

                System.out.println("Client gửi: " + message); // Hiển thị tin nhắn trên terminal

                // Nhập phản hồi từ terminal
                System.out.print("Nhập phản hồi: ");
                String response = consoleInput.readLine();

                // Gửi phản hồi về Client
                output.println(response);
                System.out.println("Gửi phản hồi: " + response); // Hiển thị phản hồi trên terminal
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
