package com.example.tlucontact;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Danhba extends AppCompatActivity {

    private RecyclerView rcvDanhba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danhba);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        CBNV[] cbnv = {
                new CBNV("Nguyễn Quỳnh Diệp", "0904345673", "diepnq@gmail.com", "Trưởng bộ môn", "Khoa CNTT", "Tiến sĩ", "Tin học và Kỹ thuật Tính toán", R.drawable.co_nqd),
                new CBNV("Cù Viết Dũng", "0964644986", "dungcv.dev@gmail.com", "Giảng viên", "Khoa CNTT", "Tiến sĩ", "Công nghệ phần mềm", R.drawable.thay_cvd),
                new CBNV("Lê Thế Sắc", "0978456123", "sactl@gmail.com", "Giảng viên", "Khoa CNTT", "Tiến sĩ", "Toán học", R.drawable.thay_lts),
                new CBNV("Nguyễn Bá Quảng", "0967321984", "quangbn@gmail.com", "Giảng viên cao cấp", "Khoa CNTT", "Tiến sĩ", "Tin học và Kỹ thuật Tính toán", R.drawable.thay_nbq),
                new CBNV("Kiều Tuấn Dũng", "0888400513", "dungkt@tlu.edu.vn", "Giảng viên chính", "Khoa CNTT", "Thạc sĩ", "Hệ thống thông tin", R.drawable.thay_ktd),
                new CBNV("Nguyễn Văn Nam", "0988862626", "namnv@tlu.edu.vn", "Giảng viên", "Khoa CNTT", "Thạc sĩ", "Hệ thống thông tin", R.drawable.thay_nvn),
                new CBNV("Tạ Chí Hiếu", "0998123456", "hieutc@gmail.com", "Giảng viên", "Khoa CNTT", "Thạc sĩ", "Hệ thống thông tin", R.drawable.thay_tch),
                new CBNV("Nguyễn Huy Đức", "0945678923", "nhd112223@gmail.com", "Giảng viên", "Khoa CNTT", "Tiến sĩ", "Tin học và Kỹ thuật Tính toán", R.drawable.thay_nhd),
                new CBNV("Nguyễn Quang Hoan", "0901234567", "hoannq@gmail.com", "Giảng viên cao cấp", "Khoa CNTT", "Phó giáo sư - Tiến sĩ", "Trí tuệ nhân tạo", R.drawable.thay_nqh),
                new CBNV("Nguyễn Văn Thẩm", "0937896541", "thamnv@gmail.com", "Giảng viên chính", "Khoa CNTT", "Tiến sĩ", "Tin học và Kỹ thuật Tính toán", R.drawable.thay_nvt)
        };

        Donvi[] donvi = {
                new Donvi("Khoa Công trình", "02438522024", "Email Protected", "Phòng 402, Tầng 4, Nhà A1 Đại học Thủy Lợi 175 Tây Sơn, Đống Đa, Hà Nội", R.drawable.khoa_ct),
                new Donvi("Khoa Kỹ thuật Tài nguyên nước", "0438582026", "KhoaN@tlu.edu.vn", "Phòng 305 A1, Đại học Thủy Lợi, 175 Tây Sơn Đống Đa, Hà Nội",R.drawable.logo_tlu_ava),
                new Donvi("Khoa Cơ khí", "043853082", "KhoaM@tlu.edu.vn", "Phòng 312-314 A1, Đại học Thủy Lợi, 175 Tây Sơn, Đống Đa, Hà Nội", R.drawable.khoa_ck),
                new Donvi("Khoa Điện - Điện tử", "02438528025", "vpkhoae@tlu.edu.vn", "Phòng 401, 403 A1, Đại học Thủy Lợi, 175 Tây Sơn, Đống Đa, Hà Nội", R.drawable.logo_tlu_ava),
                new Donvi("Khoa Kinh tế quản lý", "0438522028", "KhoaK@tlu.edu.vn", "Phòng 206-207 A5, Trường Đại học Thủy lợi, 175 Tây Sơn, Đống Đa, Hà Nội", R.drawable.logo_tlu_ava),
                new Donvi("Khoa Công nghệ thông tin", "02435632211", "vpkcntt@tlu.edu.vn", "Nhà C1 Trường Đại học Thủy Lợi, 175 Tây Sơn, Đống Đa, Hà Nội",R.drawable.logo_tlu_ava),
                new Donvi("Khoa Hóa và Môi trường", "02435640704", "Email Protected", "Phòng 316 nhà A5, 175 Tây Sơn, Đống Đa, Hà Nội", R.drawable.khoa_hvmt),
                new Donvi("Khoa Luật và Lý luận chính trị", "0243852201", "luat@gmail.com", "175 Tây Sơn, Đống Đa, Hà Nội", R.drawable.logo_tlu_ava),
                new Donvi("Trung tâm Đào tạo quốc tế", "02435652795/02438532746", "phongchtch@tlu.edu.vn", "Phòng 111- Nhà KTX số 4 - Trường Đại học Thủy Lợi - 175 Tây Sơn - Đống Đa - Hà Nội", R.drawable.ttdtqt),
                new Donvi("Trung tâm Giáo dục Quốc phòng và An ninh", "0342464347", "sie@tlu.edu.vn", "Hà Nội", R.drawable.logo_tlu_ava)
        };



        rcvDanhba = (RecyclerView) findViewById(R.id.rcv_danhba); // Khởi tạo RecyclerView

        rcvDanhba.setLayoutManager(new LinearLayoutManager(this));; // Thêm LayoutManager

        String type = getIntent().getStringExtra("type");

        if ("cbnv".equals(type)) {
            ObjectAdapter cbnvAdapter = new ObjectAdapter(cbnv);
            rcvDanhba.setAdapter(cbnvAdapter);
        } else if ("donvi".equals(type)) {
            DonviAdapter donviAdapter = new DonviAdapter(donvi);
            rcvDanhba.setAdapter(donviAdapter);
        }

      //  rcvCbnv = (RecyclerView) findViewById(R.id.rcv_danhba);
     //   ObjectAdapter cbnvAdapter = new ObjectAdapter(cbnv);
     //   rcvCbnv.setAdapter(cbnvAdapter);

     //   rcvCbnv = (RecyclerView) findViewById(R.id.rcv_danhba);
      //  DonviAdapter donviAdapter = new DonviAdapter(donvi);
       // rcvCbnv.setAdapter(donviAdapter);
    }
}