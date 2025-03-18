package com.example.tlucontact;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    private TextView txtTen, txtSdt, txtEmail, txtChucvu, txtHocvi, txtBomon, txtDVCT;
    private ImageView imgCBNV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        // Ánh xạ UI
        txtTen = findViewById(R.id.txt_tengv);
        txtSdt = findViewById(R.id.txt_sdtgv);
        txtEmail = findViewById(R.id.txt_emailgv);
        txtChucvu = findViewById(R.id.txt_chucvugv);
        txtBomon = findViewById(R.id.txt_bomon);
        txtDVCT = findViewById(R.id.txt_donvict);
        txtHocvi = findViewById(R.id.txt_hocvigv);
        imgCBNV = findViewById(R.id.imv_gv);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String ten = "Tên: " + intent.getStringExtra("ten_donvi");
        String sdt = "Số điện thoại: " + intent.getStringExtra("sdt");
        String email = "Email: " + intent.getStringExtra("email");
        String chucvu = "Chức vụ: " + intent.getStringExtra("chuc_vu");
        String hocvi = "Học vị: "+ intent.getStringExtra("hoc_vi");
        String dvct = "Đơn vị công tác: " + intent.getStringExtra("don_vi_ct");
        String bomon = "Bộ môn: " + intent.getStringExtra("bo_mon");

        int imageResource = intent.getIntExtra("image", R.drawable.logo_tlu_ava);

        // Hiển thị dữ liệu lên UI
        txtTen.setText(ten);
        txtSdt.setText(sdt);
        txtEmail.setText(email);
        txtChucvu.setText(chucvu);
        txtBomon.setText(bomon);
        txtHocvi.setText(hocvi);
        txtDVCT.setText(dvct);
        imgCBNV.setImageResource(imageResource);
    }
}