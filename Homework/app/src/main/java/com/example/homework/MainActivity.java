package com.example.homework;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

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
    public void onClickButton(View view){

       StringBuilder selected = new StringBuilder("Topping: ");


        CheckBox checkBox1 = findViewById(R.id.checkBox);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        CheckBox checkBox3 = findViewById(R.id.checkBox3);
        CheckBox checkBox4 = findViewById(R.id.checkBox4);
        CheckBox checkBox5 = findViewById(R.id.checkBox5);


        if (checkBox1.isChecked()) {
            selected.append(checkBox1.getText()).append(" ");
        }
        if (checkBox2.isChecked()) {
            selected.append(checkBox2.getText()).append(" ");
        }
        if (checkBox3.isChecked()) {
            selected.append(checkBox3.getText()).append(" ");
        }
        if (checkBox4.isChecked()) {
            selected.append(checkBox4.getText()).append(" ");
        }
        if (checkBox5.isChecked()) {
            selected.append(checkBox5.getText()).append(" ");
        }


        // Hiển thị thông báo nếu không có CheckBox nào được chọn
        if (selected.toString().equals("Selected: ")) {
            selected = new StringBuilder("No options selected");
        }

        // Hiển thị Toast
        Toast.makeText(this, selected.toString(), Toast.LENGTH_SHORT).show();
    }
}