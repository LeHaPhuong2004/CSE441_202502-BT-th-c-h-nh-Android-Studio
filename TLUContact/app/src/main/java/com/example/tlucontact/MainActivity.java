package com.example.tlucontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, Danhba.class);

        // Kiểm tra ID của nút vừa bấm
        if (view.getId() == R.id.btn_cbvn) {  // ID của nút hiển thị CBNV
            intent.putExtra("type", "cbnv");
        } else if (view.getId() == R.id.btn_donvi) {  // ID của nút hiển thị Đơn vị
            intent.putExtra("type", "donvi");
        }

        startActivity(intent);
    }
















}