package com.example.learning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
//buoc1 : Xac dinh cac phan tu se dieu khiển và khai báo các thuộc tính của lớp
     Button btnExit;
     Button btnHello;
     EditText edtName;

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

        // phai viết code bên dưới setcontentview
        //bước 2: tham chiếu
        btnExit = (Button) findViewById(R.id.btn_exit);
        btnHello =(Button) findViewById(R.id.btn_hello);
        edtName = (EditText) findViewById(R.id.edt_name);

        //buoswsv 3:
        //xử lý sự kiện
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //b4: ND xử lý logic nghiệp vụ
                //  String name = edtName.getText().toString();//toast là hiển thị rồi biến mất
                //Toast.makeText(context: MainActivity.this, text: "Xin chao ban" + name, Toast.LENGTH_LONG).show();
                Intent myIntend = new Intent(MainActivity.this, SecondActivity2.class);
                startActivity(myIntend);
            }
        });

    }
}